import Exceptions.ExcessFieldsException;
import Exceptions.MissingFieldsException;
import Exceptions.MissingQuotesException;

import java.io.*;
import java.util.Scanner;

/**
 * Handles the processing of genre files to create serialized movie objects
 * and maintain a manifest file with the names of the serialized files.
 */

public class Part2 {
    /**
     * Clears the existing manifest file and processes each genre file listed in the manifest.
     *
     * @param manifestFile The path to the manifest file listing the genre files.
     * @return The name of the manifest file for the next part of the program.
     */
    public static String do_part2(String manifestFile) {
        clearManifest("part3_manifest.txt");
        try (Scanner reader = new Scanner(new FileReader(manifestFile))) {
            String genreFile;
            while (reader.hasNextLine()) {
                genreFile = reader.nextLine();
                processGenreFile(genreFile);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return "part3_manifest.txt";
    }

    /**
     * Clears the content of a file.
     *
     * @param filename The file to clear.
     */
    private static void clearManifest(String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            // Opening a PrintWriter with just the filename (without 'true' for append mode)
            // will clear the file without writing anything to it.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes an individual genre file: counts records, parses movies, serializes them,
     * and appends the serialized file name to the manifest.
     *
     * @param genreFile The CSV file containing movie records for a specific genre.
     * @return The updated manifest file name.
     */
    public static String processGenreFile(String genreFile) {
        try {
            int recordCount = countRecords(genreFile);
            Movie[] movies = new Movie[recordCount];

            try (Scanner reader = new Scanner(new FileReader(genreFile))) {
                String line;
                int index = 0;
                while (reader.hasNextLine() && index < movies.length) {
                    line = reader.nextLine();
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

    /**
     * Counts the number of records in a CSV file.
     *
     * @param fileName The CSV file to count records in.
     * @return The number of records found.
     * @throws IOException If there's an error reading the file.
     */

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

    /**
     * Parses a CSV line into a Movie object.
     *
     * @param csvFile A string containing a line from a CSV file representing a movie.
     * @return The Movie object parsed from the CSV line.
     * @throws MissingFieldsException If there are not enough fields in the CSV line.
     * @throws ExcessFieldsException  If there are too many fields in the CSV line.
     * @throws MissingQuotesException If there are unbalanced quotes in the CSV line.
     */
    private static Movie parseMovie(String csvFile) throws MissingFieldsException, ExcessFieldsException, MissingQuotesException {
        String csvLine = CSVUtils.removeCommasInsideQuotes(csvFile);
        String[] parts = csvLine.split(",");
        Movie movie = new Movie(Integer.parseInt(parts[0]),
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