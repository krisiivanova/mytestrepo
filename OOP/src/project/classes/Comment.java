package project.classes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import project.exceptions.CommentException;

public class Comment implements Comparable<Comment> {
	private String text;
	private User commentator;
	private Post post;
	private final LocalDateTime dateAdded;
	private static long counterOfComments = 0;

	public Comment(String text, User commentator, Post post) throws CommentException {
		if (text != null && !text.trim().isEmpty()) {
			this.text = text;
		} else {
			throw new CommentException("Cannot add an empty comment!");
		}

		if (commentator != null) {
			this.commentator = commentator;
		}

		this.dateAdded = LocalDateTime.now();
		

		if (post != null) {
			this.post = post;
		} else {
			throw new CommentException("Ivalid post");
		}
		
		counterOfComments++;
	}

	

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	
	@Override
	public String toString() {
		return "Comment: " + this.text + " from: " + this.commentator.getUsername() + " left on: " + this.dateAdded;
	}

	
	@Override
	public int compareTo(Comment otherComment) {
		if(this.commentator == otherComment.commentator && this.text.equals(otherComment.text)){
			return 0;
		}else{
			return this.dateAdded.compareTo(otherComment.dateAdded);
		}
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentator == null) ? 0 : commentator.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentator == null) {
			if (other.commentator != null)
				return false;
		} else if (!commentator.equals(other.commentator))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}
