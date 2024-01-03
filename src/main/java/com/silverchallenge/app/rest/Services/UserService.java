package com.silverchallenge.app.rest.Services;


import com.silverchallenge.app.rest.Models.Occupation;
import com.silverchallenge.app.rest.Models.User;
import com.silverchallenge.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    private final OccupationService occupationService;

    @Autowired
    public UserService(UserRepo userRepo, OccupationService occupationService){
        this.userRepo = userRepo;
        this.occupationService = occupationService;
    }

    public void crearUsuario(User userRequest){
        User nuevoUsuario = new User();

        nuevoUsuario.setFirstName(userRequest.getFirstName());
        nuevoUsuario.setLastName(userRequest.getLastName());
        nuevoUsuario.setAge(userRequest.getAge());
        nuevoUsuario.setOccupationId(userRequest.getOccupationId());

        userRepo.save(nuevoUsuario);
    }
}
