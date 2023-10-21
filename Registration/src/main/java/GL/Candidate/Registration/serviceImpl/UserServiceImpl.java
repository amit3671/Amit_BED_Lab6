package GL.Candidate.Registration.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import GL.Candidate.Registration.dto.RegistrationDto;
import GL.Candidate.Registration.entity.Role;
import GL.Candidate.Registration.entity.User;
import GL.Candidate.Registration.repository.RoleRepository;
import GL.Candidate.Registration.repository.UserRepository;
import GL.Candidate.Registration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(RegistrationDto registrationDto) {

		User user = new User();
		user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setCountry(registrationDto.getCountry());
		user.setCourse(registrationDto.getCourse());
		// use spring security to encrypt the password
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_GUEST");
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	public void save(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		return user;
	}

	@Override
	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public void viewUserById(long id) {
		this.userRepository.findById(id);
	}

}
