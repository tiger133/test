package com.example

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by piotr on 17.02.16.
 */
interface UserRepository extends JpaRepository<User,Long>{
    User findUserByUsername(String s);
    User findUserById(Long s);
}