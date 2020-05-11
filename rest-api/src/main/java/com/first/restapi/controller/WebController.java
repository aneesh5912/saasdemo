package com.first.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.restapi.models.Response;

@RestController
public class WebController {
	@RequestMapping("/sample")
	public Response Sample(@RequestParam(value = "name",
	defaultValue = "Aneesh") String name) {
		Response response = new Response();
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}

}
