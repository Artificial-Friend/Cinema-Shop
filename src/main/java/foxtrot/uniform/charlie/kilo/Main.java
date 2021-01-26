package foxtrot.uniform.charlie.kilo;

import foxtrot.uniform.charlie.kilo.lib.Injector;
import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.service.MovieService;

public class Main {
    private static final Injector injector = Injector.getInstance("foxtrot.uniform.charlie.kilo");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
