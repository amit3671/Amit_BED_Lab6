package GL.Candidate.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GL.Candidate.Registration.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
