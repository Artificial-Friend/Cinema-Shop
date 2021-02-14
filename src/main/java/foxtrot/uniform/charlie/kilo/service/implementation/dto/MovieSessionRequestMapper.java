package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.dao.CinemaHallDao;
import foxtrot.uniform.charlie.kilo.dao.MovieDao;
import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.model.dto.MovieSessionRequestDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper implements Mapper<MovieSessionRequestDto, MovieSession> {
    private final MovieDao movieDao;
    private final CinemaHallDao cinemaHallDao;

    @Autowired
    public MovieSessionRequestMapper(MovieDao movieDao, CinemaHallDao cinemaHallDao) {
        this.movieDao = movieDao;
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public MovieSessionRequestDto toDto(MovieSession movieSession) {
        MovieSessionRequestDto dto = new MovieSessionRequestDto();
        dto.setId(movieSession.getId());
        dto.setShowTime(movieSession.getShowTime().toString());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setMovieTitle(movieSession.getMovie().getTitle());
        dto.setMovieDescription(movieSession.getMovie().getDescription());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setCinemaHallDescription(movieSession.getCinemaHall().getDescription());
        return dto;
    }

    @Override
    public MovieSession fromDto(MovieSessionRequestDto dto) {
        Movie movie = movieDao.get(dto.getMovieId());
        CinemaHall cinemaHall = cinemaHallDao.get(dto.getCinemaHallId());
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setId(dto.getId());
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return movieSession;
    }
}
