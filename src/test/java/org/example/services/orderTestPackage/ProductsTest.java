package org.example.services.orderTestPackage;

import org.example.data.model.goods.Product;
import org.example.data.model.user.Seller;
import org.example.data.repositories.User.SellerRepository;
import org.example.data.repositories.goods.ProductRepository;
import org.example.dto.request.goodsRequest.ProductRequest;
import org.example.dto.respond.goodsResponse.ProductResponse;
import org.example.services.goods.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ProductsTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Test
    public void testThatProductCanBeCreated() {
        ProductResponse productResponse = productService.addProduct(new ProductRequest());
        ProductRequest productRequest = new ProductRequest();
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductQuantity(productRequest.getProductQuantity());
        productRepository.save(product);
        productResponse.setMessage(productRequest.getProductName());
        assertEquals(productResponse.getMessage(), productRequest.getProductName());
    }

    @Test
    public void testThatProductCanBeUpdated() {
        ProductRequest productRequest = new ProductRequest();

        Seller seller = new Seller();
        seller.setId(seller.getId());
        sellerRepository.save(seller);
        Product product = new Product();
        product.setProductName("rice");
        product.setProductDescription("it's pure white");
        product.setProductPrice(1000);
        product.setProductQuantity(2);
        product.setSeller(seller);
        productRepository.save(product);
        productRequest.setProductId(product.getId());
        productRequest.setProductName("beans");
        productRequest.setProductDescription("beans are red");
        productRequest.setProductPrice(2000);
        Optional<Product> product1 = productRepository.findById(productRequest.getProductId());

        ProductResponse productResponse = productService.updateProduct(productRequest);
        productResponse.setMessage("Your product has been updated");
        assertTrue(product1.isPresent());
    }

    @Test
    public void testThatProductCanBeDeleted() {
        ProductRequest productRequest = new ProductRequest();
        Seller seller = new Seller();
        seller.setId(seller.getId());
        sellerRepository.save(seller);
        Product product = new Product();
        product.setProductName("rice");
        product.setProductDescription("it's pure white");
        product.setProductPrice(1000);
        product.setProductQuantity(2);
        product.setSeller(seller);
        productRepository.save(product);
        productRequest.setProductId(product.getId());
        productRequest.setProductName("bean");
        productRequest.setProductDescription("beans are red");
        productRequest.setProductPrice(2000);
        productRequest.setProductQuantity(45);
        productService.deleteProduct(productRequest);
        Optional<Product> product1 = productRepository.findById(productRequest.getProductId());
        assertTrue(product1.isPresent());
        ProductResponse productResponse = productService.deleteProduct(productRequest);
        productResponse.setMessage("Your product has been deleted");
        assertEquals(productResponse.getMessage() , "Your product has been deleted");
        assertEquals(productRequest.getProductName() , "bean");
        assertEquals(productRequest.getProductDescription(), "beans are red");
        assertEquals(productRequest.getProductPrice() , 2000);
        assertEquals(productRequest.getProductQuantity() , 45);
//        assertEquals();
    }

    @Test
    public void testThatUserCanFetchTheListOfTheirProduct(){
        ProductRequest productRequest = new ProductRequest();
        Seller seller = new Seller();
        seller.setId(seller.getId());
        sellerRepository.save(seller);
        System.out.println(seller);

        Product product = new Product();
        product.setProductName("rice");
        product.setProductDescription("it's pure white");
        product.setProductPrice(1000);
        product.setProductQuantity(2);
        product.setSeller(seller);
        productRepository.save(product);
        Product product1 = new Product();
        product1.setProductName("beans");
        product1.setProductDescription("beans are red");
        product1.setProductPrice(2000);
        product1.setProductQuantity(5);
        product1.setSeller(seller);
        productRepository.save(product1);
        List<ProductResponse> products = productService.getAllProducts(seller.getId());
//        List<Product> products = productRepository.findProductBySellerId(seller.getId());
        assertNotNull(products);
        ProductResponse productResponse = products.get(0);
        ProductResponse productResponse1 = products.get(1);
//        Product products1 = products.get(0);
        System.out.println(productResponse);
//        Product products2 = products.get(1);
        System.out.println(productResponse1);
        assertEquals(productResponse.getProductName() , "rice");
        assertEquals(productResponse1.getProductName(), "beans");

    }
}
