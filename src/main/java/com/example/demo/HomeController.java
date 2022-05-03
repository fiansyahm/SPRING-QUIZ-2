package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class HomeController implements CommandLineRunner {

	private String nameUser=null;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String greeting(Model model) {
		model.addAttribute("name", nameUser);
		return "user/index";
	}

	@GetMapping("/categories")
	public String categories(User user,Model model) {
		model.addAttribute("user", user);
		return "user/categories";
	}

	@GetMapping("/food")
	public String food(Model model) {
		model.addAttribute("name", nameUser);
		return "user/food";
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@GetMapping("/loginuser")
	public String loginuser(Model model) {
		model.addAttribute("user", new User());

		return "login";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		String sql = "INSERT INTO users (name,email, password,isAdmin) VALUES (?,?,?,?)";

		int result = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), 0);

		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}

		return "register_success";
	}

	@PostMapping("/process_login")
	public String processLogin(User user,Model model) {
		String sql = "SELECT count(*) FROM USERS WHERE email = ? AND password=?";
		boolean result = false;

		int count = jdbcTemplate.queryForObject(
				sql, new Object[] { user.getEmail(), user.getPassword() }, Integer.class);

		if (count > 0) {
			result = true;
			nameUser=user.getName();
			model.addAttribute("user", user);
			return "user/index";
		}
		return "login";
	}

}
