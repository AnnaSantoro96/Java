package Project.PlaylistManager;

import java.util.LinkedList;

public class PlaylistManager {

private LinkedList<Song> songs;

    public PlaylistManager(){
        songs = new LinkedList<>();
    }

    public void addSong(Song song){
        if(song == null){
            throw new IllegalArgumentException("Invalid input");
        }else{
            songs.add(song);
        }
    }

    public void addSongFirst(Song song){
        if(song == null){
            throw new IllegalArgumentException("Invalid input");
        }else{
            songs.addFirst(song);
        }
    }

    public void removeFirstSong() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        songs.removeFirst();
    }

    public void removeLastSong(){
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        songs.removeLast();
    }

    public Song getFirstSong() {
        if (songs.isEmpty()) {
            return null;
        }

        return songs.getFirst();
    }

    public Song getLastSong(){
        if (songs.isEmpty()) {
            return null;
        }
        return songs.getLast();
    }

    public void printPlaylist(){
        if(songs.isEmpty()){
            System.out.println("No songs present...");
            return;
        }

        for(Song song : songs){
            song.printInfo();
        }
    }
}
