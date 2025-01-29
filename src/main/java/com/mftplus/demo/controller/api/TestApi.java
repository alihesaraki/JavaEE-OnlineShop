package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import com.mftplus.demo.model.service.OrderService;
import com.mftplus.demo.model.service.ProductService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;


@Path("/test")
@Loggable
@Slf4j
public class TestApi {
    @Inject
    private ProductService productService;
    @Inject
    private OrderService orderService;
//    @Inject
//    private DeliveryService deliveryService;
//    @Inject
//    private TicketService ticketService;
//    @Inject
//    private PersonService personService;
//    @Inject
//    private UserService userService;

    @GET
    public String test() {

//        while (t.getParent() != null) {
//            System.out.println("ticket group parent: " + t.getParent().getName());
//        }

//        Permission permission = Permission.builder().permissionName("get").build();
//        Role role = Role.builder().permissionSet(Set.of(permission)).roleName("admin").build();
//        User user = User.builder().username("e").password("234").roleList(List.of(role)).build();
//        Person person = Person.builder().name("aas").family("ass").user(user).build();
//        Message message = Message.builder().text("hello").title("say-hello").user(user).build();
//        TicketGroup child = new TicketGroup();
//        TicketGroup parent = new TicketGroup();
//        child.setName("digital");
//        parent.setName("electronic");
//        TicketGroup ticketGroup = TicketGroup.builder().name("mobile").parent(parent).build();
//        Ticket ticket = Ticket.builder().messages(List.of(message)).ticketGroup(ticketGroup).title("buy").user(user).responseType("delivered").text("this is your order").build();
//        personService.save(person);
//        return person.toString();
//        ticketService.save(ticket);
//        userService.save(user);
//        return user.toString();
//        return ticket.toString();
        ProductGroup child1 = new ProductGroup();
        ProductGroup parent2 = new ProductGroup();
        child1.setName("digital");
        parent2.setName("electronic");
        ProductPropertyValue productPropertyValue = ProductPropertyValue.builder().name("64G").build();
        GroupProperty groupProperty = GroupProperty.builder().name("ram").productPropertyValue(productPropertyValue).build();
        ProductGroup productGroup = ProductGroup.builder().groupProperty(groupProperty).name("laptop").parent(parent2).build();
        Product product = Product.builder()
                .name("laptop")
                .price(20F)
                .productGroup(productGroup)
                .code(1L)
                .build();
        OrderItem orderItem = OrderItem.builder().price(300).quantity(3).product(product).build();
        Order order = Order.builder().orderStatus(OrderStatus.PENDING).discount(200).build();
        order.addItem(orderItem);
        orderService.save(order);
        log.info("order Saved");
        return String.valueOf(order.getPureAmount());
//        Delivery delivery = Delivery.builder()
//                .deliveryAddress("tehran-west")
//                .deliveryMethod(DeliveryMethod.standardShipping)
//                .deliveryStatus(DeliveryStatus.CANCELED)
//                .order(order)
//                .carrier("aaa")
//                .phoneNumber("09123234334")
//                .shippingCost(200)
//                .trackingNumber("123").build();
//        deliveryService.save(delivery);
//
//        return product.toString();

    }
}
