package com.authservices.authservices.sec.service;

import com.authservices.authservices.sec.entities.AppRole;
import com.authservices.authservices.sec.entities.AppUser;
import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
    List<AppUser> allUsers();
}
