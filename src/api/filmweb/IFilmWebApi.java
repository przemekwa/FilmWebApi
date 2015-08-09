package api.filmweb;

import java.net.URL;
import java.util.Map;

public interface IFilmWebApi {
	public Map<String, URL> getMoviesUrl(String movieTitle);
	public URL getEditorReviewUrl(URL movieUrl);
}
