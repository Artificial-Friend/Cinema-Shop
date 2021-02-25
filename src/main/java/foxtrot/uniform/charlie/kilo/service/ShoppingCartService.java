package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.Flight;
import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.User;

public interface ShoppingCartService {
    void addSession(Flight flight, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
