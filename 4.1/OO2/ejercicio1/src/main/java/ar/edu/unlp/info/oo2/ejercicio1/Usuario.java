package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String screenName;
	private List<Tweet> tweets;
	
	public Usuario(String screenName) {
		this.screenName = screenName;
		this.tweets = new ArrayList<Tweet>();
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	public void escribirTweet(String txt) {
		int charMin = 1;
		int charMax = 280;
		if((txt.length() >= charMin)&&(txt.length() <= charMax)) {
			Tweet t = new Tweet(txt);
			agregarTweet(t);
		}
		else {
			System.out.print("Error por limite de caracteres");
		}
	}
	public void hacerRetweet(Tweet twt) {
		Retweet rt = new Retweet(twt);
		agregarTweet(rt);
	}
	
	private void agregarTweet(Tweet t) {
		this.tweets.add(t);
	}
}
