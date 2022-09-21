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

    public String getName(){

        return this.name;
    }

    public String getBand(){

        return this.artist;
    }

    public String songPath(){

        return this.dir;
    }
}
