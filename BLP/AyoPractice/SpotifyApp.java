package BLP.AyoPractice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cenumah on 25/05/2019
 */
public class SpotifyApp {
    /*
     * How would you design a music app like Spotify?
     * (Classes and connections between them)
     */

    // download music
    // listening to music
    // creating a playlist


    class Song {
        private Long id;
        private String name;
        private String artist;
        private String genre;
        private String url;
        Song () {}

        void listen(){
            System.out.println("Listening to "+name);
        }
    }

    class Playlist {
        private Long id;
        private String name;
        private List<String> songNames;

        Playlist(String name){

        }

        void addSong(String songName){
            songNames.add(songName);
        }

        boolean removeSong (String songName) {
            songNames.remove(songName);
            return true;
        }
    }


    class Person {
        private Map<String, Song> mapOfSongs = new HashMap<>();
        private Map<String, Playlist> mapOfPlaylists = new HashMap<>();


        List<Song> searchForSongOnCloud(String songName){
            return Arrays.asList(new Song()); //Possible URLs to be used for download;
        }

        void download(String url){
            Song newSong = new Song();//Some impl to get song from URL
            this.mapOfSongs.put(newSong.name ,newSong);
        }


        void listen(String songName){
            if(!mapOfSongs.containsKey(songName)){
                throw new IllegalArgumentException ("User needs to download song");
            }
            Song song = mapOfSongs.get(songName);
            if(song == null){
                throw new IllegalArgumentException ("Song does not exist");
            }

            song.listen();
        }

        Playlist createPlaylist (String name){
            Playlist playlist = new Playlist(name);
            return playlist;
        }

        Playlist addToPlaylist (String songToAdd, String playListName) {
            if(!mapOfPlaylists.containsKey(playListName)){
                throw new IllegalArgumentException ("Playlist does not exist");
            }
            if(!mapOfSongs.containsKey(songToAdd)){
                throw new IllegalArgumentException ("User needs to download song");
            }

            Playlist playlist = mapOfPlaylists.get(playListName);
            playlist.addSong(songToAdd);
            mapOfPlaylists.replace(playListName, playlist);
            return playlist;
        }


    }



}

