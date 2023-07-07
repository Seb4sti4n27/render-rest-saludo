package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Sebastian  %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/saludo")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/codigo")
	public Greeting greeting(@RequestParam(value = "codigo", defaultValue = "") long id) {
		return new Greeting(counter.incrementAndGet(), String.format(template, id));
	}
}