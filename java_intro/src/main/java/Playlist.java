import java.util.ArrayList;

public class Playlist {
    String name;
    ArrayList<Song> songs = new ArrayList<Song>(0);

    public Playlist(String name) {
        this.name = name;
    }

    boolean isEmpty() {
        return songs.isEmpty();
    }

    void addSong(Song newSong) {
        songs.add(newSong);
    }

    String[] songNames() {
        String[] songNames = new String[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            songNames[i] = songs.get(i).title;
        }
        return songNames;
    }

    int totalDuration () {
        int duration = 0;
        for (int i = 0; i < songs.size(); i++) {
            duration += songs.get(i).durationInSeconds;
        }
        return duration;
    }

    void swap(Song song1, Song song2) {
        int firstIndex = songs.indexOf(song1);
        int secondIndex = songs.indexOf(song2);
        Song temp = songs.get(secondIndex);
        songs.set(secondIndex, song1);
        songs.set(firstIndex, song2);
    }

    void removeSong(Song song) {
        songs.remove(song);
    }
}
