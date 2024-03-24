import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String part1_manifest = "resources/part1_manifest.txt";
        String part2_manifest = Part1.do_part1(part1_manifest);
        String part3_manifest = Part2.do_part2(part2_manifest);
        Movie[][]allMovies=Part3.do_part3(part3_manifest);

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
        System.out.println("The creators of this program, Étienne and Romero, welcome you!");

        Scanner keyboard=new Scanner(System.in);
        int movieGenreIndex=0;
        String optionSelected;
      do{
          System.out.println("----------------------------");
          System.out.println("Main Menu");
          System.out.println("----------------------------");
          System.out.println("s: Select a movie array to navigate");
          System.out.println("n: Navigate "+  genres[movieGenreIndex] +" movies (" +allMovies[movieGenreIndex].length+" records)");
          System.out.println("x: Exit");
          System.out.println("----------------------------");
          System.out.print("Enter Your Choice: ");

          optionSelected=keyboard.nextLine();

          switch (optionSelected.toLowerCase()){
              case "s":
                  displaylist(genres,allMovies);
                  movieGenreIndex= keyboard.nextInt()-1;
                  System.out.println();
                  break;
              case "n":
                  System.out.println("Navigating "+genres[movieGenreIndex]+
                          " movies "+ allMovies[movieGenreIndex].length);
                  int currenPosition=0;
                  Part3.navigateMovieArray(allMovies[movieGenreIndex],currenPosition);
                  System.out.println();
                  break;
              case "x":
                  System.out.println("Thank You for Using our program :)");
                  break;

              default: {
                  System.out.println("There is no action associated to the choice you made");
                  System.out.println("Please, Try again");
                  System.out.println();
                  System.out.println();
              }


          }


          } while (!optionSelected.equals("x"));

      }

    private static void displaylist(String[] genres, Movie[][]allMovies) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Genre Sub-Menu");
        System.out.println("------------------------------");
        for(int i=0;i<genres.length;i++){
            System.out.printf("%-3d%-15s%5d records%n", (i + 1), genres[i], allMovies[i].length);
        }

        System.out.println("------------------------------");
        System.out.println("Enter your choice");
    }
}
