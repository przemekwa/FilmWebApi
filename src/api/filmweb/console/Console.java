package api.filmweb.console;

import java.net.URL;
import java.util.Map;

import api.filmweb.IReview;
import api.filmweb.Review;

public class Console {

	public static void main(String[] args) {
		IReview review = new Review();
		Map<String, URL> movieTitle = review.getMovieTitleMap(args[0]);
		
		for (String s: movieTitle.keySet())
		{
			System.out.printf("%50s - %s\n", s, movieTitle.get(s));
		}

	}

}
