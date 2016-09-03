package project.classes;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import project.exceptions.AccountInfoException;
import project.exceptions.CommentException;
import project.exceptions.UserException;
import project.interfaces.IUser;

public class User extends AccountInfo implements IUser {
	private static long NUMBER_OF_USERS = 0;
	private Set<Post> posts = new TreeSet<Post>();
	private Set<User> following = new HashSet<User>();
	private Set<User> followers = new HashSet<User>();

	public User(String name, String username, String email, String password, Gender gender, int age)
			throws AccountInfoException {
		super(name, username, email, password, gender, age);
		
		NUMBER_OF_USERS++;
	}

	@Override
	public void follow(User user) {
		if(user!=null && user!=this){
			this.following.add(user);
			user.followers.add(this);
		}

	}

	@Override
	public void unfollow(User user) throws UserException {
		if (user != this && user != null) {
			if (this.following.contains(user)) {
				this.following.remove(user);
				user.followers.remove(this);
			} else {
				throw new UserException("Cannot unfolow a user that you dont follow!");
			}
		}

	}

	@Override
	public void likePost(Post post) {
		if (post != null) {
			post.increaseLikes(this);
		}

	}

	@Override
	public void dislikePost(Post post) {
		if (post != null) {
			post.increaseDislikes(this);
		}
	}

	@Override
	public Comment addComment(String text, Post post) throws CommentException {
		if (post != null) {
			
			Comment comment = new Comment(text, this, post);
			post.addComment(comment);

			return comment;
		} else {
			throw new CommentException("Invalid comment");
		}

	}

	@Override
	public void deleteComment(Comment comment, Post post) {
		if (comment != null && post != null) {
			post.deleteComment(comment);
		}
	}
	
	
	public void printFollowers(){
		System.out.println(this.getUsername() + " FOLLOWERS: "); 
		for(User user : followers){
			System.out.println(user.getUsername());
		}
		
		System.out.println();
	}
	
	public void printFollowing(){
		System.out.println(this.getEmail() + " IS FOLLOWING: ");
		for(User user : following){
			System.out.println(user.getUsername());
		}
		
		System.out.println();
	}
}
