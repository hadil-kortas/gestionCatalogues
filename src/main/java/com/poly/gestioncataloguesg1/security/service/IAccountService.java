package com.poly.gestioncataloguesg1.security.service;

import com.poly.gestioncataloguesg1.security.entities.AppUser;

public interface IAccountService {

    public void addRole(String role);
    public void addUser(String username, String password, String mail);
    public void addroletoUser(String username, String role);
    public AppUser loadUserByUserName(String username);
}
