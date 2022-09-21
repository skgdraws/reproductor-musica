public class Song {
    
    String name;
    String group;

    boolean favourite;
    String dir;

    private Song(String name, String group, Boolean favourite, String path){

        this.name = name;
        this.group = group;
        this.favourite = favourite;

        this.dir = path;
    }

    public String getName(){

        return this.name;
    }

    public String getBand(){

        return this.group;
    }

    public String songPath(){

        return this.dir;
    }
}
