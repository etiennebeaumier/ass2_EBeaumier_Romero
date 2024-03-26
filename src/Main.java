import java.util.Scanner;

/**
 * This is the main class for a movie management program that allows users to navigate
 * through different genres and movies serialized in binary files.
 */
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
