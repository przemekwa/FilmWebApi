package api.filmweb;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FilmWebApi implements IFilmWebApi  {

	final String FILMWEBSEARCHURL = "http://www.filmweb.pl/search?q=";
	final String FILMWEBURL = "http://www.filmweb.pl";
	
	@Override
	public Map<String, URL> getMoviesUrl(String movieTitle) {
		
		if (movieTitle == null || movieTitle.isEmpty())
		{
			throw new RuntimeException("Brak podanego tytułu szukanego filmu");
		}
		
		Map<String,URL> dict = new Hashtable<String, URL>();
		try {
			 URL searchUrl = new URL(FILMWEBSEARCHURL + movieTitle.toLowerCase());
			 Document doc = Jsoup.parse(searchUrl, 40000);
			 Elements hitDescWrapperClass = doc.select("div[class=\"hitDescWrapper\"");
			 
			 if (hitDescWrapperClass == null) {
				 return null;
		     }
			 
		   	 for(Element hDWC: hitDescWrapperClass) {
		   		 for(Element a: hDWC.select("a[class=\"hdr hdr-medium hitTitle\"]")) {
		   			 dict.put(a.text(), new URL(String.format("%s%s", FILMWEBURL, a.attributes().get("href"))));
		   	     }
		     }
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		  return dict;
	}

	@Override
	public URL getEditorReviewUrl(URL movieUrl) {
	
		if (movieUrl == null)
		{
			throw new RuntimeException("Brak URl filmu");
		}
		 
		try {
			Document doc = Jsoup.parse(movieUrl, 40000);
			Elements editorialReview = doc.select("div[id=\"editorialReview\"");
			
			if (editorialReview == null)
			{
				return null;
			}
			
			Elements reviewUrl = editorialReview.select("a[class=\"normal\"");
			
			for (Element e : reviewUrl)
			{
				return new URL(FILMWEBURL + e.attributes().get("href"));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

}
