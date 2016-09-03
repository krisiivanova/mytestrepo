package project.classes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import project.exceptions.PostException;
import project.interfaces.IPost;
import project.interfaces.IUser;

public abstract class Post implements IPost {
	private String path;
	private IUser owner;
	private Set<User> likes = new HashSet<User>();
	private Set<User> dislikes = new HashSet<User>();
	private Set<Comment> comments = new TreeSet<Comment>();
	private final LocalDateTime dateAdded;

	public Post(String path, User owner) throws PostException {
		this.path = path;

		if (owner != null) {
			this.owner = owner;
		} else {
			throw new PostException("Invalid user for posting!");
		}
		
		this.dateAdded = LocalDateTime.now();
	}

	@Override
	public void increaseLikes(User user) {
		if (user != null) {
			this.likes.add(user);
		}
	}

	@Override
	public void increaseDislikes(User user) {
		if (user != null) {
			this.dislikes.add(user);
		}

	}

	@Override
	public void addComment(Comment comment) {
		if(comment!=null){
			this.comments.add(comment);
		}
	}

	@Override
	public void deleteComment(Comment comment) {
		if(comment!=null){
			this.comments.remove(comment);
		}
	}
	
	public int getLikesOfPost(){
		return this.likes.size();
	}
	
	public int getDisLikesOfPost(){
		return this.dislikes.size();
	}
	
	public void showComments(){
		for (Comment comment : comments) {
			System.out.println(comment);
		}
	}

	@Override
	public String toString() {
		return "Post [owner=" + owner + ", dateAdded=" + dateAdded + "]";
	}
}
