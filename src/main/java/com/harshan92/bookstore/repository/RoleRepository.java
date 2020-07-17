package com.harshan92.bookstore.repository;

import com.harshan92.bookstore.domain.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {

    Role findByName(String name);

}
