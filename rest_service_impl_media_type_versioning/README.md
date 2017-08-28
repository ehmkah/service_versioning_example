== Example for media-type-versioning

=== Howto use it

* start `ApplicationRestImpl`
* put breakpoints to `MoviesApiControllerV2.findMovies2`, `MoviesApiController.findMovies`
* open Restclient
* send a request to `http://localhost:8080/movies`
** no header should give you an `406 error`
** Header `Accept: application/vnd.ehmkah.app-2.0+json` => breaks in `MoviesApiControllerV2`
** Header `Accept: application/vnd.ehmkah.app-1.0+json` => breaks in `MoviesApiControllerV`

