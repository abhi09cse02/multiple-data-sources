package com.practise.multiple.datasource.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.practise.multiple.datasource.user.data.UserModel;
import com.practise.multiple.datasource.user.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesUserTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional("userTransactionManager")
	public void create_check_user() {

		UserModel user = new UserModel("admin", "abhi09cse02@gmail.com", "Robert", "Hickle","admin", LocalDateTime.now(), LocalDateTime.now());
		user = userRepository.save(user);

		assertNotNull(userRepository.findById(user.getId()));
		assertEquals(userRepository.findById(user.getId()).get().getEmail(), "abhi09cse02@gmail.com");
	}
}