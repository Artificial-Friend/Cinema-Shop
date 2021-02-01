package foxtrot.uniform.charlie.kilo.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movieSession")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaHall_id")
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public MovieSession setId(Long id) {
        this.id = id;
        return this;
    }

    public Movie getMovie() {
        return movie;
    }

    public MovieSession setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public MovieSession setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
        return this;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public MovieSession setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
        return this;
    }

    @Override
    public String toString() {
        return "MovieSession{" + "id=" + id
                + ", movie=" + movie
                + ", cinemaHall=" + cinemaHall
                + ", showTime=" + showTime + '}';
    }
}
