package com.liticia.completeformationprojet.controller;

import com.liticia.completeformationprojet.entity.User;
import com.liticia.completeformationprojet.request.FirstnameAndLastname;
import com.liticia.completeformationprojet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping//http://localhost:8080/utilisateur
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")//http://localhost:8080/utilisateur/id
    public ResponseEntity<User> getById(@PathVariable long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

/*    @GetMapping(path = "/findByIdWithRequestParam")//http://localhost:8080/utilisateur/findByIdWithRequestParam/id
    public ResponseEntity<User> getById(@RequestParam long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @GetMapping(path = "/findByFirstname/{firstname}")//http://localhost:8080/utilisateur/findByFirstname/firstname
    public ResponseEntity<List<User>> findByFirstname(@PathVariable String firstname) {
        List<User> users = userService.findByFirstName(firstname);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByFirstnameAndLastname/{firstname}/{lastname}")//http://localhost:8080/utilisateur/findByFirstname/firstname/lastname
    public ResponseEntity<List<User>> findByFirstnameAndLastname(@PathVariable String firstname, @PathVariable String lastname) {
        List<User> users = userService.findByFirstnameAndLastname(firstname, lastname);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByFirstnameAndLastnameWithRB")//http://localhost:8080/utilisateur/findByFirstnameAndLastnameWithRB
    public ResponseEntity<List<User>> findByFirstnameAndLastname(@RequestBody FirstnameAndLastname firstnameAndLastname) {
        List<User> users = userService.findByFirstnameAndLastname(firstnameAndLastname.getFirstname(), firstnameAndLastname.getLastname());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByAge")//http://localhost:8080/utilisateur/findByAge
    public ResponseEntity<List<User>> findByAge(@RequestBody List<Integer> ages) {
        List<User> users = userService.findByAgeIn(ages);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByStarterDateAfterAndActiveFalse/{date}")//http://localhost:8080/utilisateur/findByStarterDateAfterAndActiveFalse/date
    public ResponseEntity<List<User>> findByStarterDateAfterAndActiveFalse(@PathVariable Date date) {
        List<User> users = userService.findByStarterDateAfterAndActiveFalse(date);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByRolesTitle/{title}")//http://localhost:8080/utilisateur/findByRolesTitle/title
    public ResponseEntity<List<User>> findByRolesTitle(@PathVariable String title) {
        List<User> users = userService.findByRolesTitle(title);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/findByRolesTitleAndTown/{title}/{town}")//http://localhost:8080/utilisateur/findByRolesTitleAndTown/title
    public ResponseEntity<List<User>> findByRolesTitleAndTown(@PathVariable String title, @PathVariable String town) {
        List<User> users = userService.findByRolesTitleAndAddressTown(title, town);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping//http://localhost:8080/utilisateur
    public User createAll(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping//http://localhost:8080/utilisateur
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/{id}")//http://localhost:8080/utilisateur/id
    public void delete(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
