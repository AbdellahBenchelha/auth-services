package com.authservices.authservices.sec.repo;

import com.authservices.authservices.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
