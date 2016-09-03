package project.classes;


import java.util.HashMap;
import java.util.Map;

import project.exceptions.AccountInfoException;
import project.exceptions.CommentException;
import project.exceptions.PostException;
import project.exceptions.UserException;

public class Demo {

	private static final int NUMBER_OF_USERS = 10;

	public static void main(String[] args) {
		
		try {
			
			User marina = new User("Marina", "Marina19", "marina@abv.bg", "1234567", Gender.FEMALE, 20);
			User gergana = new User("Gergana", "Gernaga23", "gergana@abv.bg", "1210292md", Gender.FEMALE, 23);
			User petranka = new User("Petranka", "Petranka12012", "petrancheto@abv.bg", "1212090", Gender.FEMALE, 29);
			User ivan = new User("Ivan", "Ivancho1290", "ivanpetrov@abv.bg", "1290129012", Gender.MALE, 29);
			User pesho =new User("Pesho", "Pesho Hakera", "pesho@abv.bg", "mskd8210", Gender.MALE, 20);
			
			Map<String, User> users = new HashMap<String, User>();
			users.put("marina@abv.bg", marina);
			users.put("gergana@abv.bg", gergana);
			users.put("petrancheto@abv.bg", petranka );
			users.put("ivanpetrov@abv.bg",ivan);
			users.put("pesho@abv.bg", pesho);
			
			
			User user = users.get("marina@abv.bg");
			//testing follow method
			user.follow(gergana);
			user.follow(user);
			petranka.follow(gergana);
			petranka.follow(ivan);
			ivan.follow(user);
			ivan.follow(marina);
			ivan.follow(pesho);
			ivan.follow(petranka);
			pesho.follow(marina);
			pesho.follow(ivan);
			
		
			for (java.util.Map.Entry<String, User> entry : users.entrySet()) {
				entry.getValue().printFollowers();
			}
			
			System.out.println();
			
			//testing unfollow method
			//pesho.unfollow(petranka); // exception
			pesho.unfollow(marina);
			marina.printFollowers();
			
			Post photo = new Photo("path...", pesho);
			marina.addComment("Mnogo hubava snimka.", photo);
			marina.likePost(photo);
			marina.addComment("Qka e!", photo);
			marina.likePost(photo); //samo po vednaj
			
			
//			marina.addComment("Mnogo hubava snimka.", photo);
//			petranka.addComment("Pesho, mnogo ti e gotina snimkata!", photo);
//			petranka.addComment("Mnogo hubava snimka.", photo);
//			
//			gergana.likePost(photo);
//			
//			System.out.println(photo.getLikesOfPost());
//			
//			photo.showComments();

			
		} catch (AccountInfoException | UserException | PostException | CommentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
