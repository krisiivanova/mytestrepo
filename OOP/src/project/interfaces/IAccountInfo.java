package project.interfaces;

import project.exceptions.AccountInfoException;

public interface IAccountInfo {
	
	void changePassword(String newPassword) throws AccountInfoException;
	
	void changeEmail(String newEmail) throws AccountInfoException;
	
	String getUsername();
	
	String getEmail();
	
	
}
