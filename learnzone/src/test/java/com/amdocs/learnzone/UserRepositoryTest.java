package com.amdocs.learnzone;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.amdocs.learnzone.models.User;
import com.amdocs.learnzone.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() throws Exception {
		User user = new User();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dtf.format(now));  
		
		user.setPassword("ravi2020");
		user.setName("Ravi Kumar");
		user.setPhoneNo(1234567890);
		user.setEmail("ravikumar@gmail.com");
		user.setAddress("hno. 12, abc, def");
		user.setRegDate(date);

		User savedUser = repo.save(user);

		User existUser = entityManager.find(User.class, savedUser.getUserId());

		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	}  
}
