package Project.PlaylistManager;

public class Main {
    static void main() {
        PlaylistManager playlistManager = new PlaylistManager();

        playlistManager.addSong(new Song("Fade to black"));
        playlistManager.addSong(new Song("Dream On"));
        playlistManager.addSong(new Song("Here comes the sun"));
        playlistManager.addSong(new Song("Hurracane"));

        System.out.println("Full Playlist");
        playlistManager.printPlaylist();

        IO.println();
        playlistManager.addSongFirst(new Song("Enter Sandmen"));
        System.out.println("Playlist with add first");
        playlistManager.printPlaylist();

        IO.println();
        playlistManager.removeLastSong();
        System.out.println("Remove the last song");
        playlistManager.removeLastSong();
        playlistManager.printPlaylist();

        IO.println();
        System.out.println("First Song");
        Song firstSong = playlistManager.getFirstSong();
        if (firstSong != null) {
            System.out.println(firstSong.getSongName());
        }

        IO.println();
        System.out.println("Last song");
        Song lastSong = playlistManager.getLastSong();
        if (firstSong != null) {
            System.out.println(lastSong.getSongName());
        }


    }
}
