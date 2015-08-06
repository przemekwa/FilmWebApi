package api.filmweb;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Review implements IReview  {

	final String FILMWEBSEARCHURL = "http://www.filmweb.pl/search?q=";
	final String FILMWEBURL = "http://www.filmweb.pl";
	
	@Override
	public Map<String, URL> getMovieTitleMap(String movieTitle) {
		
		if (movieTitle == null || movieTitle.isEmpty())
		{
			throw new RuntimeException("Brak podanego tytu�u szukanego filmu");
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
	public String getReview(URL movieUrl) {
		// TODO Auto-generated method stub
		return null;
	}

}
