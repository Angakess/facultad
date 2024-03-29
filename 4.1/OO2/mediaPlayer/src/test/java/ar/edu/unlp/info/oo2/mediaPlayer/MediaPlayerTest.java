package ar.edu.unlp.info.oo2.mediaPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	MediaPlayer player;
	Audio audio;
	VideoFile video;
	VideoStream stream;
	VideoStreamAdapter adapter;
	
	@BeforeEach
	void setUp() throws Exception{
		audio = new Audio();
		video = new VideoFile();
		stream = new VideoStream();
		adapter = new VideoStreamAdapter(stream);
	}
	
	@Test
	public void testAudio() {
		player = new MediaPlayer(audio);
		assertEquals("Resumiendo audio",player.play());
	}
	@Test
	public void testVideo() {
		player = new MediaPlayer(video);
		assertEquals("Resumiendo video",player.play());
	}
	@Test
	public void testStream() {
		player = new MediaPlayer(adapter);
		assertEquals("Reproduciendo stream",player.play());
	}
}
