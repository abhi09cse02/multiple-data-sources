package com.practise.multiple.datasource.user.controller;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.practise.multiple.datasource.product.controller.ProductController;
import com.practise.multiple.datasource.user.data.UserModel;
import com.practise.multiple.datasource.user.service.UserService;
import com.practise.multiple.datasource.util.Mapper;

@RestController
public class UserController {

	Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/multidatasource/addUser")
	public UserModel addUser(@RequestBody UserModel user) {
		logger.info("UserController:addUser persist add user request {}", Mapper.mapToJsonString(user));
		UserModel addUser = this.userService.addUser(user);
		logger.info("UserController:addUser response from service {}", Mapper.mapToJsonString(addUser));
		return addUser;
	}

	@GetMapping("/multidatasource/getAllUsers")
	public Iterable<UserModel> getAllUsers() {
		Iterable<UserModel> userList = this.userService.findAllUsers();
		logger.info("UserController:getAllUsers response from service {}", Mapper.mapToJsonString(userList));
		return userList;
	}

	@GetMapping("/multidatasource/getUser/{userId}")
	public Optional<UserModel> getProduct(@PathVariable int userId) throws NotFoundException {
		logger.info("UserController:getProduct fetch user by id {}", userId);
		Optional<UserModel> userList = this.userService.findUserById(userId);
		logger.info("UserController:getProduct response from service {}", Mapper.mapToJsonString(userList));
		return userList;
	}
}