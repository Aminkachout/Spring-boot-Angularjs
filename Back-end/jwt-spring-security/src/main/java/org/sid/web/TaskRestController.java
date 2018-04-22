package org.sid.web;

import java.util.List;
import java.util.stream.Stream;

import org.sid.dao.RoleRepository;
import org.sid.dao.TaskRepository;
import org.sid.entities.AppRole;
import org.sid.entities.Task;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {
	@Autowired 
	private TaskRepository taskRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	 private AccountService accountService;
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
		}
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t)
	{	 
		return taskRepository.save(t);
	}
	@PostMapping("/roles")
	public void save(@RequestParam String username, @RequestParam String roleName )
	{  
		 accountService.addRoleToUser(username, roleName);
		
	}
}
