package com.ServiceImpl;

import org.springframework.stereotype.Service;

import com.dto.LoggerDto;
import com.entity.User;
@Service
public interface LoggerServiceInterface {


	public void createLogger(LoggerDto loggerdto , User user);

 void logout(String token) ;
}