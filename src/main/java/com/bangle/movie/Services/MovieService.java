package com.bangle.movie.Services;

import com.bangle.movie.Entities.MovieEntry;
import com.bangle.movie.Entities.Movies;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final static RestTemplate restTemplate = new RestTemplate();
    private final static String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title={title}&page={pageNo}";

    static List<String> getAllTitles(List< Movies > movies) {
        List<String> titles = new ArrayList <>();

        for (int i=0; i< movies.size(); i++) {

            List < MovieEntry > movieEntries = movies.get(i).getMovies();

            for (int j = 0; j < movieEntries.size(); j++) {
                titles.add((movieEntries.get(j)).getTitle());
            }
        }
        titles.sort((x,y)-> x.compareTo(y));
        return titles;
    }

    public List <String> getMoviesTitles( String title) {
        // Get number of page first
        URI uri = new UriTemplate("https://jsonmock.hackerrank.com/api/movies/search/?Title={title}").expand(title);

        Movies movies = restTemplate.getForObject(uri,Movies.class);
//        ResponseEntity < Movies > movies = restTemplate
//                .getForEntity(uri, Movies.class);

        Integer pageNo = movies.getTotalPages();

        List<Movies> movieList = new ArrayList <>();
        movieList.add(movies);

        for (int i=2; i<= pageNo; i++) {
            uri = new UriTemplate(url).expand(title,i);
            movies = restTemplate.getForObject(uri,Movies.class);
            movieList.add(movies);
        }

        List < String > titles = getAllTitles(movieList);
        return titles;
    }
}
