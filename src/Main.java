import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album arijitAlbum=new Album("Arijit Singh","Arijit's album");
        Album alanAlbum= new Album("Alan walker","Alan's album");

        arijitAlbum.addSongToAlbum("Kesariya",3.4);
        arijitAlbum.addSongToAlbum("Lal ishq",5.6);
        arijitAlbum.addSongToAlbum("Tum kya mile",4.2);

        alanAlbum.addSongToAlbum("Dark side",3.5);
        alanAlbum.addSongToAlbum("alone",4.6);
        alanAlbum.addSongToAlbum("Faded",3.1);

        LinkedList<Song>myPlayList=new LinkedList<>();
        System.out.println(arijitAlbum.addToPlaylistFromAlbum("Kesariya",myPlayList));
        System.out.println(arijitAlbum.addToPlaylistFromAlbum(2,myPlayList));
        System.out.println(arijitAlbum.addToPlaylistFromAlbum(5,myPlayList));

        System.out.println(alanAlbum.addToPlaylistFromAlbum("alone",myPlayList));
        System.out.println(alanAlbum.addToPlaylistFromAlbum(3,myPlayList));
        play(myPlayList);
    }
    private  static void play(LinkedList<Song>myPlaylist)
    {
        if(myPlaylist.size()==0){
            System.out.println("Your Playlist is Empty");
            return;
        }
        ListIterator<Song>itr=myPlaylist.listIterator();
        System.out.println("Now Playing: "+itr.next());
        Scanner sc=new Scanner(System.in);
        printMenu();
        boolean quit= false;
        while (!quit){
            System.out.println("Please enter your choices");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(!itr.hasNext()){
                        System.out.println("You have reached end of Playlist");
                    }
                    else {
                        System.out.println("Currently Playing: "+itr.next());
                    }
                    break;
                case 3:
                    if(!itr.hasPrevious()){
                        System.out.println("You are the start of playlist: "+itr.previous());
                    }
                    else {
                        System.out.println("Currently Playing: "+itr.previous());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlaylist);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("Wrong Choice, Please select again");;
            }
        }
        return;
    }

    private static void printSongs(LinkedList<Song> myPlaylist) {
        for(Song song:myPlaylist)
        {
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {
        System.out.println("1. show the menu Again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Play all the songs in playlist");
        System.out.println("7. Quit Application");
    }
}