package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.Spaceport;
import java.util.List;

public interface SpaceportService {
    Spaceport add(Spaceport spaceport);

    List<Spaceport> getAll();
}
