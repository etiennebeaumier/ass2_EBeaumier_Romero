import java.io.*;
import java.util.Scanner;

public class Part3 {
    public static Movie[][] do_part3(String part3ManifestFile) {
        Movie[][] allMovies=null;
        int allMoviesSize=0;
        try(Scanner manifestScanner=new Scanner(new FileInputStream(part3ManifestFile))){

            String genrefile;
            while ((manifestScanner.hasNextLine())){
                manifestScanner.nextLine();
                allMoviesSize++;
            }
            allMovies=new Movie[allMoviesSize][];
// Reset the scanner to the beginning of the file
            manifestScanner.reset();

            int genreIndex=0;
            while (manifestScanner.hasNextLine()){
                String MovieGenreBinaryFile=manifestScanner.nextLine();
                allMovies[genreIndex]=deserializeMovie(MovieGenreBinaryFile);
                genreIndex++;
            }

        } catch (Exception e) {
            System.out.println("not yet");
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

    public static void navigateMovie(Movie[][] allMovies){
        Scanner keyboard=new Scanner(System.in);
        int currentGenreIndex=0;
        int currentMovieIndex=0;

        String userChoice=null;
        do{
            System.out.println("----------------------------");
            System.out.println("Main Menu");
            System.out.println("----------------------------");
            System.out.println("s: Select a movie array to navigate");
            System.out.println("n: Navigate " + allMovies[currentGenreIndex][currentMovieIndex].getGenres() + " movies (" + allMovies[currentGenreIndex].length + " records)");
            System.out.println("x: Exit");
            System.out.println("----------------------------");
            System.out.print("Enter Your Choice: ");
            userChoice = keyboard.nextLine();

        switch (userChoice.toLowerCase()){

            case "s":
                currentGenreIndex = selectGenre(keyboard, allMovies);
                currentMovieIndex = 0; // Reset index when genre changes
                break;
            case "n":
                currentMovieIndex = navigateGenre(keyboard, allMovies,currentGenreIndex, currentMovieIndex);
                break;
            case "x":
                System.out.println("Exiting navigation.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;

        }


        } while (!userChoice.equalsIgnoreCase("x"));


    }

    private static int selectGenre(Scanner keyboard, Movie[][] allMovies){
        int genreIndex=0;

        do{
            System.out.println("------------------------------");
            System.out.println("Genre Sub-Menu");
            System.out.println("------------------------------");

            for (int i = 0; i < allMovies.length; i++) {
                System.out.println((i + 1) + ": " + allMovies[i][0].getGenres() + " (" + allMovies[i].length + " movies)");
            }
            System.out.println((allMovies.length + 1) + ": Exit");
            System.out.println("------------------------------");
            System.out.print("Enter Your Choice: ");
            int choice=keyboard.nextInt();

            try{
                genreIndex=choice-1;
                if (genreIndex >= allMovies.length || genreIndex < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + (allMovies.length));
            }
        } while (genreIndex < 0 || genreIndex >= allMovies.length);

        return genreIndex;
    }

    private static int navigateGenre(Scanner keyboard, Movie[][] allMovies, int genreIndex,int currentIndex){
        System.out.println("Navigating " + allMovies[genreIndex][0].getGenres() + " movies (" + allMovies[genreIndex].length + ")");
        System.out.println("Enter your choice: ");
        int newIndex = currentIndex;
        int input=0;
        do {
            System.out.println("Current movie: " + allMovies[genreIndex][currentIndex]);
            System.out.print("Enter number of movies to skip (negative to go back, 0 to exit): ");

            try {
                input = keyboard.nextInt();
                newIndex = currentIndex + input;
                if (newIndex < 0) {
                    newIndex = 0;
                    System.out.println("BOF has been reached.");
                } else if (newIndex >= allMovies[genreIndex].length) {
                    newIndex = allMovies[genreIndex].length - 1;
                    System.out.println("EOF has been reached.");
                } else {
                    // Adjust current index and display movies
                    for (int i = Math.max(0, newIndex - Math.abs(input)); i <= Math.min(allMovies[genreIndex].length - 1, newIndex); i++) {
                        System.out.println("Movie " + (i + 1) + ": " + allMovies[genreIndex][i]);
                    }
                    currentIndex = newIndex; // Update the current index to the new index after navigation
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }while( input!= 0);
        return newIndex;


    }

}
