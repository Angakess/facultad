package ar.edu.unlp.info.oo2.mediaPlayer;

//CLIENT

public class MediaPlayer {
	private Media media;
	
	public MediaPlayer(Media media) {
		this.media = media;
	}
	
	public String play() {
		return this.media.play();
	}

}
