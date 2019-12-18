package musiclibraryDAO;

/**
 *
 * @author stefanos
 */
public class DAOSongFactory {
	
	 /*
     * Singleton instance of the BookDAOImpl;
     */
	
    private static final SongDAO songDAO = new SongDAOImpl();
    
    public static SongDAO getSongDAO() {
        return DAOSongFactory.songDAO;
        
    }
}
