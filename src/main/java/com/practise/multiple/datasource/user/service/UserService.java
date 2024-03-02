package com.practise.multiple.datasource.user.service;

import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.practise.multiple.datasource.user.data.UserModel;

public interface UserService {
	Iterable<UserModel> findAllUsers();

	UserModel addUser(UserModel product);

	Optional<UserModel> findUserById(int userId) throws NotFoundException;
}