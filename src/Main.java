/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
         // -----------------------------------------------------
*/
/**
 * Movie Records Management and Navigation System
 * ==============================================
 *
 * This program is designed for the movie theater archive management. It caters to the needs of
 * Mr. Filmbuff who, during the '90s, collected extensive data on movies which is currently stored
 * in text files by year of release. The goal of the program is to:
 *
 * 1. Partition these records into new genre-based text files, ensuring all records are valid and
 *    categorizing them accordingly.
 * 2. Load arrays of movie records from each genre-based file and serialize them into binary files.
 * 3. Deserialize the binary files into a 2D array of movie records, and provide an interactive
 *    system for Mr. Filmbuff to navigate through these records.
 *
 * The system is robust, equipped to handle syntax and semantic errors in the records, and it
 * provides an interactive navigation menu. With user-friendly prompts, the user can seamlessly
 * browse through the genres and records, viewing details as they wish. This automation of the
 * movie archive system is set to significantly ease the browsing and management of Mr. Filmbuff's
 * extensive movie collection from the 1990s.
 *
 * Features include:
 * - Validation and partitioning of movie data based on genres.
 * - Serialization and deserialization of movie records for persistent storage.
 * - Interactive navigation through the movie records, with the ability to display a range of records
 *   based on user input.
 *
 * The program adheres to the object-oriented programming principles and exception handling to
 * ensure a robust and error-free runtime experience.
 *
 */

import java.util.Scanner;
public class Main {
    /**
     * The entry point of the program. Initializes the application and provides
     * a user interface for navigating movie genres and movies.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        String part1_manifest = "resources/part1_manifest.txt";
        String part2_manifest = Part1.do_part1(part1_manifest);
        String part3_manifest = Part2.do_part2(part2_manifest);
        Movie[][] allMovies = Part3.do_part3(part3_manifest);

        // List of genres available for navigation
        String[] genres = {
                "Musical",
                "Comedy",
                "Animation",
                "Adventure",
                "Drama",
                "Crime",
                "Biography",
                "Horror",
                "Action",
                "Documentary",
                "Fantasy",
                "Mystery",
                "Sci-Fi",
                "Family",
                "Western",
                "Romance",
                "Thriller"
        };
        // Welcome message for users
        System.out.println("The creators of this program, Étienne and Romero, welcome you!");

        Scanner keyboard = new Scanner(System.in);
        int movieGenreIndex = 0;
        String optionSelected;
        // Main loop for user interface
        do {
            System.out.println("----------------------------");
            System.out.println("Main Menu");
            System.out.println("----------------------------");
            System.out.println("s: Select a movie array to navigate");
            System.out.println("n: Navigate " + genres[movieGenreIndex] + " movies (" + allMovies[movieGenreIndex].length + " records)");
            System.out.println("x: Exit");
            System.out.println("----------------------------");
            System.out.print("Enter Your Choice: ");

            optionSelected = keyboard.nextLine();

            // Switch to handle user's choice
            switch (optionSelected.toLowerCase()) {
                case "s":
                    displaylist(genres, allMovies);
                    movieGenreIndex = keyboard.nextInt() - 1;
                    System.out.println();
                    break;
                case "n":
                    System.out.println("Navigating " + genres[movieGenreIndex] +
                            " movies " + allMovies[movieGenreIndex].length);
                    int currenPosition = 0;
                    Part3.navigateMovieArray(allMovies[movieGenreIndex], currenPosition);
                    System.out.println();
                    break;
                case "x":
                    System.out.println("Thank You for Using our program :)");
                    break;

                default:
                    keyboard.nextLine();
                    System.out.println("There is no action associated to the choice you made");
                    System.out.println("Please, Try again");
                    System.out.println();
                    System.out.println();


            }


        } while (!optionSelected.equals("x"));

    }

    /**
     * Displays a list of movie genres along with the number of records available for each.
     *
     * @param genres    The array containing the names of the genres.
     * @param allMovies A 2D array containing movie records, categorized by genre.
     */
    private static void displaylist(String[] genres, Movie[][] allMovies) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Genre Sub-Menu");
        System.out.println("------------------------------");
        for (int i = 0; i < genres.length; i++) {
            System.out.printf("%-3d%-15s%5d records%n", (i + 1), genres[i], allMovies[i].length);
        }

        System.out.println("------------------------------");
        System.out.println("Enter your choice");
    }
}
