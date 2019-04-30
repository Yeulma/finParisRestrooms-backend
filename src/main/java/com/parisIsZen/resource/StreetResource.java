package com.parisIsZen.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parisIsZen.model.Street;
import com.parisIsZen.service.StreetService;

@RestController
public class StreetResource {

	private StreetService streetService;
	
	@Autowired
	public StreetResource(StreetService streetService) {
		this.streetService = streetService;
	}
	
	@GetMapping("/streets/{namePart}")
	public ResponseEntity<List<Street>> getOpenToilets(@PathVariable String namePart) {
		List<Street> streets = streetService.findMatchingStreets(namePart);
    	if (streets == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else if (streets.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
    		return new ResponseEntity<>(streets, HttpStatus.OK);
    	}	
	}
	
	@PostMapping("/streets")
    public ResponseEntity<Street> createStreets(@RequestBody Street street) {
        Street createdStreet = streetService.create(street);
        return new ResponseEntity<>(createdStreet, HttpStatus.CREATED);
    }
}
