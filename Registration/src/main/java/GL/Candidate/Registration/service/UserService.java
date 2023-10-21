package GL.Candidate.Registration.service;

import java.util.List;

import GL.Candidate.Registration.dto.RegistrationDto;
import GL.Candidate.Registration.entity.User;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);

	User findByEmail(String email);

	List<User> allUsers();

	void deleteUserById(long id);

	public User getUserById(long id);

	void viewUserById(long id);

	void save(User user);
}
