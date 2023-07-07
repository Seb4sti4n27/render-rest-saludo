package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Sebastian  %s!";
	private static final String templates = "Sebastian Sanchez %s!";
	private static final String templat = "A19200436 %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/idynom")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/codigo")
	public Greeting2 greeting2(@RequestParam(value = "codigo", defaultValue = "") String codigo) {
		return new Greeting2(String.format(templat, codigo));
	}

	@GetMapping("/nomcompl")
	public Greeting3 greeting3(@RequestParam(value = "namecomp", defaultValue = "") String namecomp) {
		return new Greeting3(String.format(templates, namecomp));
	}
}