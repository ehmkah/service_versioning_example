package de.ehmkah.projects.service_versioning_example.rest_service_media_type_versioning;

import de.ehmkah.v2.Movie;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesApiControllerV2 {

  @RequestMapping(method = RequestMethod.GET, produces = "application/vnd.ehmkah.app-2.0+json")
  public ResponseEntity<List<Movie>> findMovies2(
          @ApiParam(value = "Tags used to filter the result")
          @RequestParam(value = "tags", required = false) List<String> tags,
          @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit) {
    List<Movie> movies = new ArrayList<>();
    Movie movie = new Movie();
    movie.setTitle("HUHU, version 2.0");
    movies.add(movie);
    ResponseEntity<List<Movie>> result = ResponseEntity.ok(movies);

    return result;
  }

}
