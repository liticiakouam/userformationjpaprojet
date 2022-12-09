package com.liticia.completeformationprojet.service;

import com.liticia.completeformationprojet.entity.User;
import com.liticia.completeformationprojet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isEmpty()){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    @Override
    public List<User> findByFirstnameAndLastname(String firstname, String lastname) {
        return userRepository.findByFirstnameAndLastnameWithJPQLWithNamedParameters (firstname, lastname);
    }

    @Override
    public List<User> findByAgeIn(List<Integer> ages) {
        return userRepository.findByAgeIn(ages);
    }

    @Override
    public List<User> findByStarterDateAfterAndActiveFalse(Date date) {
        return userRepository.findByStarterDateAfterAndActiveFalse(date);
    }

    @Override
    public List<User> findByRolesTitle(String title) {
        return userRepository.findByRolesTitle(title);
    }

    @Override
    public List<User> findByRolesTitleAndAddressTown(String title, String town) {
        return userRepository.findByRolesTitleAndAddressTown(title, town);
    }
}
