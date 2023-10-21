package GL.Candidate.Registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import GL.Candidate.Registration.entity.User;
import GL.Candidate.Registration.service.UserService;

@Controller
public class CandidateController {

	@GetMapping("/users")
	public String viewUsers(Model model) {
		List<User> user = userService.allUsers();
		model.addAttribute("user", user);
		return "users";
	}

	@Autowired
	private UserService userService;

	@PostMapping("/admin/saveuser")
	public String saveEmployee(@ModelAttribute("user") User user) {

		userService.save(user);
		return "redirect:/users";
	}

	/*
	 * @GetMapping("/admin/users") public String viewUsers(Model model) { List<User>
	 * user = userService.allUsers(); model.addAttribute("user", user); return
	 * "admin/users"; }
	 */
	@GetMapping("/admin/users/{userId}/delete")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUserById(userId);
		return "redirect:/users";
	}

	@GetMapping("admin/users/{id}/edit")
	public String employeesedit(@PathVariable(value = "id") long id, Model model) {

		User user = userService.getUserById(id);

		model.addAttribute("user", user);
		return "/admin/update_user";
	}

	@GetMapping("/admin/users/viewUser/{id}")
	public String viewTicket(@PathVariable(value = "id") long id, Model model) {

		User user = userService.getUserById(id);

		model.addAttribute("user", user);
		return "admin/view_user";
	}

}