package com.parisIsZen.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parisIsZen.model.Toilet;
import com.parisIsZen.service.ToiletService;


@RestController
public class ToiletResource {
	
	private ToiletService toiletService;
	
	@Autowired
	public ToiletResource(ToiletService toiletService) {
		this.toiletService = toiletService;
	}
	
	@GetMapping("/toilets")
    public ResponseEntity<List<Toilet>> getToilets() {
    	List<Toilet> toilets = null;
    	toilets = toiletService.findAll();
    	if (toilets == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else if (toilets.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
    		return new ResponseEntity<>(toilets, HttpStatus.OK);
    	}		
    }
	
	@GetMapping("/toilets/{time}")
	public ResponseEntity<List<Toilet>> getOpenToilets(@PathVariable Integer time) {
		List<Toilet> toilets = null;
    	toilets = toiletService.findAll();
    	if (toilets == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	} else if (toilets.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
    		List<Toilet> openToilets = new ArrayList<Toilet>();
    		for (Toilet toilet : toilets) {
        		if (toilet.getTimetable() == "24/24") {
        			openToilets.add(toilet);
        		} else if (toilet.getTimetable() == "6/22") {
        			if (time >= 6 && time <= 22) {
        				openToilets.add(toilet);
        			}
        		} else {
        			if (time > 1 || time < 6) {
        				openToilets.add(toilet);
        			}
        		}
        	}
    		return new ResponseEntity<>(openToilets, HttpStatus.OK);
    	}	
	}

}
