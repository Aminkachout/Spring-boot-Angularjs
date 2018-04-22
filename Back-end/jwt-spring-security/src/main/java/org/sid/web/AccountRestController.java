package org.sid.web;

import java.util.stream.Stream;

import org.sid.dao.TaskRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired 
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/listUsers")
	public Page<AppUser> getlist(@RequestParam(defaultValue= "0") int page)
	{
		return accountService.getUsers(page);
	}
	
	
	@PostMapping("/addroletouser")
	
		public void addrole(@RequestBody Role roleuser )
		{
			accountService.addRoleToUser(roleuser.getUsername(), roleuser.getRoleName());
		}

	@PostMapping("/register")
	public AppUser register( @RequestBody ResgisetrForm user )

	{
		
		if(!user.getPassword().equals(user.getRepassword())) throw new RuntimeException("You must confirm your password"); 
	AppUser user1=accountService.findUserByUsername(user.getUsername());
	if(user1!=null)throw new RuntimeException("This user already exists");
		AppUser appuser= new AppUser();
	appuser.setUsername(user.getUsername());
	appuser.setPassword(user.getPassword());
		return accountService.saveUser(appuser);
		
	}
	@PostMapping("/removeuser")
	public void  removeUser(@RequestBody Long id)
	{
		accountService.deleteUser(id);
	}
}
