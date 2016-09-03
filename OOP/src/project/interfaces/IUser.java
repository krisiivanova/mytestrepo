package project.interfaces;

import project.classes.Comment;
import project.classes.Post;
import project.classes.User;
import project.exceptions.CommentException;
import project.exceptions.UserException;

public interface IUser {
	void follow(User user);

	void unfollow(User user) throws UserException;

	void likePost(Post post);

	void dislikePost(Post post);

	Comment addComment(String text, Post post) throws CommentException;

	void deleteComment(Comment comment , Post post);

}
