package com.parisIsZen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parisIsZen.model.Toilet;
import com.parisIsZen.repository.ToiletRepository;

@Service
public class ToiletService {
	
	private ToiletRepository toiletRepository;
	
	@Autowired
    public ToiletService(ToiletRepository toiletRepository) { 
        this.toiletRepository = toiletRepository;
    }
	
	public List<Toilet> findAll() {
		return toiletRepository.findAll();
	}
	
	public Toilet create(Toilet toilet) {
		return toiletRepository.save(toilet);
	}
	
	public Toilet findById(Long toiletId) {
    	Optional<Toilet> toilet = toiletRepository.findById(toiletId);
    	if (toilet.isPresent()) {
			return toilet.get();
		} else {
			return null;
		}
    }
	
	public Toilet update(Toilet toilet) {
		return toiletRepository.save(toilet);
	}

}
