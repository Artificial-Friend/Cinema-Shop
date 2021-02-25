package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.ShipDao;
import foxtrot.uniform.charlie.kilo.model.Ship;
import foxtrot.uniform.charlie.kilo.service.ShipService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @Override
    public Ship add(Ship ship) {
        return shipDao.add(ship);
    }

    @Override
    public List<Ship> getAll() {
        return shipDao.getAll();
    }
}
