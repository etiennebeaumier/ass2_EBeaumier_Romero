/* -----------------------------------------------------
         //Assignment 2
         //Question: Part 1,2 & 3
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/
import java.io.Serializable;


/**
 * Represents a movie with various attributes such as year, title, duration, genres,
 * rating, score, director, and actors. This class implements Serializable to allow
 * movie objects to be serialized and deserialized for file storage and retrieval.
 * It includes accessor and mutator methods for each attribute, an overridden equals
 * method for object comparison, and a toString method for object representation.
 */
public class Movie implements Serializable {
    // Instance variables for each movie feature
    private int year;
    private String title;
    private int duration; // in minutes
    private String genres;
    private String rating;
    private double score;
    private String director;
    private String actor1;
    private String actor2;
    private String actor3;

    /**
     * Constructs a new Movie object with specified details.
     *
     * @param year     the release year of the movie
     * @param title    the title of the movie
     * @param duration the duration of the movie in minutes
     * @param genres   the genres of the movie
     * @param rating   the rating of the movie
     * @param score    the score of the movie
     * @param director the director of the movie
     * @param actor1   the first actor in the movie
     * @param actor2   the second actor in the movie
     * @param actor3   the third actor in the movie
     */
    public Movie(int year, String title, int duration, String genres, String rating, double score, String director, String actor1, String actor2, String actor3) {
        this.year = year;
        this.title = title;
        this.duration = duration;
        this.genres = genres;
        this.rating = rating;
        this.score = score;
        this.director = director;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
    }

    /**
     * Returns the year of the movie.
     *
     * @return the year of the movie
     */
    public int getYear() {
        return year;
    }
    /**
     * Sets the year of this movie.
     * This method allows updating the year of release of the movie. It takes an {@code int}
     * argument and assigns it to the year attribute of the movie object.
     *
     * @param year the new year of release of the movie. It should be a valid year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the title of the movie.
     *
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of this movie.
     * This method allows updating the title of the movie. It takes a {@code String}
     * argument and assigns it to the title attribute of the movie object.
     *
     * @param title the new title of the movie. It should not be null or empty.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the duration of the movie.
     * This method allows updating the duration of the movie. It takes an {@code int}
     * argument and assigns it to the duration attribute of the movie object.
     * @return the duration of the movie in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of this movie.
     * @param duration the new duration of the movie in minutes. It should be a valid duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns the genres of the movie.
     * @return the genres of the movie
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets the genres of this movie.
     * @param genres the new genres of the movie. It should not be null or empty.
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * Returns the rating of the movie.
     * @return the rating of the movie
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the rating of this movie.
     * @param rating the new rating of the movie. It should not be null or empty.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Returns the score of the movie.
     * @return the score of the movie
     */
    public double getScore() {
        return score;
    }
/**
     * Sets the score of this movie.
     * @param score the new score of the movie. It should be a valid score.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Returns the director of the movie.
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }
/**
     * Sets the director of this movie.
     * @param director the new director of the movie. It should not be null or empty.
     */
    public void setDirector(String director) {
        this.director = director;
    }
/**
     * Returns the first actor in the movie.
     * @return the first actor in the movie
     */
    public String getActor1() {
        return actor1;
    }
/**
     * Sets the first actor of this movie.
     * @param actor1 the new first actor of the movie. It should not be null or empty.
     */
    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }
/**
     * Returns the second actor in the movie.
     * @return the second actor in the movie
     */
    public String getActor2() {
        return actor2;
    }
/**
     * Sets the second actor of this movie.
     * @param actor2 the new second actor of the movie. It should not be null or empty.
     */
    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }
/**
     * Returns the third actor in the movie.
     * @return the third actor in the movie
     */
    public String getActor3() {
        return actor3;
    }
/**
     * Sets the third actor of this movie.
     * @param actor3 the new third actor of the movie. It should not be null or empty.
     */
    public void setActor3(String actor3) {
        this.actor3 = actor3;
    }

    /**
     * Compares this Movie object with another object for equality. The result is true if and
     * only if the argument is not null and is a Movie object that has the same values for
     * all movie attributes.
     *
     * @param obj the object to compare this Movie against
     * @return true if the given object represents a Movie equivalent to this movie, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie movie = (Movie) obj;
        return year == movie.year &&
                duration == movie.duration &&
                Double.compare(movie.score, score) == 0 &&
                title.equals(movie.title) &&
                genres.equals(movie.genres) &&
                rating.equals(movie.rating) &&
                director.equals(movie.director) &&
                actor1.equals(movie.actor1) &&
                actor2.equals(movie.actor2) &&
                actor3.equals(movie.actor3);
    }

    /**
     * Returns a string representation of this Movie object, containing all its attributes.
     *
     * @return a string representation of this Movie
     */
  //  @Override
  public String toString() {
        return "Movie details: \t" +
                "year: " + year +
                ", title: " + title +
                ", duration: " + duration + " minutes " +
                ", genres : " + genres +
                ", rating : " + rating +
                ", score : " + score +
                ", director : " + director +
                ", actor1 : " + actor1 +
                ", actor2 : " + actor2 +
                ", actor3 : " + actor3;
    }


}
