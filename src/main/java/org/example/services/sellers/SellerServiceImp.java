//package org.example.services.sellers;
//
//import org.example.data.model.goods.Product;
//import org.example.data.model.usersRegistration.Seller;
//import org.example.data.repositories.User.SellerRepository;
//import org.example.dto.request.usersRegisterRequest.SellerRequest;
//import org.example.dto.respond.usersRegisterResponse.SellerResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
////@Transactional
//public class SellerServiceImp implements SellerService {
////    @Autowired
//////    private ProductsService productsService;
////
////    @Autowired
////    private SellerRepository sellerRepository;
//
//    @Transactional
//    @Override
//    public SellerResponse sellerResponse(SellerRequest request) {
//        Seller seller = new Seller();
//
//        List<Product> productRequest = request.getProductRequest().stream().map(productRequest1 -> {
//            Product product = new Product();
//            product.setProductName(productRequest1.getProductName());
//            product.setProductPrice(productRequest1.getProductPrice());
//            product.setProductDescription(productRequest1.getProductDescription());
//            return product;
//        }).collect(Collectors.toList());
//
////        seller.setProduct(productRequest);
////        seller.setName(request.getSellerName());
////        seller.setAddress(request.getSellerAddress());
////        sellerRepository.save(seller);
//
//        SellerResponse sellerResponse = new SellerResponse();
//        sellerResponse.setMessage("Seller and the package saved successfully");
//
//        return sellerResponse;
//    }
//}
