package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
public class DemoApplication {

	// @Autowired
    // private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
		public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	String sql = "INSERT INTO users (name,email, password,isAdmin) VALUES (?, ?,?,?)";
         
    //     int result = jdbcTemplate.update(sql, "Ravi Kumar","admin@gmail.com", "ravi2021",1);
         
    //     if (result > 0) {
    //         System.out.println("A new row has been inserted.");
    //     }
		
	// }

}
