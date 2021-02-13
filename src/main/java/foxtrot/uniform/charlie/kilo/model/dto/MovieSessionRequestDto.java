package foxtrot.uniform.charlie.kilo.model.dto;

import java.time.LocalDate;

public class MovieSessionRequestDto {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private String movieDescription;
    private Long cinemaHallId;
    private String cinemaHallDescription;
    private LocalDate showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaHallDescription() {
        return cinemaHallDescription;
    }

    public void setCinemaHallDescription(String cinemaHallDescription) {
        this.cinemaHallDescription = cinemaHallDescription;
    }

    public LocalDate getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSessionResponseDto{" + "id=" + id
                + ", movieId=" + movieId
                + ", movieTitle='" + movieTitle + '\''
                + ", movieDescription='" + movieDescription + '\''
                + ", cinemaHallId=" + cinemaHallId
                + ", cinemaHallDescription='" + cinemaHallDescription + '\''
                + ", showTime=" + showTime + '}';
    }
}
