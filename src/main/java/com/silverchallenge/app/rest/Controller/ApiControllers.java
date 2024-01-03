package com.silverchallenge.app.rest.Controller;

import com.silverchallenge.app.rest.Models.Occupation;
import com.silverchallenge.app.rest.Models.User;
import com.silverchallenge.app.rest.Repo.OccupationRepo;
import com.silverchallenge.app.rest.Repo.UserRepo;
import com.silverchallenge.app.rest.Services.OccupationService;
import com.silverchallenge.app.rest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApiControllers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<Map<String, Object>> getUsers() {
        String query = "SELECT user.id, user.first_name, user.last_name, user.age,occupation.occupation " +
                "FROM crudusers.user " +
                "JOIN crudusers.occupation ON crudusers.user.occupation_id = crudusers.occupation.ID;";
        return jdbcTemplate.queryForList(query);
    }


    @PostMapping(value = "/users")
    public ResponseEntity<String> saveUser(@RequestBody User user){

        System.out.println("EL id que llega al controlador: " + user.getOccupationId());

        userService.crearUsuario(user);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupationId(user.getOccupationId());

        userRepo.save(updatedUser);
        return "Updated";
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with the id: " + id;
    }


}
