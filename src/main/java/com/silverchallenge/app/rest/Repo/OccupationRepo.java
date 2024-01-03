package com.silverchallenge.app.rest.Repo;

import com.silverchallenge.app.rest.Models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepo extends JpaRepository<Occupation, Long> {
}
