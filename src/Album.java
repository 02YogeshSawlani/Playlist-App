import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;

    private String name;

    private List<Song>songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs=new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    // Functionality in the album

    boolean findSong(String title)
    {
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
            {
                return true;
            }
        }
        return false;

    }

    // add songs

    public String addSongToAlbum(String title,double duration)
    {
        if(!findSong(title))
        {
            Song song=new Song(title,duration);
            this.songs.add(song);
            return "Song has been added in album";
        }
        return "Song Already Exists";
    }
    // add to playlist from album

    public  String addToPlaylistFromAlbum(String title, LinkedList<Song>playlist)
    {
       for(Song song:songs){
           if(song.getTitle().equals(title))
           {
               playlist.add(song);
               return "Song has been added in your playlist";
           }
       }
       return "Song doesn't exists in album";
    }

    /**
     * polymorphism--Method overloading
     * @param songNo
     * @param playlist
     * @return
     */
    public  String addToPlaylistFromAlbum(int songNo, LinkedList<Song>playlist)
    {
        int index=songNo-1;  // because indexing starts from zero
        if(index>=0 && index<songs.size())
        {
            playlist.add(songs.get(index));
            return "Song has been added Successfully";
        }
        return "Incorrect song number";
    }
}
