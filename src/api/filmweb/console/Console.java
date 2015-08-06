package api.filmweb.console;

import java.net.URL;
import java.util.Map;

import api.filmweb.IReview;
import api.filmweb.Review;

public class Console {

	public static void main(String[] args) {
		
		if (args.length == 0)
		{
			System.out.println("Brak parametru z nazw� filmu.Nazwa filmu jest wymagana.");
		    return;
		}
		
		IReview review = new Review();
		Map<String, URL> movieTitle = review.getMovieTitleMap(args[0]);
		
		for (String s: movieTitle.keySet())
		{
			System.out.printf("%50s - %s\n", s, movieTitle.get(s));
		}

	}

}
