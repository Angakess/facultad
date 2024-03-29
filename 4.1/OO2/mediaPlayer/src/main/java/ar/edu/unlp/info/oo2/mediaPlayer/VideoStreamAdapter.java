package ar.edu.unlp.info.oo2.mediaPlayer;

//ADAPTER

public class VideoStreamAdapter extends Media{
	private VideoStream stream;
	
	public VideoStreamAdapter(VideoStream stream) {
		this.stream = stream;
	}
	public String play() {
		return stream.reproduce();
	}

}
