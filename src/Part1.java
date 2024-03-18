import Exceptions.*;

import java.io.*;
import java.util.Scanner;

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
    public static String do_part1(String manifest) {

        PrintWriter badMovie = null, part2_manifest = null, musical = null, comedy = null, animation = null,
                adventure = null, drama = null, crime = null, biography = null, horror = null, action = null,
                documentary = null, fantasy = null, mystery = null, sci_fi = null, family = null, romance = null,
                thriller = null, western = null;

        Scanner part1_manifest = null;


        try {
            badMovie = new PrintWriter(new FileOutputStream("bad_movie_records.txt"));
            part2_manifest = new PrintWriter(new FileOutputStream("part2_manifest.txt"));
            musical = new PrintWriter(new FileOutputStream("musical.csv"));
            comedy = new PrintWriter(new FileOutputStream("comedy.csv"));
            animation = new PrintWriter(new FileOutputStream("animation.csv"));
            adventure = new PrintWriter(new FileOutputStream("adventure.csv"));
            drama = new PrintWriter(new FileOutputStream("drama.csv"));
            crime = new PrintWriter(new FileOutputStream("crime.csv"));
            biography = new PrintWriter(new FileOutputStream("biography.csv"));
            horror = new PrintWriter(new FileOutputStream("horror.csv"));
            action = new PrintWriter(new FileOutputStream("action.csv"));
            documentary = new PrintWriter(new FileOutputStream("documentary.csv"));
            fantasy = new PrintWriter(new FileOutputStream("fantasy.csv"));
            mystery = new PrintWriter(new FileOutputStream("mystery.csv"));
            sci_fi = new PrintWriter(new FileOutputStream("sci-fi.csv"));
            family = new PrintWriter(new FileOutputStream("family.csv"));
            romance = new PrintWriter(new FileOutputStream("romance.csv"));
            thriller = new PrintWriter(new FileOutputStream("thriller.csv"));
            western = new PrintWriter(new FileOutputStream("western.csv"));

            part1_manifest = new Scanner(new FileInputStream(manifest));

        }
        catch(FileNotFoundException e) {
            System.out.println("Error creating output files or couldn't be opened");

        }
       while(part1_manifest.hasNext()) {
           String line = part1_manifest.nextLine();
           int lineNumber = 0;
           try {
               Scanner lineScanner = new Scanner(new FileInputStream(line));
               while(lineScanner.hasNext()){
                     String movie = lineScanner.nextLine();
                     lineNumber++;
                     if(checkValidMovie(movie)){
                          String[] parts = CSVUtils.splitByCommas(movie);
                          if(parts[3].equals("Musical")){
                            musical.println(movie);
                          }
                          else if(parts[3].equals("Comedy")){
                            comedy.println(movie);
                          }
                          else if(parts[3].equals("Animation")){
                            animation.println(movie);
                          }
                          else if(parts[3].equals("Adventure")){
                            adventure.println(movie);
                          }
                          else if(parts[3].equals("Drama")){
                            drama.println(movie);
                          }
                          else if(parts[3].equals("Crime")){
                            crime.println(movie);
                          }
                          else if(parts[3].equals("Biography")){
                            biography.println(movie);
                          }
                          else if(parts[3].equals("Horror")){
                            horror.println(movie);
                          }
                          else if(parts[3].equals("Action")){
                            action.println(movie);
                          }
                          else if(parts[3].equals("Documentary")){
                            documentary.println(movie);
                          }
                          else if(parts[3].equals("Fantasy")){
                            fantasy.println(movie);
                          }
                          else if(parts[3].equals("Mystery")){
                            mystery.println(movie);
                          }
                          else if(parts[3].equals("Sci-Fi")){
                            sci_fi.println(movie);
                          }
                          else if(parts[3].equals("Family")){
                            family.println(movie);
                          }
                          else if(parts[3].equals("Romance")){
                            romance.println(movie);
                          }
                          else if(parts[3].equals("Thriller")){
                            thriller.println(movie);
                          }
                          else if(parts[3].equals("Western")){
                            western.println(movie);
                          }
                     }

               }
           } catch (MissingQuotesException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (ExcessFieldsException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (MissingFieldsException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadTitleException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadNameException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadYearException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadDurationException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadGenreException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadRatingException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (BadScoreException e) {
               e.setLineNumber(lineNumber);
               e.setFileName(line);
               badMovie.println(e.toString());
           } catch (FileNotFoundException e) {
               System.out.println("Error: " + e.getMessage());           }
       }
        writeToPart2Manifest(part2_manifest);
        part1_manifest.close();
        badMovie.close();
        part2_manifest.close();
        musical.close();
        comedy.close();
        animation.close();
        adventure.close();
        drama.close();
        crime.close();
        biography.close();
        horror.close();
        action.close();
        documentary.close();
        fantasy.close();
        mystery.close();
        sci_fi.close();
        family.close();
        romance.close();
        thriller.close();
        western.close();
        return "part2_manifest.txt";
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
            throw new MissingQuotesException();
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
            throw new ExcessFieldsException();
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
            throw new MissingFieldsException();
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
            throw new BadTitleException();
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
            throw new BadNameException();
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
            throw new BadYearException();
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
            throw new BadYearException();
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
            throw new BadDurationException();
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
            throw new BadDurationException();
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
            throw new BadGenreException();
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
            throw new BadGenreException();
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
            throw new BadRatingException();
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
            throw new BadRatingException();
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
            throw new BadScoreException();
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
            throw new BadScoreException();
        }
        return false;
    }

    /**
     * Writes to the part2_manifest file
     * @param part2_manifest the file to write to
     */
    public static void writeToPart2Manifest(PrintWriter part2_manifest){
        part2_manifest.println("musical.csv");
        part2_manifest.println("comedy.csv");
        part2_manifest.println("animation.csv");
        part2_manifest.println("adventure.csv");
        part2_manifest.println("drama.csv");
        part2_manifest.println("crime.csv");
        part2_manifest.println("biography.csv");
        part2_manifest.println("horror.csv");
        part2_manifest.println("action.csv");
        part2_manifest.println("documentary.csv");
        part2_manifest.println("fantasy.csv");
        part2_manifest.println("mystery.csv");
        part2_manifest.println("sci-fi.csv");
        part2_manifest.println("family.csv");
        part2_manifest.println("romance.csv");
        part2_manifest.println("thriller.csv");
        part2_manifest.println("western.csv");
    }
}
