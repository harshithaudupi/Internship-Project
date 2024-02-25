package com.example.pgr.exception;


@SuppressWarnings("serial")
public class RoleNotFoundException extends RuntimeException{

	public RoleNotFoundException(Long u_id) {
		 super("No such Role ! "+u_id);
	}
}
