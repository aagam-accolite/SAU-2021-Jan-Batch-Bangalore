package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {

	  @Autowired
	  CricketRepository cricketRepository;
	  
	  @PostMapping("/Cricket")
	    public Cricket addCricketPost(@RequestBody Cricket cricket) {
	        return cricketRepository.save(cricket);
	    }
	  @GetMapping("/Cricket/runs/{runs}")
	    public Cricket findByruns(@PathVariable int runs) {
		 
	        // List<Cricket> player_list = (List<Cricket>) cricketRepository.findById();
	        List<Cricket> player_list = (List<Cricket>) cricketRepository.findAll();
	        
	        // Cricket res = player_list.get(0);
	        List<Cricket> result = new ArrayList<Cricket>();
	        
	        int i;
	        for(i = 0;i<player_list.size();i++) 
	        {
	        	System.out.println("Runs Got are : "+ player_list.get(i).getRuns());
	            if(player_list.get(i).getRuns() > runs)
	            {
	            	//System.out.println("Runs Approved are " + player_list.get(i));
	            	result.add(player_list.get(i));
	            }
	        }
	        return result.get(0);
	    }
}
