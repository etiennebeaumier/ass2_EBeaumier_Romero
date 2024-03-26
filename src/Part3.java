// -----------------------------------------------------
//Assignment 2
//COMP 249
// Written by: Étienne Beaumier, 40211362
//             Romero FAUSTIN,   40234898
// Due date: 2024/03/27
// -----------------------------------------------------

import java.io.*;
import java.util.Scanner;

/**
 * This class is responsible for handling movie navigation and deserialization processes.
 */
public class Part3 {
    /**
     * Deserializes all movies from files listed in the manifest file and populates them into a 2D array.
     *
     * @param part3ManifestFile The manifest file containing the list of binary files for each genre.
     * @return A 2D array of movies, categorized by genre.
     */
    public static Movie[][] do_part3(String part3ManifestFile) {
        Movie[][] allMovies = null;
        int allMoviesSize = 0;
        try (Scanner manifestScanner = new Scanner(new FileInputStream(part3ManifestFile))) {

            String genrefile;
            while ((manifestScanner.hasNextLine())) {
                manifestScanner.nextLine();
                allMoviesSize++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        allMovies = new Movie[allMoviesSize][];

        try (Scanner manifestScanner = new Scanner(new FileInputStream(part3ManifestFile))) {
            int genreIndex = 0;
            while (manifestScanner.hasNextLine()) {
                String MovieGenreBinaryFile = manifestScanner.nextLine();
                allMovies[genreIndex] = deserializeMovie(MovieGenreBinaryFile);
                genreIndex++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allMovies;
    }

    /**
     * Deserializes movies from a single binary file corresponding to a genre.
     *
     * @param movieGenreBinaryFile The binary file containing serialized movies of a specific genre.
     * @return An array of Movie objects for the specified genre.
     */
    public static Movie[] deserializeMovie(String movieGenreBinaryFile) {

        Movie[] oneMovieGenre = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(movieGenreBinaryFile))) {
            oneMovieGenre = (Movie[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return oneMovieGenre;
    }

    /**
     * Provides a console-based navigation for displaying movies based on user input.
     * It allows the user to view movies relative to the current position in the array.
     *
     * @param movies          The array of movies to navigate through.
     * @param currentPosition The current position in the array from which navigation starts.
     */
    public static void navigateMovieArray(Movie[] movies, int currentPosition) {
        Scanner scanner = new Scanner(System.in);

        if (movies.length == 0) {
            System.out.println("There are no movie records for this genre");
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("Current " + movies[currentPosition].toString());
            System.out.println();
            System.out.println("Enter a negative number \"n\" to display |n|-1 movie records above the current movie record displayed");
            System.out.println();
            System.out.println("Enter a positive number \"n\" to display |n|-1 movie records below the current movie record displayed");
            System.out.println();
            System.out.println("Enter 0 to go back to the main menu");
            System.out.println();

            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
// Navigate backward or forward based on user input, or exit on 0
            if (n == 0) {
                break; // Exit the navigation session
            }

            if (n < 0) {
                int recordsToDisplay = Math.abs(n) - 1;
                int newCurrentPosition = Math.max(0, currentPosition - recordsToDisplay);
                for (int i = currentPosition - 1; i >= newCurrentPosition; i--) {
                    System.out.println("Movie " + (i + 1) + ": " + movies[i].toString());
                }
                currentPosition = newCurrentPosition;
                System.out.println();
            } else {
                int recordsToDisplay = Math.abs(n) - 1;
                int newCurrentPosition = Math.min(movies.length - 1, currentPosition + recordsToDisplay);
                for (int i = currentPosition + 1; i <= newCurrentPosition; i++) {
                    System.out.println("Movie " + (i+1) + ": " + movies[i].toString());
                }
                currentPosition = newCurrentPosition;
                System.out.println();
            }
        }

        System.out.println("Viewing session ended. Returning to main menu.");
    }

}
