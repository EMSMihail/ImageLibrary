package com.aizek.ImageLibrary.repo;

import com.aizek.ImageLibrary.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
