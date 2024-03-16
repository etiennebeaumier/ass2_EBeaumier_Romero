import Exceptions.ExcessFieldsException;
import Exceptions.MissingFieldsException;

import java.io.*;
public class Part2 {
    public static void do_part2(String manifestFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(manifestFile))){
        String genreFile;
        while ((genreFile=reader.readLine()) !=null){
            processGenreFile(genreFile);
        }
        }
        catch (IOException e) {
            System.out.println("Error reading the file: "+ e.getMessage());
        }
    }

    public static void processGenreFile(String genreFile) {
        try {
            int recordCount = countRecords(genreFile);
            Movie[] movies = new Movie[recordCount];

            try (BufferedReader reader = new BufferedReader(new FileReader(genreFile))) {
                String line;
                int index = 0;
                while ((line = reader.readLine()) != null && index < movies.length) {
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
            try (BufferedWriter manifestWriter = new BufferedWriter(new FileWriter("part3_manifest.txt", true))) {
                manifestWriter.write(binaryFileName);
                manifestWriter.newLine();
            }
        } catch (IOException | MissingFieldsException | ExcessFieldsException e) {
            e.printStackTrace();
        }
    }


   private static int countRecords(String fileName) throws IOException {
        int lines=0;
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
           while (reader.readLine() != null) lines++;
       return lines;
   }

   private static Movie parseMovie(String csvFile) throws MissingFieldsException, ExcessFieldsException {
        String[] parts=csvFile.split(",");
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