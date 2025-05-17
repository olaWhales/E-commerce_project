//package org.example.services;
//
//\import org.example.data.model.goods.Product;
//import org.example.data.model.user.Seller;
//import org.example.data.repositories.User.SellerRepository;
//import org.example.data.repositories.goods.ProductRepository;
//import org.example.dto.request.goodsRequest.ProductRequest;
//import org.example.dto.request.usersRegisterRequest.SellerRequest;
//import org.example.dto.respond.goodsResponse.ProductResponse;
//import org.example.dto.respond.usersRegisterResponse.SellerResponse;
//import org.example.services.goods.ProductService;
//import org.example.services.usersRegistration.SellerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class SellerTest {
//    @Autowired
//    private SellerService sellerService;
//    @Autowired
//    private SellerRepository sellerRepository;
//    @Autowired
//    private ProductService productsService;
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void testToCreateProduct() {
//        ProductResponse productResponse = productsService.productResponse(new ProductRequest());
//        Product product = new Product();
//        product.setProductName("Phone");
//        product.setProductDescription("it's a green color");
//        product.setProductPrice(10000);
//        product.setProductQuantity(String.valueOf(20));
//        ProductRequest productRequest = new ProductRequest();
//        productRequest.setProductQuantity(100);
//        productRequest.setProductPrice(100000);
//        productRequest.setProductDescription("it's a green color");
//        productRequest.setProductName("Phone");
//        ProductResponse productResponse = new ProductResponse();
//        productResponse.setMessage("Product added successfully");
//        assertEquals(productResponse.getMessage() , "Product added successfully");
//    }
//
//    @Test
//    public void testToCreateSellerThatHasProduct() {
//        SellerResponse sellerResponse = sellerService.sellerResponse(new SellerRequest());
//        ProductRequest productRequest = new ProductRequest();
//        SellerRequest sellerRequest = new SellerRequest();
//        Product product = new Product();
//        productRequest.setProductQuantity(10);
//        productRequest.setProductPrice(BigDecimal.valueOf(10000).intValue());
//        productRequest.setProductQuantity(productRequest.getProductQuantity());
//        productRequest.setProductDescription("It has green color,round shape and glass body");
//        productRequest.setProductName("Phone");
//        Seller usersRegistration = new Seller();
//        sellerRequest.setSellerName("Olanrewaju");
//        sellerRequest.setSellerAddress("Lagos");
//        sellerRequest.setProductRequest(Collections.singletonList(productRequest));
//        assertEquals(sellerRequest.getSellerAddress() , "Lagos");
//        assertEquals(sellerRequest.getSellerName() , "Olanrewaju");
//        assertEquals(sellerRequest.getProductRequest() , Collections.singletonList(productRequest));
//    }
//}
