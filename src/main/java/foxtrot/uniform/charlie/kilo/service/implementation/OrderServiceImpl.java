package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.OrderDao;
import foxtrot.uniform.charlie.kilo.lib.Inject;
import foxtrot.uniform.charlie.kilo.lib.Service;
import foxtrot.uniform.charlie.kilo.model.Order;
import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.OrderService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getAllByUser(user);
    }
}
