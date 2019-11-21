package com.bangle.movie.Controllers;

import com.bangle.movie.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping( value="/moviestitles/{title}" )
    public List <String> getMovieTitles ( @PathVariable("title") String title) {
        return movieService.getMoviesTitles(title);
    }
}
