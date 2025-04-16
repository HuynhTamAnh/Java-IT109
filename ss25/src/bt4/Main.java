package bt4;
//Sử dụng mẫu thiết kế Adapter để tích hợp hai hệ thống không tương thích
//Yêu cầu:
//
//Tạo một interface MediaPlayer
//Với phương thức play(String audioType, String fileName)
//Tạo lớp AdvancedMediaPlayer để hỗ trợ định dạng mp4 và vlc
//Với 2 phương thức:
//playMp4(String fileName)
//playVlc(String fileName)
//Sử dụng một lớp Adapter để cho phép MediaPlayer phát các định dạng mp4 và vlc
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("vlc", "video.vlc");
        audioPlayer.play("avi", "movie.avi");
    }
}
