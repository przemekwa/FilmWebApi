package api.filmweb;

import java.net.URL;
import java.util.Map;

public interface IReview {
	public Map<String, URL> getMovieTitleMap(String movieTitle);
	public String getReview(URL movieUrl);
}
