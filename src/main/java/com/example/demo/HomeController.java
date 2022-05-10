package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.sampled.Line;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class HomeController implements CommandLineRunner {

	private String nameUser = null;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @GetMapping("/users")
	// public List<User> findAll() {
	// String sql = "SELECT count(*) FROM users";
	// return jdbcTemplate.query(sql,new UserRowMapper());
	// }

	@GetMapping("/")
	public String greeting(Model model) {
		String sql = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql, new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1, new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);
		return "beforelogin/index";
	}

	@GetMapping("/categories")
	public String categories(User user, Model model) {
		model.addAttribute("user", user);
		return "user/categories";
	}

	@GetMapping("/add-category")
	public String addcategory(Category category, Model model) {
		model.addAttribute("category", category);
		return "admin/add-category";
	}

	@GetMapping("/add-food")
	public String addfood(Food food, Model model) {
		String sql = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql, new CategoryMapper());
		model.addAttribute("categories", categories);

		model.addAttribute("food", food);
		return "admin/add-food";
	}

	@GetMapping("/food")
	public String food(User user, Model model) {
		model.addAttribute("user", user);
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

	@GetMapping("/login")
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
	public String processLogin(User user, Model model) {

		String sql2 = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql2, new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1, new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);
		model.addAttribute("category", new Category());
		model.addAttribute("food", new Food());

		String sql = "SELECT count(*) FROM users WHERE email = ? AND password=? AND isAdmin=? ";

		int count = jdbcTemplate.queryForObject(
				sql, new Object[] { user.getEmail(), user.getPassword(), 1 }, Integer.class);

		if (count > 0) {
			model.addAttribute("user", user);
			return "admin/index";
		}
		sql = "SELECT count(*) FROM users WHERE email = ? AND password=? AND isAdmin=? ";

		count = jdbcTemplate.queryForObject(
				sql, new Object[] { user.getEmail(), user.getPassword(), 0 }, Integer.class);

		if (count > 0) {
			model.addAttribute("user", user);
			return "user/index";
		}

		return "login";
	}

	@PostMapping("/create-category")
	public String processCreateCategory(Category category, Model model) {

		String counter = "SELECT count(*) FROM categories";

		List<Integer> count = jdbcTemplate.queryForList(counter, new Object[] {},Integer.class);

		String sql = "INSERT INTO categories (id,name,image) VALUES (?,?,?)";

		int result = jdbcTemplate.update(sql,count.size()+1, category.getName(), category.getImage());

		String sql2 = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql2,new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1,new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);

		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}
		
		return "beforelogin/index";

		
	}

	@PostMapping("/create-food")
	public String processCreateFood(Food category, Model model) {

		String counter = "SELECT count(*) FROM food";

		List<Integer> count = jdbcTemplate.queryForList(counter, new Object[] {},Integer.class);

		String sql = "INSERT INTO food (id,name,image,description,price,categoryId) VALUES (?,?,?,?,?,?)";

		int result = jdbcTemplate.update(sql,count.size()+1, category.getName(), category.getImage(), category.getDescription(), category.getPrice(),category.getCategoryId());

		String sql2 = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql2,new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1,new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);

		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}
		
		return "beforelogin/index";

		
	}
	
	@PostMapping("/delete-category")
	public String processDeleteCategory(Category category, Model model) {

		String sql = "DELETE FROM categories WHERE name=?";

		int result = jdbcTemplate.update(sql,category.getName());

		String sql2 = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql2,new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1,new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);

		

		if (result > 0) {
			System.out.println("A new row has been deleted.");
		}
		
		return "beforelogin/index";

		
	}

	@PostMapping("/delete-food")
	public String processDeleteFood(Food food, Model model) {

		String sql = "DELETE FROM food WHERE name=?";

		int result = jdbcTemplate.update(sql,food.getName());

		String sql2 = "SELECT * FROM categories";
		List<Category> categories = jdbcTemplate.query(sql2,new CategoryMapper());
		String sql1 = "SELECT * FROM food";
		List<Food> foods = jdbcTemplate.query(sql1,new FoodMapper());
		model.addAttribute("categories", categories);
		model.addAttribute("foods", foods);

		

		if (result > 0) {
			System.out.println("A new row has been deleted.");
		}
		
		return "beforelogin/index";

		
	}

	

}
