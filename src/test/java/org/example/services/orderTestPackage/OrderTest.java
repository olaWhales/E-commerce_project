//package org.example.services.orderTestPackage;
//
//import org.example.data.model.goods.Address;
//import org.example.data.model.goods.OrderStatus;
//import org.example.data.model.goods.Product;
//import org.example.data.model.user.Buyer;
//import org.example.data.repositories.User.BuyerRepository;
//import org.example.data.repositories.goods.OrderRepository;
//import org.example.data.repositories.goods.ProductRepository;
//import org.example.data.repositories.receiver.AddressRepository;
//import org.example.dto.request.goodsRequest.OrderRequest;
//import org.example.dto.respond.goodsResponse.OrderResponse;
//import org.example.services.goods.OrderService;
//import org.example.data.model.goods.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@Transactional
//public class OrderTest {
//    @Autowired
//    private OrderService orderService;
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private BuyerRepository buyerRepository;
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void testThatOrderCanBeCreated() {
//        OrderRequest orderRequest = new OrderRequest();
//        Address address = new Address();
//        address.setStreet(orderRequest.getAddress().getStreet());
//        address.setCity(orderRequest.getAddress().getCity());
//        addressRepository.save(address);
//
//        Buyer buyer = new Buyer();
//        buyerRepository.save(buyer);
//        buyer.setId(orderRequest.getBuyer());
//
//        OrderStatus orderStatus = OrderStatus.PENDING;
//
//        Product product = new Product();
//        product.setProductDescription("it's liquid");
//        product.setProductName("Garri");
//        product.setProductQuantity(100);
//        product.setProductPrice(100);
//        productRepository.save(product);
//        List<Product> products = productRepository.findAll();
//        products.add(product);
//
//        Order order = new Order();
//        order.setOrderStatus(orderStatus);
//        order.setOrderTime(LocalDateTime.now());
//        order.setOrderId(order.getOrderId());
//        order.setBuyerId(buyer);
//        order.setAddress(address);
//        order.setProducts(products);
//        order.setDeliveryDate(LocalDate.of(2024,1,10));
//        orderRepository.save(order);
//
//        OrderRequest request = new OrderRequest();
//        request.setOrderStatus(orderStatus);
//        request.setOrderDate(LocalDateTime.now());
//        request.setBuyer(buyer.getId());
//        request.setDeliveryDate(LocalDate.of(2024,1,10));
//        request.setAddress(address);
//
//        OrderResponse orderResponse = orderService.createOrder(new OrderRequest());
//        orderResponse.setOrderStatus(orderStatus);
//        orderResponse.setOrderId(order);
//        orderResponse.setOrderStatus(orderStatus);
//        orderResponse.setBuyerId(buyer.getId());
//        orderResponse.setDeliveryDate(LocalDate.of(2024,1,10));
//        orderResponse.setMessage("Your order has successfully completed");
//
//        assertEquals(orderResponse, orderService.createOrder(orderRequest));
//    }
//}
