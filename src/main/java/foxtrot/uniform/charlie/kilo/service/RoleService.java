package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
