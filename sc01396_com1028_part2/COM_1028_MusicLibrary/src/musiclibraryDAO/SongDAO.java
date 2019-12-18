package musiclibraryDAO;

import java.util.List;
import musiclibrary.Song;

/**
 * Create a Data Access Object for the Books.
 *
 * @author Stefanos Chatzakis
 */
public interface SongDAO {
    public List<Song> getSongs();
    public void createSong(Song song);
    public void showAllSongs();
    public void deleteSong(Song song);
    public void openConnection();
    public void closeConnection();
	public void sortAllSongsBySongName();
	public void sortAllSongsByArtistName();
	public void sortAllSongsByAlbumName();
	public void sortAllSongsByYear();
}