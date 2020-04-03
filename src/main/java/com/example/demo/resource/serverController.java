package com.example.demo.resource;


import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Servers;
import com.example.demo.repositories.serverRepositories;

@Controller
public class serverController {
	
	@Autowired
	private serverRepositories repo;
	
	@RequestMapping("/server")
	public String server(Model model)
	{
		model.addAttribute("servers",repo.findAll());
		return "server";
	}
	
	@RequestMapping("/create")
	public String create(Model model)
	{
		return "create";
	}
	 @RequestMapping("/save")
	 public String save(@RequestParam int id,@RequestParam String name,@RequestParam String language,@RequestParam String framework)
		 {
			 Servers server = new Servers();
			 
			 server.setId(id);
			 server.setName(name);
			 server.setLanguage(language);
			 server.setFramework(framework);
			 
			 repo.save(server);
			 return "redirect:/show/" + server.getId();
		 }
	 @RequestMapping("/show/{id}")
	 public String show(@PathVariable int id,Model model)
	 {
		 model.addAttribute("server",repo.findById(id).get());
		 return "show";
	 }
	 @RequestMapping("/delete")
	 public String delete(@RequestParam int id)
	 {
		 Optional<Servers> server = repo.findById(id);
		 repo.delete(server.get());
		 
		 return "redirect:/server";
	 }
		 
		 }
	
