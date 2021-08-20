package com.peaksoft.dao;

import com.peaksoft.user.Role;

import java.util.List;

public interface RoleDao{

    List<Role> getAllRoles();
    List<String> getRoleNamesToList();
    Role getRoleByName(String name);
}