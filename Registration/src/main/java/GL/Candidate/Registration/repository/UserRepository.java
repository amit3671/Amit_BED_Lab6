package GL.Candidate.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GL.Candidate.Registration.dto.RegistrationDto;
import GL.Candidate.Registration.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User save(RegistrationDto user);

}
