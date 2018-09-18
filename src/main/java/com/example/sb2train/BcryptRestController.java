package com.example.sb2train;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bcrypt")
public class BcryptRestController {

	@GetMapping("{word}")
	public String get(@PathVariable("word") String word) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		return crypt.encode(word);
	}
}
