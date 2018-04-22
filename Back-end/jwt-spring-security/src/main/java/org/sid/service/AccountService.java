package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.data.domain.Page;

public interface AccountService {
public Page<AppUser> getUsers(int page);
public void deleteUser(Long id );
public AppUser saveUser(AppUser user);
public AppRole saveRole (AppRole role);
public void addRoleToUser(String username,String roleName);
public AppUser findUserByUsername(String username);
}
