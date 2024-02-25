package com.example.pgr.exception;



@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(Long user_id) {
	 super("No such user with userid : "+user_id);
}
}
