package song;

public class Song {
    private String title;
    private Song (String t) {
        this.title=t;
    }
    private String getTitle() {
        return title;
    }
    public static void main(String[] args) {
        Song mySong = new Song("Let it go");
        Song yourSong = new Song("강남스타일");
        System.out.println("내 노래는 " + mySong.getTitle());
        System.out.println("너 노래는 " + yourSong.getTitle());
    }
}