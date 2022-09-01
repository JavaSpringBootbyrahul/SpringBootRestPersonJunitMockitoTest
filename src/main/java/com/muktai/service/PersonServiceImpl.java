package com.muktai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muktai.exhandler.PersonNotFoundException;
import com.muktai.model.Person;
import com.muktai.repo.PersonRepository;

@Service
public class PersonServiceImpl implements IPersonService
{
	@Autowired
	private PersonRepository repo;
	
	@Override
	public int savePerson(Person p) 
	{
		// TODO Auto-generated method stub
		Person p1=repo.save(p);
		return p1.getId();
	}

	@Override
	public List<Person> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Person getOnePerson(int id) 
	{
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(
				()->{
					throw new PersonNotFoundException("Person not found");
					}
				);
//		Optional<Person>op=repo.findById(id);
//		if(op.isEmpty())
//			throw new PersonNotFoundException("Person not found");
//		else
//			return op.get();
		
	}

}
