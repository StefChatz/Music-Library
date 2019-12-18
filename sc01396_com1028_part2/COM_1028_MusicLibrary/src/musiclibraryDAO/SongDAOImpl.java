package musiclibraryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import musiclibrary.Song;

/*
 * @author Stefanos Chatzakis
 */
public class SongDAOImpl implements SongDAO {
	/*
	 * Fields for a connection and sql statement
	 */
        private Connection connect;
        private Statement statement;
        /*
         * Constructor for the class.
         */
        public SongDAOImpl() {
            super();
        
            this.connect = null;
            this.statement = null;
            this.openConnection();
        }
        
        /*
         * A method that starts the connection with the Database.
         */
        
    @Override
    public void openConnection() {
        try {
            if (this.connect == null || this.connect.isClosed()) {
                this.connect = DriverManager.getConnection("jdbc:hsqldb:file:db_data/myDBfilestore;ifexists=true;shutdown=true;", "SA","");
            }
            if (this.statement == null || this.statement.isClosed()) {
				this.statement = this.connect.createStatement();
			}
        }catch(SQLException e) {
            e.printStackTrace();
        System.out.println("ERROR_0 - Failed to create a connection to the database");
        }
    }

    /*
     * A method that ends the connection with the Database.
     */
    
    @Override
    public void closeConnection() {
    	try {

			if (this.statement != null) {
				this.statement.close();
			}
			if (this.connect != null) {
				this.connect.close();
			}
			System.out.println("Closed the connection to the database");
		} catch (Exception e) {
                    e.printStackTrace();
			System.out
					.print("ERROR_1 - Failed to close the connection to the database");
			throw new RuntimeException(e);
		}    
    }
    
    /*
     * A method for adding a song object to the database.
     * @return song
     */
    
    @Override
    public List<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();
		try {
			// This is our prepared query, that selects everything from songs
			// table
			String query = "SELECT * FROM SONG";

			// Executes the query and stores the results.
			ResultSet results = this.statement.executeQuery(query);
                            
                            
			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				String name = results.getString("name");
				String artist = results.getString("artist");
				int year = results.getInt("year");
				String album = results.getString("album");
				songs.add(new Song(name, artist, album, year));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return songs;
    }

    /*
     * 
     */
    
    @Override
    public void createSong(Song song) {
        try {

			// Prepared statements allow us to use variables in them more
			// efficiently
			PreparedStatement preparedStatement = this.connect
                                        .prepareStatement("INSERT INTO song (name, artist, year, album) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setString(1, song.getSongName());
				preparedStatement.setString(2, song.getArtistName());
				preparedStatement.setString(4, song.getAlbumName());
				preparedStatement.setInt(3, song.getReleaseYear());
			// This executes the query. Please note there are different execute
			// types.
			//int ai = 
                                preparedStatement.executeUpdate();
                        
                       /*if(ai == 1) {
                            ResultSet keys = preparedStatement.getGeneratedKeys();
                            song.setKey(keys.getInt(1));
                        }*/
		} catch (SQLException e) {
                    e.printStackTrace();
			System.out
					.println("SQLException happened while writing a book- abort programmme");
			throw new RuntimeException(e);
		}
    }
/*
 * A method that when called, displays all of the data.
 */
    @Override
    public void showAllSongs() {
    List<Song> songs = getSongs();
	Iterator<Song> iter = songs.iterator();
	
		// While there are still results...
		Song tmpSong;
		while (iter.hasNext()) {
			tmpSong = iter.next();
			// Prints results to console
			System.out.println("---------------------------------\n"+"Name: "+tmpSong.getSongName() + ".\n" + "Artist: " +
                                tmpSong.getArtistName() + ".\n" + "Album: " +
                                tmpSong.getAlbumName() + ".\n" + "Year: " + tmpSong.getReleaseYear()+ ".\n"+"---------------------------------\n"+"\n");
		}    }
    /*
     * A method that sorts all of the songs by the smallest value of the year.
     */
    @Override
    public void sortAllSongsByYear() {
    List<Song> songs = getSongs();
    Collections.sort(songs, Song.yearComparator);
	Iterator<Song> iter = songs.iterator();

		// While there are still results...
		Song tmpSong;
		while (iter.hasNext()) {
			tmpSong = iter.next();
			// Prints results to console
			System.out.println("---------------------------------\n"+"Name: "+tmpSong.getSongName() + ".\n" + "Artist: " +
                    tmpSong.getArtistName() + ".\n" + "Album: " +
                    tmpSong.getAlbumName() + ".\n" + "Year: " + tmpSong.getReleaseYear()+ ".\n"+"---------------------------------\n"+"\n");
		}    }
    
    /*
     * A method that sorts all of the songs alphabetically by Album Name.
     */
    
    @Override
    public void sortAllSongsByAlbumName() {
    List<Song> songs = getSongs();
    Collections.sort(songs, Song.albumNameComparator);
	Iterator<Song> iter = songs.iterator();

		// While there are still results...
		Song tmpSong;
		while (iter.hasNext()) {
			tmpSong = iter.next();
			// Prints results to console
			System.out.println("---------------------------------\n"+"Name: "+tmpSong.getSongName() + ".\n" + "Artist: " +
                    tmpSong.getArtistName() + ".\n" + "Album: " +
                    tmpSong.getAlbumName() + ".\n" + "Year: " + tmpSong.getReleaseYear()+ ".\n"+"---------------------------------\n"+"\n");
		}    }
    
    /*
     * A method that sorts all of the songs alphabetically by Artist Name.
     */
    
    @Override
    public void sortAllSongsByArtistName() {
    List<Song> songs = getSongs();
    Collections.sort(songs, Song.artistNameComparator);
	Iterator<Song> iter = songs.iterator();

		// While there are still results...
		Song tmpSong;
		while (iter.hasNext()) {
			tmpSong = iter.next();
			// Prints results to console
			System.out.println("---------------------------------\n"+"Name: "+tmpSong.getSongName() + ".\n" + "Artist: " +
                    tmpSong.getArtistName() + ".\n" + "Album: " +
                    tmpSong.getAlbumName() + ".\n" + "Year: " + tmpSong.getReleaseYear()+ ".\n"+"---------------------------------\n"+"\n");
		}    }
    
    /*
     * A method that sorts all of the songs alphabetically by Song Name.
     */
    
    @Override
    public void sortAllSongsBySongName() {
    List<Song> songs = getSongs();
    Collections.sort(songs, Song.songNameComparator);
	Iterator<Song> iter = songs.iterator();

		// While there are still results...
		Song tmpSong;
		while (iter.hasNext()) {
			tmpSong = iter.next();
			// Prints results to console
			System.out.println("---------------------------------\n"+"Name: "+tmpSong.getSongName() + ".\n" + "Artist: " +
                    tmpSong.getArtistName() + ".\n" + "Album: " +
                    tmpSong.getAlbumName() + ".\n" + "Year: " + tmpSong.getReleaseYear()+ ".\n"+"---------------------------------\n"+"\n");
		}    }
    /*
     * This method when called, removes the value from the database.
     */
    @Override
    public void deleteSong(Song song) {
            try {
                PreparedStatement preparedStatement1 = this.connect.prepareStatement("DELETE FROM song where name="+ Integer.toString(song.getKey()));
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
    }
   // public boolean checkifexists(Song song) {
   //             try {PreparedStatement preparedStatement2 = this.connect.prepareStatement("IF EXISTS(SELECT 1 FROM SONG WHERE "+ Integer.toString(song.getKey()) + " ");
   //             } catch (SQLException ex) {
   //                 throw new RuntimeException();
   //             }
   //            return true;
   //}

}
