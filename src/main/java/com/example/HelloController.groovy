package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.annotation.security.RolesAllowed

/**
 * Created by piotr on 17.02.16.
 */
@RestController
class HelloController {
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    List<User> hello()
    {
       userRepository.findAll()
    }
}
