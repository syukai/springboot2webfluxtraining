package com.example.sb2train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("train")
public class TrainRestController {

	@GetMapping
	public String index() {
		return "sb2!";
	}
}
