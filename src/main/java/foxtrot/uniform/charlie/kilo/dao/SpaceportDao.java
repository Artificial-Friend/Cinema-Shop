package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Spaceport;
import java.util.List;

public interface SpaceportDao {
    Spaceport add(Spaceport spaceport);

    Spaceport get(Long id);

    List<Spaceport> getAll();
}
