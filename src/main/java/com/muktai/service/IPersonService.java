package com.muktai.service;

import java.util.List;

import com.muktai.model.Person;

public interface IPersonService {
	public int savePerson(Person p);
	public List<Person> getAllProducts();
	public Person getOnePerson(int id);
}
