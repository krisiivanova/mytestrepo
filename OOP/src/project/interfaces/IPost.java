package project.interfaces;

import project.classes.Comment;
import project.classes.User;

public interface IPost {
	void increaseLikes(User user);
	
	void increaseDislikes(User user);
	
	void addComment(Comment comment);
	
	void deleteComment(Comment comment);

}
