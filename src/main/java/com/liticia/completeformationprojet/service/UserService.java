package com.liticia.completeformationprojet.service;

import com.liticia.completeformationprojet.entity.User;

import java.sql.Date;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUserById(long id);
    User createUser(User user);
    User updateUser(User user);
    String deleteUser(long id);

    List<User> findByFirstName(String firstname);
    List<User> findByFirstnameAndLastname(String firstname, String lastname);

    List<User> findByAgeIn(List<Integer> ages);
    List<User> findByStarterDateAfterAndActiveFalse(Date date);

    List<User> findByRolesTitle(String title);
    List<User> findByRolesTitleAndAddressTown(String title, String town);

}
