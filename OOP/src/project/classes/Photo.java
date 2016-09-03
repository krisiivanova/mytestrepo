package project.classes;

import project.exceptions.PostException;
import project.interfaces.IUser;

public class Photo extends Post{

	public Photo(String path, User owner) throws PostException {
		super(path, owner);
	}

}
