package org.example.services.goods;

import org.example.data.model.goods.Product;
import org.example.data.repositories.goods.ProductRepository;
import org.example.dto.request.goodsRequest.ProductRequest;
import org.example.dto.respond.goodsResponse.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductQuantity(product.getProductQuantity());
        productRepository.save(product);
        productResponse.setMessage(product.getProductName());
        productResponse.setId(product.getId());
        return productResponse;
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();

        Optional<Product> optional = productRepository.findById(productRequest.getProductId());

        if (optional.isPresent()) {
            Product product = optional.get();
            if (!product.getSeller().getId().equals(productRequest.getSellerId())) {
                productResponse.setMessage("Unauthorized: Product does not belong to the seller");
                return productResponse;
            }
            product.setProductName(productRequest.getProductName());
            product.setProductDescription(productRequest.getProductDescription());
            product.setProductPrice(productRequest.getProductPrice());
            product.setProductQuantity(productRequest.getProductQuantity());
            productRepository.save(product);

            productResponse.setMessage("Product updated successfully");
        } else {
            productResponse.setMessage("Product not found");
        }
        return productResponse;
    }

    @Override
    public ProductResponse deleteProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        Optional<Product>optional = productRepository.findById(productRequest.getProductId());
        if (optional.isPresent()) {
            Product product = optional.get();
            if(product.getId().equals(productRequest.getSellerId())){
                productRepository.delete(product);
                productResponse.setMessage("Product deleted successfully");
            }else{
                productResponse.setMessage("Unauthorized: Product does not belong to the seller");
            }
        }
        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts(Long sellerId) {
//        ProductRequest productRequest = new ProductRequest();
        List<Product> products = productRepository.findProductBySellerId(sellerId);
            if (products.isEmpty()) {
                throw new IllegalArgumentException("No products found for the given seller ID.");
            }
            List<ProductResponse> productResponses = new ArrayList<>();
            for (Product product : products) {
                ProductResponse productResponse =  new ProductResponse();
                productResponse.setProductName(product.getProductName());
                productResponse.setProductDescription(product.getProductDescription());
                productResponse.setProductPrice(product.getProductPrice());
                productResponse.setProductQuantity(product.getProductQuantity());
                productResponses.add(productResponse);
            }
            return productResponses;
        }

    @Override
    public ProductResponse getProduct(ProductRequest productRequest) {

        return null;
    }

}

