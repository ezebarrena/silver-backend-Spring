package com.silverchallenge.app.rest.Services;

import com.silverchallenge.app.rest.Models.Occupation;
import com.silverchallenge.app.rest.Repo.OccupationRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {

    private final OccupationRepo occupationRepo;

    @Autowired
    public OccupationService(OccupationRepo occupationRepo) { this.occupationRepo = occupationRepo;}

    public void createOccupation(Occupation request){
        Occupation newOccupation = new Occupation();
        newOccupation.setOccupation(request.getOccupation());

        occupationRepo.save(newOccupation);
    }

    public List<Occupation> getAllOccupations(){
        return occupationRepo.findAll();
    }


}
