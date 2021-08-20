package com.peaksoft.service;


import com.peaksoft.user.Role;

import java.util.List;

public interface RoleService {
    List<String> getRoleNamesToList();

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
