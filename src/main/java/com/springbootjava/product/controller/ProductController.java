package com.springbootjava.product.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@GetMapping(value = "/get" ,produces = APPLICATION_JSON_VALUE)
	 public String sayJsonHello() {
		    return "{\"id\":1,\"content\":\"Hello, Sayan!\"} ";
		  }

}
