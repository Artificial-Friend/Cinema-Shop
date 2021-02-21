package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String roleName);
}
