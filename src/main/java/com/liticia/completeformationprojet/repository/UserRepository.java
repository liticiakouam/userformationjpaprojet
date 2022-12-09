package com.liticia.completeformationprojet.repository;

import com.liticia.completeformationprojet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstname(String firstname);

    //serching using Jpa
    List<User> findByFirstnameAndLastname(String firstname, String lastname);

    //serching using JPQL
    @Query("SELECT u FROM User u WHERE u.firstname LIKE ?1 AND u.lastname LIKE ?2")
    List<User> findByFirstnameAndLastnameWithJPQL(String firstname, String lastname);

    //serching using JPQL with named parameters
    @Query("SELECT u FROM User u WHERE u.firstname LIKE :myFirstname AND u.lastname LIKE :myLastname")
    List<User> findByFirstnameAndLastnameWithJPQLWithNamedParameters(@Param(value = "myFirstname") String firstname, @Param(value = "myLastname") String lastname);

    List<User> findByAgeIn(List<Integer> ages);
    List<User> findByStarterDateAfterAndActiveFalse(Date date);
    List<User> findByRolesTitle(String title);
    List<User> findByRolesTitleAndAddressTown(String title, String town);

}
