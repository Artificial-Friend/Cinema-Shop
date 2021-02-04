package foxtrot.uniform.charlie.kilo;

import foxtrot.uniform.charlie.kilo.lib.Injector;
import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.service.AuthenticationService;
import foxtrot.uniform.charlie.kilo.service.CinemaHallService;
import foxtrot.uniform.charlie.kilo.service.MovieService;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import foxtrot.uniform.charlie.kilo.service.ShoppingCartService;
import foxtrot.uniform.charlie.kilo.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("foxtrot.uniform.charlie.kilo");
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final UserService userService
            = (UserService) injector.getInstance(UserService.class);
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setTitle("Fast and Furious");
        movie1.setDescription("car go wroom wroom");
        Movie movie2 = new Movie();
        movie2.setTitle("Mate Academy");
        movie2.setDescription("A story of success");
        movieService.add(movie1);
        movieService.add(movie2);
        movieService.getAll().forEach(System.out::println);
        CinemaHall cinemaHall1 = new CinemaHall();
        cinemaHall1.setCapacity(69);
        cinemaHall1.setDescription("wat");
        CinemaHall cinemaHall2 = new CinemaHall();
        cinemaHall2.setCapacity(1337);
        cinemaHall2.setDescription("still dunno");
        cinemaHallService.add(cinemaHall1);
        cinemaHallService.add(cinemaHall2);
        System.out.println();
        System.out.println("\033[33mCinema Halls\033[0m");
        System.out.println(cinemaHallService.getAll().toString());
        MovieSession movieSession1 = new MovieSession();
        movieSession1.setMovie(movie1);
        movieSession1.setCinemaHall(cinemaHall1);
        movieSession1.setShowTime(LocalDateTime.now());
        MovieSession movieSession2 = new MovieSession();
        movieSession2.setMovie(movie2);
        movieSession2.setCinemaHall(cinemaHall2);
        movieSession2.setShowTime(LocalDateTime.of(2020, 11, 30, 23, 59));
        movieSessionService.add(movieSession1);
        movieSessionService.add(movieSession2);
        System.out.println();
        System.out.println("\033[33mMovie Sessions\033[0m");
        System.out.println(movieSession1);
        System.out.println(movieSession2);
        List<MovieSession> availableSessions = movieSessionService.findAvailableSessions(
                movie1.getId(), LocalDate.now());
        System.out.println();
        System.out.println("\033[33mAvailable Sessions\033[0m");
        availableSessions.forEach(System.out::println);
        User user2 = authenticationService.register("bob@gmail.com", "11111");
        System.out.println();
        System.out.println("\033[33mLogging in\033[0m");
        User user1 = authenticationService.register("alice@gmail.com", "12345");
        System.out.println(authenticationService.login("alice@gmail.com", "12345"));
        shoppingCartService.registerNewShoppingCart(user1);
        shoppingCartService.addSession(movieSession1, user1);
        ShoppingCart byUser = shoppingCartService.getByUser(user1);
        System.out.println();
        System.out.println("\033[33mShopping Cart by user1\033[0m");
        System.out.println(byUser);
        shoppingCartService.clear(byUser);
        System.out.println();
        System.out.println("\033[33mShopping Cart by user1 after clearing\033[0m");
        System.out.println(shoppingCartService.getByUser(user1));
    }
}
