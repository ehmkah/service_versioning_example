package de.ehmkah.projects.service_versioning_example.contract_test;

import io.swagger.annotations.*;
import io.swagger.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-04T16:03:24.691+02:00")

@Api(value = "movies", description = "the movies API")
public interface MoviesApi {

    @ApiOperation(value = "", notes = "Returns all movies from the system", response = Movie.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of movies", response = Movie.class) })
    @RequestMapping(value = "/movies",
        method = RequestMethod.GET)
    ResponseEntity<List<Movie>> findMovies(@ApiParam(value = "Tags used to filter the result") @RequestParam(value = "tags", required = false) List<String> tags, @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit);

}
