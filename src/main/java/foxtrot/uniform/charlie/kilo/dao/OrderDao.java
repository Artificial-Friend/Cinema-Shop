package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Order;
import foxtrot.uniform.charlie.kilo.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getAllByUser(User user);
}
