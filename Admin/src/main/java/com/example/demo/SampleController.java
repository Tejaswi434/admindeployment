package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

 

@RestController
public class SampleController {
 @Autowired
     SampleService sampleservice;
	@GetMapping("/abcd")
	public List<Map<String,Object>> display()
	{
		return sampleservice.productdetails();
	}  
	
	@PostMapping("/posting") 
	public HashMap<String, Integer> injectingdata(@RequestBody Products product) {
		HashMap<String, Integer> hm = new HashMap<String,Integer> ();
		int data = sampleservice.injectData(product);  
		if(data==0) {
			
			  hm.put("failed", 0);
		}
		else {
			  hm.put("success", 1);
		} 
		
		return hm ;
	}
	
	@PostMapping("/updating")
	public HashMap<String,Integer> updatingdata(@RequestBody Products product){
		HashMap<String, Integer> hm = new HashMap<String,Integer> (); 
		
		int data = sampleservice.updatingData(product);
		if(data==0) {
			
			  hm.put("failed", 0);
		}
		else {
			  hm.put("success", 1);
		} 
		
		return hm;
	}
	
	@GetMapping("/data/{name}")
	public List<Map<String,Object>> paramData(@PathVariable String name){
	
		return sampleservice.pathData( name);
	}
}  


