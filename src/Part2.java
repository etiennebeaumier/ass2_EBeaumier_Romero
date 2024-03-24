import Exceptions.ExcessFieldsException;
import Exceptions.MissingFieldsException;
import Exceptions.MissingQuotesException;

import java.io.*;
import java.util.Scanner;

public class Part2 {
    public static String do_part2(String manifestFile) {
        clearManifest("part3_manifest.txt");
        try (Scanner reader = new Scanner(new FileReader(manifestFile))){
        String genreFile;
        while (reader.hasNextLine()){
            genreFile=reader.nextLine();
            processGenreFile(genreFile);
        }
        }
        catch (IOException e) {
            System.out.println("Error reading the file: "+ e.getMessage());
        }
        return "part3_manifest.txt";
    }
    private static void clearManifest(String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            // Opening a PrintWriter with just the filename (without 'true' for append mode)
            // will clear the file without writing anything to it.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String processGenreFile(String genreFile) {
        try {
            int recordCount = countRecords(genreFile);
            Movie[] movies = new Movie[recordCount];

            try (Scanner reader = new Scanner(new FileReader(genreFile))) {
                String line;
                int index = 0;
                while (reader.hasNextLine() && index < movies.length) {
                    line=reader.nextLine();
                    movies[index++] = parseMovie(line);
                }
            }

            // Generate the binary file name by replacing the CSV extension with .ser
            String binaryFileName = genreFile.replace(".csv", ".ser");
            // Serialize the movies array
            try (FileOutputStream manifestSerialized = new FileOutputStream(binaryFileName);
                 ObjectOutputStream out = new ObjectOutputStream(manifestSerialized)) {
                out.writeObject(movies);
            }
            // Now append the binary file name to part3_manifest.txt
            try (PrintWriter manifestWriter = new PrintWriter(new FileWriter("part3_manifest.txt", true))) {
                manifestWriter.println(binaryFileName);
            }
        } catch (IOException | MissingFieldsException | ExcessFieldsException | MissingQuotesException e) {
            e.printStackTrace();
        }
        return "part3_manifest.txt";
    }



    private static int countRecords(String fileName) throws IOException {
        int lines = 0;
        Scanner reader = new Scanner(new FileReader(fileName));
        while (reader.hasNextLine()) {
            reader.nextLine(); // This line consumes the next line of the input
            lines++;
        }
        reader.close(); // Always close resources when you're done with them
        return lines;
    }

   private static Movie parseMovie(String csvFile) throws MissingFieldsException, ExcessFieldsException, MissingQuotesException {
        String csvLine=CSVUtils.removeCommasInsideQuotes(csvFile);
       String[] parts = csvLine.split(",");
        Movie movie=new Movie(Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2]),
                parts[3], parts[4],
                Double.parseDouble(parts[5]),
                parts[6],
                parts[7],
                parts[8],
                parts[9]);
        return movie;
   }
}