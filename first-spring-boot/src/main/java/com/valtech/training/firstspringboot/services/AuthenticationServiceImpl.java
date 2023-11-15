package com.valtech.training.firstspringboot.services;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	public void populateUsers() {
		RegisterUserModel userModel = new RegisterUserModel();
		userModel.setUsername("murali");
		userModel.setPassword("Rajkumar@820");
		createUser(userModel);
		userModel.setUsername("admin");
		userModel.setPassword("Rajkumar@820");
		User user = createUser(userModel);
//		upgradeUserToAdmin(user.getId());

	}

	@Override
	public User createUser(RegisterUserModel userModel) {

		User user = new User(userModel.getUsername(), passwordEncoder.encode(userModel.getPassword()),
				Arrays.asList("ROLE_USER"));
		user.setEnabled(true);
		return userRepo.save(user);
	}

	@Override
	public boolean changePassword(ChangePasswordModel passwordModel) {
		User user = userRepo.findByUsername(passwordModel.getUsername());
		if (passwordEncoder.matches(passwordModel.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public void upgradeUserToAdmin(long id) {
		User user = userRepo.getReferenceById(id);
		user.addRole("ROLE_ADMIN");
		userRepo.save(user);
	}

	@Override
	public void enableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(true);
	}

	@Override
	public void disableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}

}
