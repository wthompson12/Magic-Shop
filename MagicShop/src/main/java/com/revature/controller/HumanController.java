package com.revature.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Human;
import com.revature.service.HumanService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/humans")
public class HumanController {

	@Autowired
	private HumanService hs;
	

	@GetMapping(value="{id}")
	public ResponseEntity<Human> getHuman(@PathVariable Integer id){
		return ResponseEntity.ok(hs.getByID(id));
	}

	@GetMapping
	public ResponseEntity<Set<Human>> getAccounts() {
		return ResponseEntity.ok(hs.returnAllAccounts());
	}

	@PostMapping
	public ResponseEntity<Human> createHuman(@RequestBody Human h){
		hs.createHuman(h);
		return ResponseEntity.ok(h);
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<Human> updateHuman(@PathVariable Integer id, @RequestBody Human h){
		
		if(hs.getByID(id) == null) {
			return ResponseEntity.status(405).body(null);
		}
		return ResponseEntity.ok(hs.updateHuman(h));
	}
	
	
}
