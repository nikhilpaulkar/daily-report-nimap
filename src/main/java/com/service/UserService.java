package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private PasswordEncoder passwordencoder;
	//get all data
	public List<User> getAllUsers(){

		List<User>list= userrepository.findAll();
		return list;
	}

	//update data
	public void updateuser(User user,Integer id)
    {
	User user1=	this.userrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with id"+id));
	user1.setEmail(user.getEmail());
	user1.setName(user.getName());
	user1.setPassword(passwordencoder.encode(user.getPassword()));
	userrepository.save(user1);
	}

	//add data
	public void adduser(User user)
	{
		userrepository.save(user);
	}


	//delete by id
	public void deletebyid( Integer id)
	{

		this.userrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with id"+id));
	    this.userrepository.deleteById(id);
	}





//	public static void logoutUser(String token, int id, String email)
//	{
//
//	}



    //login method find by email
   public    User findByEmail(String email)
    {
	   User user=this.userrepository.findByEmail(email);
	  return user;
   }
  //login method compare password



	//password encoder
	public User createUser(User userdto)
	{
		User user1= new User();
		user1.setEmail(userdto.getEmail());
		user1.setName(userdto.getName());
		user1.setPassword(passwordencoder.encode(userdto.getPassword()));
        return this.userrepository.save(user1);

	}






	public UserDetails loadUserByUsername(String email) {
		return null;


	}




}