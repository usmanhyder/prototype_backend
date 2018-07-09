package com.prototype.eitproject.controller;

import com.prototype.eitproject.model.User;
import com.prototype.eitproject.repository.UserRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    public Iterable<User> findAll() {
        return repository.findAll();
    }

/*	@GetMapping(path = "/{userid}")
	public User find(@PathVariable("userid") String userid) {
		return repository.findOne(userid);
	}*/

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        User user = repository.findByUsername(username);
        if(user != null){
            repository.delete(user);
        }
    }

/*	@PutMapping(path = "/{userid}")
	public User update(@PathVariable("userid") String userid, @RequestBody User user) throws BadHttpRequest {
		if (repository.exists(userid)) {
			user.setUserid(new Integer(userid));
			return repository.save(user);
		} else {
			throw new BadHttpRequest();
		}
	}*/

    @GetMapping(path = "/{username}")
    public User getUserByName(@PathVariable("username") String username){
        User user = repository.findByUsername(username); //your custom method called here
        return user;
    }

    @PutMapping(path = "/{username}")
    public User update(@PathVariable("username") String username, @RequestBody User user) throws BadHttpRequest {
        if (repository.existsByUsername(username)) {
            user.setUsername(username);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }
}