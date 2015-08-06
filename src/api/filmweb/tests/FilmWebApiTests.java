package api.filmweb.tests;

import java.net.URL;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import api.filmweb.*;

public class FilmWebApiTests {

	@Test
	public void getMovieTitleMapTests() {
		IReview review = new Review();
		Map<String, URL> movieTitles = review.getMovieTitleMap("Terminator");
		assertEquals(10, movieTitles.size());
	}
	
	@Test
	public void getMovieTitleMapPolishSignTests() {
		IReview review = new Review();
		Map<String, URL> movieTitles = review.getMovieTitleMap("było");
		assertEquals(10, movieTitles.size());
	}

}
