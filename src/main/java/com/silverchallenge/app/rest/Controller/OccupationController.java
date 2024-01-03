package com.silverchallenge.app.rest.Controller;

import com.silverchallenge.app.rest.Models.Occupation;
import com.silverchallenge.app.rest.Models.User;
import com.silverchallenge.app.rest.Repo.OccupationRepo;
import com.silverchallenge.app.rest.Services.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OccupationController {
    @Autowired
    private OccupationRepo occupationRepo;

    @Autowired
    private OccupationService occupationService;

    @GetMapping("/occupations")
    public ResponseEntity<List<Occupation>> getAllOccupations() {
        List<Occupation> occupations = occupationService.getAllOccupations();
        return ResponseEntity.ok(occupations);
    }

    @PostMapping("/occupations")
    public String saveOccupation (@RequestBody Occupation occupation) {

        occupationService.createOccupation(occupation);
        return "Saved";
    }
}
