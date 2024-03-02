package com.practise.multiple.datasource.user.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.practise.multiple.datasource.user.data.UserModel;
import com.practise.multiple.datasource.user.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<UserModel> findAllUsers() {
		Iterable<UserModel> userList = this.userRepository.findAll();
		return userList;
	}

	@Override
	public UserModel addUser(UserModel user) {
		UserModel addUser = this.userRepository.save(user);
		return addUser;
	}

	@Override
	public Optional<UserModel> findUserById(int userId) throws NotFoundException {
		Optional<UserModel> userList = this.userRepository.findById(userId);
		return userList;
	}
}