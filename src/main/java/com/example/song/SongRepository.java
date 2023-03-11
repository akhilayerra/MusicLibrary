package com.example.song;
import com.example.song.Song;
import java.util.*;
public interface SongRepository{
    ArrayList<Song> getAllSongs();
    Song getSongbyId(int songId);
    Song addSong(Song song);
    Song updateSong(int songId,Song song);
    void deleteSong(int songId);
}