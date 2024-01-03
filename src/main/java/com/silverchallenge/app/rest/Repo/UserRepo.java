package com.silverchallenge.app.rest.Repo;

import com.silverchallenge.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
