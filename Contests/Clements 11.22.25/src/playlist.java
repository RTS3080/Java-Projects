import java.util.*;
import java.io.*;
import java.awt.*;

public class playlist{
    class Playlist {
        class Song {
            String name, artist, genre;

            public Song(String name, String artist, String genre) {
                this.name = name;
                this.artist = artist;
                this.genre = genre;
            }

            public String toString() {
                return name;
            }
        }

        int limit;
        ArrayList<Song> songs;
        HashSet<String> bannedNames, bannedGenres, bannedArtists;

        public Playlist(int limit) {
            songs = new ArrayList<>();
            bannedNames = new HashSet<>();
            bannedGenres = new HashSet<>();
            bannedArtists = new HashSet<>();
            this.limit = limit;
        }

        public void removeName(String name) {
            songs.removeIf(song -> song.name.equals(name));
        }

        public void removeGenre(String genre) {
            songs.removeIf(song -> song.genre.equals(genre));
        }

        public void removeArtist(String artist) {
            songs.removeIf(song -> song.artist.equals(artist));
        }

        public void banName(String name) {
            bannedNames.add(name);
            removeName(name);
        }

        public void banGenre(String genre) {
            bannedGenres.add(genre);
            removeGenre(genre);
        }

        public void banArtist(String artist) {
            bannedArtists.add(artist);
            removeArtist(artist);
        }

        public void add(String...args) {
            String name = args[0];
            String artist = args[1];
            String genre = args[2];

            if (bannedNames.contains(name) || bannedArtists.contains(artist) || bannedGenres.contains(genre)) {
                return;
            }

            if (limit == songs.size()) {
                songs.removeLast();
            }

            songs.addFirst(new Song(name, artist, genre));
        }

        public String toString() {
            return songs.toString().replace("[", "").replace("]", "");
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("playlist".toLowerCase()+".dat"));

        ArrayList<String[]> orig = new ArrayList<>();
        int times=f.nextInt();
        int times2=f.nextInt(); f.nextLine();
        while(times-->0){
            String name = f.next().replace(":", "");
            String artist = f.next();
            String genre = f.next();

            orig.add(new String[] {name, artist, genre});
        }

        Playlist pl = new Playlist(orig.size());
        for (String[] song : orig) {
            pl.add(song);
        }

        Collections.reverse(pl.songs);

        while(times2-->0){
            int x = f.nextInt(); f.nextLine();

            for (int i = 0; i < x; i++) {
                String command = f.next().toUpperCase();
                if (command.equals("REMOVEN")) {
                    pl.removeName(f.next());
                }

                if (command.equals("REMOVEG")) {
                    pl.removeGenre(f.next());
                }

                if (command.equals("REMOVEA")) {
                    pl.removeArtist(f.next());
                }

                if (command.equals("BANN")) {
                    pl.banName(f.next());
                }

                if (command.equals("BANG")) {
                    pl.banGenre(f.next());
                }

                if (command.equals("BANA")) {
                    pl.banArtist(f.next());
                }

                if (command.equals("ADD")) {
                    pl.add(f.next(), f.next(), f.next());
                }

                if (command.equals("ROTATE")) {
                    Collections.rotate(pl.songs, f.nextInt());
                }
            }
            System.out.println(pl);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new playlist().run();
    }
}
