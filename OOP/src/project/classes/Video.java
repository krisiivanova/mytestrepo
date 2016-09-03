package project.classes;

import project.exceptions.PostException;
import project.interfaces.IUser;

public class Video extends Post{

	public Video(String path, User owner) throws PostException {
		super(path, owner);
	}
}
