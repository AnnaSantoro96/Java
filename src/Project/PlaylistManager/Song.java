package Project.PlaylistManager;

public class Song {
   private String songName;

    public Song(String songName){
        setSongName(songName);
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if(songName == null || songName.isBlank()){
            throw new IllegalArgumentException("Invalid input");
        }else{
            this.songName = songName;
        }
    }

    public void printInfo(){
        System.out.println("Song name: " + getSongName());
    }
}
