package ar.edu.unlp.info.oo2.ejercicio1;

public class Retweet extends Tweet{
	private Tweet tweetOriginal;
	
	public Retweet(Tweet tweet) {
		super(tweet.getTexto());
		this.tweetOriginal = tweet;
	}
}
