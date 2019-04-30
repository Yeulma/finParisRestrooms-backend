package com.parisIsZen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parisIsZen.model.Street;
import com.parisIsZen.repository.StreetRepository;

@Service
public class StreetService {

	private StreetRepository streetRepository;
	
	@Autowired
	public StreetService(StreetRepository streetRepository) {
		this.streetRepository = streetRepository;
	}
	
	public Street create(Street street) {
		return streetRepository.save(street);
	}
	
	public List<Street> findMatchingStreets(String namePart) {
		List<Street> matchingStreets = new ArrayList<Street>();
		Integer index = 0;
		List<Street> streets = streetRepository.findAll();
		for (Street street : streets) {
			if (index == 5) {
				return matchingStreets;
			}
			String name = "\\b" + namePart;
			Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(street.getName());
			if (matcher.find()) {
				matchingStreets.add(street);
				index = index + 1;
			}
		}
		return matchingStreets;
	}
}
