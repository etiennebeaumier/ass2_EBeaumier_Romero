import java.io.*;
import java.util.Scanner;

public class Part3 {
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
    public static Movie[] deserializeMovie(String MovieGenreBinaryFile) {

        Movie[] oneMovieGenre = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(MovieGenreBinaryFile))) {
            oneMovieGenre = (Movie[]) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return oneMovieGenre;
    }
    public static void navigateMovieArray(Movie[] movies, int currentPosition) {
        Scanner scanner = new Scanner(System.in);

        if (movies.length == 0) {
            System.out.println("There are no movie records for this genre");
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("----------------------------");
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

            if (n == 0) {
                break; // Exit the navigation session
            }

            if (n < 0) {
                int recordsToDisplay = Math.abs(n) - 1;
                int newCurrentPosition = Math.max(0, currentPosition - recordsToDisplay);
                for (int i = currentPosition - 1; i >= newCurrentPosition; i--) {
                    System.out.println("Movie " + (i+1) + ": " + movies[i].toString());
                }
                currentPosition = newCurrentPosition;
                System.out.println("BOF reached.");
                System.out.println();
            } else {
                int recordsToDisplay = Math.abs(n) - 1;
                int newCurrentPosition = Math.min(movies.length - 1, currentPosition + recordsToDisplay);
                for (int i = currentPosition + 1; i <= newCurrentPosition; i++) {
                    System.out.println("Movie " + i + ": " + movies[i].toString());
                }
                currentPosition = newCurrentPosition;
                System.out.println("EOF reached.");
                System.out.println();
            }
        }

        System.out.println("Viewing session ended. Returning to main menu.");
        // Don't close the scanner if you're using it elsewhere in your program.
    }

}
