package JavaPatterns;

public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer("Vlc");
		audioPlayer.play("Chainsmokers:closer");
	}
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;
	String mediaType;

	public AudioPlayer(String mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public void play(String music) {
		if (this.mediaType == "Mp3") {
			System.out.println("Playing in mp3 format:" + music);
		} else if (this.mediaType == "Vlc" || this.mediaType == "Mpv4") {
			mediaAdapter = new MediaAdapter(this.mediaType);
			mediaAdapter.play(music);
		}

	}
}

interface MediaPlayer {
	void play(String music);
}

interface AdvancedMediaPlayer {
	void playVlcPlayer(String music);

	void playMp4Player(String music);
}

class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlcPlayer(String music) {
		System.out.println("Playing in Vlc:" + music);

	}

	@Override
	public void playMp4Player(String music) {
		// TODO Auto-generated method stub

	}

}

class Mpv4 implements AdvancedMediaPlayer {

	@Override
	public void playVlcPlayer(String music) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMp4Player(String music) {
		System.out.println("Playing in mpv4:" + music);

	}

}

class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer mediaPlayer;
	String mediaFormat;

	public MediaAdapter(String musicFormat) {
		this.mediaFormat = musicFormat;
	}

	@Override
	public void play(String music) {
		if (this.mediaFormat == "Vlc") {
			mediaPlayer = new VlcPlayer();
			mediaPlayer.playVlcPlayer(music);
		}
		if (this.mediaFormat == "Mpv4") {
			mediaPlayer = new Mpv4();
			mediaPlayer.playMp4Player(music);
		}

	}

}