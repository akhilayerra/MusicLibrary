package com.example.song;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.SongService;

@RestController
public class SongController{
    SongService songservice=new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs(){
        return songservice.getAllSongs();
    }
    @GetMapping("/songs/{songId}")
    public Song getSongbyiD(@PathVariable("songId") int songId){
        return songservice.getSongbyId(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songservice.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId,@RequestBody Song song){
        return songservice.updateSong(songId,song);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
            songservice.deleteSong(songId);
    }
}


