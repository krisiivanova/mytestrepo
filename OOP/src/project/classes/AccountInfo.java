package project.classes;

import java.time.LocalDateTime;

import project.exceptions.AccountInfoException;
import project.interfaces.IAccountInfo;

public abstract class AccountInfo implements IAccountInfo {
	private static final int MIN_AGE = 5;
	private static final int MIN_LENGTH_FOR_PASSWORD = 6;
	private final LocalDateTime dateUserCreated;
	
	private String name;
	private final String username;
	private String email;
	private String password;
	private final Gender gender;
	private int age;
	
	public AccountInfo(String name, String username, String email, String password, Gender gender, int age)
			throws AccountInfoException {

		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		} else {
			throw new AccountInfoException("Invalid name!");
		}

		if (username != null && !username.trim().isEmpty()) {
			this.username = username;
		} else {
			throw new AccountInfoException("Invalid username!");
		}

		if (validateEmail(email)) {
			this.email = email;
		} else {
			throw new AccountInfoException("Invalid email address!");
		}

		if (validatePassword(password)) {
			this.password = password;
		} else {
			throw new AccountInfoException("Invalid password. You password must be at least 6 symbols.");
		}

		if (age > MIN_AGE) {
			this.age = age;
		} else {
			throw new AccountInfoException("Invalid age. Min age is 1.");
		}
		
		this.gender = gender;
		this.dateUserCreated = LocalDateTime.now();
		
	}

	private boolean validateEmail(String email) {
		boolean stricterFilter = true;
		String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		String emailRegex = stricterFilter ? stricterFilterString : laxString;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	private boolean validatePassword(String password) {
		if (password != null && !password.equals("") && password.length() >= MIN_LENGTH_FOR_PASSWORD) {
			return true;
		}

		return false;
	}
	

	@Override
	public void changePassword(String newPassword) throws AccountInfoException {
		if (validatePassword(newPassword)) {
			this.password = newPassword;
		} else {
			throw new AccountInfoException("Invalid password. You password must be at least 6 symbols.");
		}
	}

	@Override
	public void changeEmail(String newEmail) throws AccountInfoException {
		if (validateEmail(newEmail)) {
			this.email = newEmail;
		} else {
			throw new AccountInfoException("Invalid new email address.");
		}
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Username=" + username + ", email=" + email + ", password=" + password + ", gender=" + gender + ", age="
				+ age + "]";
	}
}

