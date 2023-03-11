
package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.song.Song;
import com.example.song.SongRepository;


// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueid=6;
    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code
    
    @Override
    public ArrayList<Song> getAllSongs(){
        Collection<Song> songs1=playlist.values();
        ArrayList<Song> songs=new ArrayList<>(songs1);
        return songs;
    }
    @Override
    public Song getSongbyId(int songId){
        Song song =playlist.get(songId);
        if(song==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Song addSong(Song song){
        song.setSongId( uniqueid);
        playlist.put(uniqueid,song);
        uniqueid=uniqueid+1;
        return song;
    }
    @Override
    public Song updateSong(int songId, Song song){
        Song song1=playlist.get(songId);
        if(song1==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(song.getSongName()!=null){
            song1.setSongName(song.getSongName());
        }
        if (song.getLyricist()!=null){
            song1.setLyricist(song.getLyricist());
        }
        if (song.getSinger()!=null){
            song1.setSinger(song.getSinger());
        }
        if (song.getMusicDirector()!=null){
            song1.setMusicDirector(song.getMusicDirector());
        }
        return song1;
    }
    @Override
    public void deleteSong(int songId){
        Song song=playlist.get(songId);

        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}