package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.BackpackItemService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/backpack")
public class BackpackItemController {
	@Autowired
	private BackpackItemService bs;
	
	
}
