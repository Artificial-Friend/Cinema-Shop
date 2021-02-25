package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.SpaceportDao;
import foxtrot.uniform.charlie.kilo.model.Spaceport;
import foxtrot.uniform.charlie.kilo.service.SpaceportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceportServiceImpl implements SpaceportService {
    private final SpaceportDao spaceportDao;

    @Autowired
    public SpaceportServiceImpl(SpaceportDao spaceportDao) {
        this.spaceportDao = spaceportDao;
    }

    @Override
    public Spaceport add(Spaceport spaceport) {
        return spaceportDao.add(spaceport);
    }

    @Override
    public List<Spaceport> getAll() {
        return spaceportDao.getAll();
    }
}
