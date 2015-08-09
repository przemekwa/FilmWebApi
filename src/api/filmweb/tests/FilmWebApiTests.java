package api.filmweb.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import api.filmweb.*;

public class FilmWebApiTests {

	@Test
	public void getMoviesUrlTest() {
		IFilmWebApi review = new FilmWebApi();
		Map<String, URL> movieTitles = review.getMoviesUrl("Terminator");
		assertEquals(10, movieTitles.size());
	}
	
	@Test
	public void getMoviesUrlTestPolishString() {
		IFilmWebApi review = new FilmWebApi();
		Map<String, URL> movieTitles = review.getMoviesUrl("było");
		assertEquals(10, movieTitles.size());
	}
	
	@Test
	public void getEditorReviewUrlTest(){
		IFilmWebApi review = new FilmWebApi();
		try {
			URL reviewUrl = review.getEditorReviewUrl(new URL("http://www.filmweb.pl/Matrix.Rewolucje"));
			assertEquals(new URL("http://www.filmweb.pl/reviews/%C5%9Amier%C4%87+legendy-698").getPath(), reviewUrl.getPath());
			
		} catch (MalformedURLException e) {
			fail();
		}
	}
	
	@Test
	public void getEditorReviewNoReviewUrlTest(){
		IFilmWebApi review = new FilmWebApi();
		try {
			URL reviewUrl = review.getEditorReviewUrl(new URL("http://www.filmweb.pl/film/Maska-1994-7585"));
			assertEquals(null, reviewUrl);
			
		} catch (MalformedURLException e) {
			fail();
		}
	
	}

}
