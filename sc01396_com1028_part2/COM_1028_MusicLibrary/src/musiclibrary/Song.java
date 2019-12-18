package musiclibrary;

import java.util.Comparator;

/**
 *
 * @author Stefanos Chatzakis
 */
public class Song {
    private String songName;
    private String artistName;
    private String albumName;
    private int releaseYear;
    private int key = 0;
    private static int key_number = 0;
    /*
     * Constructor of the class.
     * @param songName, artistName, albumName, releaseYear
     */
    	public Song(String songName, String artistName, String albumName, int releaseYear) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.key = key_number;
        key_number++;
    }

    	/*
    	 * Getter for all the fields and a setter for the key.
    	 */
    public String getSongName() {
        return this.songName;
    }
    
    public String getArtistName() {
        return this.artistName;
    }
    
    public String getAlbumName () {
        return this.albumName;
    }
    
    public int getReleaseYear() {
        return this.releaseYear;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
    
    /*
     * A toString method that allows a default format of printing these objects when
     * this method is called.
     * @return String
     */
    
    @Override
    public String toString() {
    return ("Name: "+ this.getSongName() + ". Artist: " + this.getArtistName()
            + ". Album: " + this.getAlbumName() + ". Year: " + this.releaseYear
            + ".");
    }

    public static Comparator<Song> songNameComparator = new Comparator<Song>() {

    		public int compare(Song s1, Song s2) {
    			   String songName1 = s1.getSongName().toUpperCase();
    			   String songName2 = s2.getSongName().toUpperCase();

    			   //ascending order
    			   return songName1.compareTo(songName2);
    		    }};
    		    
    		public static Comparator<Song> artistNameComparator = new Comparator<Song>() {

    	    		public int compare(Song s3, Song s4) {
    	    			   String artistName1 = s3.getArtistName().toUpperCase();
    	    			   String artistName2 = s4.getArtistName().toUpperCase();

    	    			   //ascending order
    	    			   return artistName1.compareTo(artistName2);
    	    		    }};
    	    		    
    	    	public static Comparator<Song> albumNameComparator = new Comparator<Song>() {

    	    	    	public int compare(Song s5, Song s6) {
    	    	    			String albumName1 = s5.getArtistName().toUpperCase();
    	    	    			String albumName2 = s6.getArtistName().toUpperCase();

    	    	    			   //ascending order
    	    	    			return albumName1.compareTo(albumName2);
    	    	    		    }};
    	    	public static Comparator<Song> yearComparator = new Comparator<Song>() {

    	    	    		    	public int compare(Song s7, Song s8) {

    	    	    		    	   int year1 = s7.getReleaseYear();
    	    	    		    	   int year2 = s8.getReleaseYear();

    	    	    		    	   /*For ascending order*/
    	    	    		    	   return year1-year2;
    	    	    		       }};
}


