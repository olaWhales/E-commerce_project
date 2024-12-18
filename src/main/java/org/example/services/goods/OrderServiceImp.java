package org.example.services.goods;

import org.example.data.model.goods.Address;
import org.example.data.model.goods.Order;
import org.example.data.model.goods.OrderStatus;
import org.example.data.model.goods.Product;
import org.example.data.model.user.Buyer;
import org.example.data.repositories.User.BuyerRepository;
import org.example.data.repositories.goods.OrderRepository;
import org.example.data.repositories.goods.ProductRepository;
import org.example.data.repositories.receiver.AddressRepository;
import org.example.dto.request.goodsRequest.OrderRequest;
import org.example.dto.request.receiverRequest.AddressRequest;
import org.example.dto.respond.goodsResponse.OrderResponse;
import org.example.services.usersRegistration.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
//    @Autowired
//    private OrderStatus orderStatus ;
    @Autowired
    private BuyerRepository buyerRepository ;

//    @Qualifier("buyerService")
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();
        Order order = new Order();

        OrderStatus orderStatus = OrderStatus.PENDING;
        if (orderRequest.getAddress() != null) {

            Address address = new Address();
            AddressRequest addressRequest = new AddressRequest();
            address.setStreet(addressRequest.getStreet());
            address.setCity(addressRequest.getCity());
            address.setHouseNumber(addressRequest.getHouseNumber());
            addressRepository.save(address);

            order.setAddress(address);

        }else{
            throw new IllegalArgumentException("Address is null");
        }
        Buyer buyerId = buyerRepository.findById(orderResponse.getBuyerId()).
                orElseThrow(()->new RuntimeException("Buyer id not exist"));

        List<Product> productList = productRepository.findByid(orderRequest.getProductId());


        order.setOrderStatus(orderStatus);
        order.setOrderTime(LocalDateTime.now());
        order.setBuyerId(buyerId);
        order.setDeliveryDate(LocalDate.ofEpochDay(5));
        order.setProducts(productList);
        orderRepository.save(order);

        orderRequest.setOrderDate(LocalDateTime.now());
        orderRequest.setOrderStatus(orderResponse.getOrderStatus());
        orderRequest.setAddress(orderResponse.getOrderId().getAddress());
        orderRequest.setBuyer(orderResponse.getBuyerId());
        orderRequest.setDeliveryDate(orderResponse.getDeliveryDate());

        return orderResponse;
    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest) {
        return null;
    }








    @Override
    public OrderResponse cancelOrder(OrderRequest orderRequest, String orderId) {
        return null;
    }
}
