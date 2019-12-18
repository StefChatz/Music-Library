package musiclibrary;

import java.util.Scanner;


import musiclibraryDAO.DAOSongFactory;
import musiclibraryDAO.SongDAO;

/*
 * @author Stefanos Chatzakis
 */

public class UserInput {
	 /*
     * Initiating a scanner for the entry of a new song.
     */
	private Scanner scanner = new Scanner(System.in);
	private SongDAO b = null;
	private SongDAO a = null;
	
	 /*
     * Create method for the user to input all of the required information for
     * a new song.
     * 
     * @return song1
     */
	
	public Song userinputcreate() {
		
		System.out.println("Enter name:");
		String songName = scanner.nextLine();
		System.out.println("Enter artist:");
		String artistName = scanner.nextLine();
		System.out.println("Enter album:");
		String albumName = scanner.nextLine();
		System.out.println("Enter Year:");
		String year = scanner.nextLine();
		int year_final= Integer.parseInt(year);
		Song song1 = new Song (songName, artistName, albumName, year_final);
		return song1;
	}
	
	 /*
     * method for deleting a song from the music list.
     */
	
	public void deleteSong() {
		try {
		b = DAOSongFactory.getSongDAO();
		
		Song song = this.userinputcreate();
		b.deleteSong(song);
		System.out.println("The song was removed");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(b != null) {
		}
			 b.closeConnection();
		 }
	}
	 /*
     * method for adding a song to the music list.
     */
	public void addsong() {
		try {
		a = DAOSongFactory.getSongDAO();
		
		Song song = this.userinputcreate();
		a.createSong(song);
		System.out.println("The song was added");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		if(a != null) {
			a.closeConnection();
		}
		}
	}
}
