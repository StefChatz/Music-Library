package musiclibrary;

import java.util.Scanner;

import musiclibraryDAO.SongDAO;
import musiclibraryDAO.SongDAOImpl;

/*
 * 
 * @author Stefanos Chatzakis
 */
public class DatabaseSearch {
	 /*
     * This is the main method of the class where the user is able to select
     * an operation to make to the music list.
     * @param String[] args
     */
	public static void main(String[] args) {
		
		SongDAO songDAO;
		System.out.println("_______Choose the next operation_______");
		System.out.println("Type '1' to add a song.");
		System.out.println("Type '2' to display the list at it's current state.");
		System.out.println("Type '3' to sort and display the songs by song name.");
		System.out.println("Type '4' to sort and display the songs by artist name.");
		System.out.println("Type '5' to sort and display the songs by album name.");
		System.out.println("Type '6' to sort and display the songs by year.");
		System.out.println("Type '7' to delete a song.");
		
	Scanner useranswer = new Scanner(System.in);
	int answer = useranswer.nextInt();
	try {
	switch (answer) {
	case 1:
		UserInput inputcreate = new UserInput();
		inputcreate.addsong();
		break;
		
	case 2:
		SongDAOImpl song = new SongDAOImpl();
		song.showAllSongs();
		break;
		
	case 3:
		SongDAOImpl song1 = new SongDAOImpl();
		song1.sortAllSongsBySongName();
		break;
	case 4:
		SongDAOImpl song2 = new SongDAOImpl();
		song2.sortAllSongsByArtistName();
		break;
	case 5:
		SongDAOImpl song3 = new SongDAOImpl();
		song3.sortAllSongsByAlbumName();
		break;
	case 6:
		SongDAOImpl song4 = new SongDAOImpl();
		song4.sortAllSongsByYear();
		break;
	case 7: 
		UserInput inputdelete = new UserInput();
		inputdelete.deleteSong();
		break;
	default:
		System.out.println("Invalid input");
		break;
	}
	}catch(Exception e) {
		System.out.println("One of the cases, caused an exception");
		e.printStackTrace();
	}
	}
	}

