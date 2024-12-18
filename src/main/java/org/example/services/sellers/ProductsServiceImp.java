//package org.example.services.sellers;
//
//import org.example.data.model.goods.Product;
//import org.example.data.repositories.User.ProductRepository;
//import org.example.dto.request.goodsRequest.ProductRequest;
//import org.example.dto.respond.goodsResponse.ProductResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductsServiceImp implements ProductsService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public ProductResponse productResponse(ProductRequest productRequest) {
//        ProductResponse productResponse = new ProductResponse();
//        Product product = new Product();
//        product.setProductQuantity(String.valueOf(productRequest.getProductQuantity()));
//        product.setProductName(productRequest.getProductName());
//        product.setProductDescription(productRequest.getProductDescription());
//        product.setProductPrice(productRequest.getProductPrice());
//        productRepository.save(product);
//
////        productRequest.setProductPrice(productResponse.);
//        productResponse.setMessage(product.getProductName());
//        productResponse.setMessage("Product save successful");
//        return productResponse;
//    }
//}
