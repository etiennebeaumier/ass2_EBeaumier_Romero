import Exceptions.*;

/**
 * The {@code Part1} class contains methods for validating movie records extracted from CSV files.
 * It performs comprehensive validation checks, including both syntax and semantic validations for
 * fields such as title, year, duration, genre, rating, and score.
 * <p>
 * This class utilizes {@code CSVUtils.removeCommasInsideQuotes} to preprocess each line for
 * easier parsing, especially to handle fields that may include commas within quoted strings.
 * Additionally, it leverages custom exceptions to report specific validation failures.
 */
public class Part1 {

    /**
     * Processes the given manifest file to partition movie records based on specific criteria.
     *
     * @param manifest The path to the manifest file listing CSV files to be processed.
     */
    public static void do_part1(String manifest) {


    }

    /**
     * Validates a movie record extracted from a CSV file.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is valid, {@code false} otherwise.
     * @throws MissingQuotesException If the input line has mismatched quotes.
     * @throws ExcessFieldsException  If the input line has excess fields.
     * @throws MissingFieldsException If the input line has missing fields.
     * @throws BadTitleException      If the input line has a bad title.
     * @throws BadNameException       If the input line has a bad name.
     * @throws BadYearException       If the input line has a bad year.
     * @throws BadDurationException   If the input line has a bad duration.
     * @throws BadGenreException      If the input line has a bad genre.
     * @throws BadRatingException     If the input line has a bad rating.
     * @throws BadScoreException      If the input line has a bad score.
     */
    public static boolean checkValidMovie(String line) throws MissingQuotesException, ExcessFieldsException,
            MissingFieldsException, BadTitleException, BadNameException, BadYearException, BadDurationException,
            BadGenreException, BadRatingException, BadScoreException {
        return !checkMissingQuotes(line) && !checkExcessFields(line) && !checkMissingFields(line) &&
                !checkMissingTitle(line) && !checkMissingNames(line) && !checkMissingYear(line) &&
                !checkInvalidYear(line) && !checkMissingDuration(line) && !checkInvalidDuration(line) &&
                !checkMissingGenre(line) && !checkInvalidGenre(line) && !checkMissingRating(line) &&
                !checkInvalidRating(line) && !checkMissingScore(line) && !checkInvalidScore(line);
    }

    /**
     * Checks if a movie record has mismatched quotes.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has mismatched quotes, {@code false} otherwise.
     * @throws MissingQuotesException If the input line has mismatched quotes.
     */

    public static boolean checkMissingQuotes(String line) throws MissingQuotesException {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') {
                count++;
            }
        }
        if (count % 2 != 0) {
            throw new MissingQuotesException("Mismatched quotes in input line.");
        }
        return false;
    }

    /**
     * Checks if a movie record has excess fields.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has excess fields, {@code false} otherwise.
     * @throws ExcessFieldsException If the input line has mismatched fields.
     */
    public static boolean checkExcessFields(String line) throws MissingQuotesException, ExcessFieldsException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts.length > 10) {
            throw new ExcessFieldsException("Excess fields in input line.");
        }
        return false;
    }

    /**
     * Checks if a movie record has missing fields.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has missing fields, {@code false} otherwise.
     * @throws MissingFieldsException If the input line has mismatched fields.
     */
    public static boolean checkMissingFields(String line) throws MissingQuotesException, MissingFieldsException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts.length < 10) {
            throw new MissingFieldsException("Missing fields in input line.");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a title.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a title, {@code false} otherwise.
     * @throws BadTitleException If the input line has missing title.
     */
    public static boolean checkMissingTitle(String line) throws MissingQuotesException, BadTitleException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[1].equals("")) {
            throw new BadTitleException("Missing title");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a name.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a name, {@code false} otherwise.
     * @throws BadNameException If the input line has missing names.
     */
    public static boolean checkMissingNames(String line) throws MissingQuotesException, BadNameException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if ((parts[6].equals("") || parts[7].equals("") || parts[8].equals("") || parts[9].equals(""))) {
            throw new BadNameException("Missing name");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a year.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a year, {@code false} otherwise.
     * @throws BadYearException If the input line has missing year.
     */
    public static boolean checkMissingYear(String line) throws MissingQuotesException, BadYearException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[0].equals("")) {
            throw new BadYearException("Missing year");
        }
        return false;
    }

    /**
     * Checks if a movie record has an invalid year.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has an invalid year, {@code false} otherwise.
     * @throws BadYearException If the input line has bad year.
     */
    public static boolean checkInvalidYear(String line) throws MissingQuotesException, BadYearException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if ((Integer.parseInt(parts[0]) < 1990 || Integer.parseInt(parts[0]) > 1999)) {
            throw new BadYearException("Bad year");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a duration.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a duration, {@code false} otherwise.
     * @throws BadDurationException If the input line has missing duration.
     */
    public static boolean checkMissingDuration(String line) throws MissingQuotesException, BadDurationException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[2].equals("")) {
            throw new BadDurationException("Missing duration");
        }
        return false;
    }

    /**
     * Checks if a movie record has an invalid duration.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has an invalid duration, {@code false} otherwise.
     * @throws BadDurationException If the input line has bad duration.
     */
    public static boolean checkInvalidDuration(String line) throws MissingQuotesException, BadDurationException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if ((Integer.parseInt(parts[2]) < 30 || Integer.parseInt(parts[2]) > 300)) {
            throw new BadDurationException("Bad duration");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a genre.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a genre, {@code false} otherwise.
     * @throws BadGenreException If the input line has missing genre.
     */
    public static boolean checkMissingGenre(String line) throws MissingQuotesException, BadGenreException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[3].equals("")) {
            throw new BadGenreException("Missing genre");
        }
        return false;
    }

    /**
     * Checks if a movie record has an invalid genre.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has an invalid genre, {@code false} otherwise.
     * @throws BadGenreException If the input line has bad genre.
     */
    public static boolean checkInvalidGenre(String line) throws MissingQuotesException, BadGenreException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (!(parts[3].equals("Musical") || parts[3].equals("Comedy") || parts[3].equals("Animation") ||
                parts[3].equals("Adventure") || parts[3].equals("Drama") || parts[3].equals("Crime") ||
                parts[3].equals("Biography") || parts[3].equals("Horror") || parts[3].equals("Action") ||
                parts[3].equals("Documentary") || parts[3].equals("Fantasy") || parts[3].equals("Mystery") ||
                parts[3].equals("Sci-Fi") || parts[3].equals("Family") || parts[3].equals("Romance") || parts[3].equals("Thriller")
                || parts[3].equals("Western"))) {
            throw new BadGenreException("Bad genre");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a rating.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a rating, {@code false} otherwise.
     * @throws BadRatingException If the input line has missing rating.
     */
    public static boolean checkMissingRating(String line) throws MissingQuotesException, BadRatingException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[4].equals("")) {
            throw new BadRatingException("Missing rating");
        }
        return false;
    }

    /**
     * Checks if a movie record has an invalid rating.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has an invalid rating, {@code false} otherwise.
     * @throws BadRatingException If the input line has bad rating.
     */
    public static boolean checkInvalidRating(String line) throws MissingQuotesException, BadRatingException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (!parts[4].equals("PG") && !parts[4].equals("Unrated") && !parts[4].equals("G") && !parts[4].equals("R") &&
                !parts[4].equals("PG-13") && !parts[4].equals("NC-17")) {
            throw new BadRatingException("Bad rating");
        }
        return false;
    }

    /**
     * Checks if a movie record is missing a score.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record is missing a score, {@code false} otherwise.
     * @throws BadScoreException If the input line has missing score.
     */
    public static boolean checkMissingScore(String line) throws MissingQuotesException, BadScoreException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (parts[5].equals("")) {
            throw new BadScoreException("Missing score");
        }
        return false;
    }

    /**
     * Checks if a movie record has an invalid score.
     *
     * @param line The movie record as a string.
     * @return {@code true} if the movie record has an invalid score, {@code false} otherwise.
     * @throws BadScoreException If the input line has bad score.
     */
    public static boolean checkInvalidScore(String line) throws MissingQuotesException, BadScoreException {
        String line2 = CSVUtils.removeCommasInsideQuotes(line);
        String[] parts = line2.split(",");
        if (Double.parseDouble(parts[5]) < 0 || Double.parseDouble(parts[5]) > 10) {
            throw new BadScoreException("Bad score");
        }
        return false;
    }
}
