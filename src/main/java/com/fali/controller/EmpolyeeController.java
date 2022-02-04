package com.fali.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fali.exception.ResourceNotFoundException;
import com.fali.model.Empolyee;
import com.fali.repository.EmpolyeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class EmpolyeeController {
	
	@Autowired
	private EmpolyeeRepository empolyeeRepository;
	
	//get all Employees
	@GetMapping("/employees")
	public List<Empolyee> getAllEmployyes(){
		return empolyeeRepository.findAll();
	}
	
	// create employee rest api
	@PostMapping("/employees")
	public Empolyee CreateEmployee(@RequestBody Empolyee empolyee) {
		return empolyeeRepository.save(empolyee);
	}


    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

    	Empolyee employee = empolyeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

    	empolyeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    // get employee by id 
    
    @GetMapping("{id}")
    public  Optional<Empolyee> getEmpolyee(@PathVariable long id){
		return empolyeeRepository.findById(id);
    	
      }
}