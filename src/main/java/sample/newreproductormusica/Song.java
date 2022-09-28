package sample.newreproductormusica;

/**
 * Class that stores Song metadata and path.
 * The class isn't used
 * @author Franco Sagot
 */
public class Song {
    
    String name;
    String artist;
    String album;
    String date;

    boolean favourite;
    String dir;

    private Song(String name, String group, String album, String date, Boolean favourite, String path){

        this.name = name;
        this.artist = group;
        this.album = album;
        this.date = date;
        
        this.favourite = favourite;
        this.dir = path;
    }

    /**
     * Returns the name of the song that is inside of the XML File
     * 
     * @return The name of the song
     */
    public String getName(){

        return this.name;
    }

    /**
     * Returns the name of the group that is inside of the XML File
     * 
     * @return The name of the band
     */
    public String getBand(){

        return this.artist;
    }

    /**
     * Returns the song's directory path that is inside of the XML File
     * 
     * @return
     */
    public String songPath(){

        return this.dir;
    }
}
