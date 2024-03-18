package tn.enicarthage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import tn.enicarthage.model.User;
import tn.enicarthage.service.UserService;

@CrossOrigin(value = "http://localhost:3000") ///allowing this particular api to call the service
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController (UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
	    try {
	        User savedUser = userService.saveUser(user);
	        return ResponseEntity.ok(savedUser);
	    } catch (Exception e) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "Unable to save user: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	
	 @GetMapping("/users")
	   public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	 @GetMapping("/users/{id}")
	 public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
	 	User user= null;
	 	user= userService.getUserById(id);
	 	return ResponseEntity.ok(user);
	 }
	 @DeleteMapping("/users/{id}")
	 public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable("id") Long id){
		 boolean deleted = false;
		 deleted =userService.deleteUser(id);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("deleted",deleted);
		 return ResponseEntity.ok(response);
	 }
	 @PutMapping("/users/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable("id") Long id , @RequestBody User user){
		user = userService.updateUser(id,user);
		return ResponseEntity.ok(user);
		 
	
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
