package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.Ship;
import java.util.List;

public interface ShipService {
    Ship add(Ship ship);

    List<Ship> getAll();
}
