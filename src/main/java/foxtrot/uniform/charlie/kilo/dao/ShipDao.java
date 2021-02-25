package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Ship;
import java.util.List;

public interface ShipDao {
    Ship add(Ship ship);

    Ship get(Long id);

    List<Ship> getAll();
}
