package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


@RestController
public class MyController {
	
	@GetMapping("mypost/{id}")
	public Post getResponse(@PathVariable("id") String id) {
		
		String url = "https://jsonplaceholder.typicode.com/posts/"+id;
		RestClient rc = RestClient.create();
		
		Post response = rc.get().uri(url).retrieve().body(Post.class);
		System.out.println("Response from client: \n" +response.getBody());
		return response;
		
	}

}
