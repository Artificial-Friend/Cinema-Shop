package foxtrot.uniform.charlie.kilo.model.dto;

public class MovieSessionRequestDto {
    private Long movieId;
    private String movieTitle;
    private String movieDescription;
    private Long cinemaHallId;
    private String cinemaHallDescription;
    private String showTime;

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

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSessionResponseDto{" + ", movieId=" + movieId
                + ", movieTitle='" + movieTitle + '\''
                + ", movieDescription='" + movieDescription + '\''
                + ", cinemaHallId=" + cinemaHallId
                + ", cinemaHallDescription='" + cinemaHallDescription + '\''
                + ", showTime=" + showTime + '}';
    }
}
