package com.muktai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muktai.model.Person;
import com.muktai.service.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonRestController 
{
	@Autowired
	private IPersonService service;
	@PostMapping("/save")
	public ResponseEntity<String> saveEmp(@RequestBody Person p)
	{
		int id=service.savePerson(p);
		return ResponseEntity.ok("Person created "+id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Person>>getAllPersons()
	{
		return ResponseEntity.ok(service.getAllProducts());
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Person> getOnePerson(@PathVariable int id)
	{
		Person p=service.getOnePerson(id);
		return ResponseEntity.ok().body(p);
	}
}
