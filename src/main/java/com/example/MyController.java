package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/greeting")
    public String greeting() {
     System.out.println("My Rest");
	 Iterable<Person> p =  personRepository.findAll();
	 for(Person w:p){
		 System.out.println(w.getFirstName());
	 }
	 return "aa";
    }
}
