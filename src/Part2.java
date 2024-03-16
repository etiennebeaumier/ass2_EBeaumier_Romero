import java.io.*;
public class Part2 {
    public static void do_part2(String manifestFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(manifestFile));
        String genreFile;
        while ((genreFile=reader.readLine()) !=null){
            processGenreFile(genreFile);
        }
        }
        catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }

 public static void processGenreFile(String genreFile) throws IOException {
        int recordCount=countRecords(genreFile);
        Movie [] movies=new Movie[recordCount];

        try (BufferedReader reader=new BufferedReader(new FileReader(genreFile))){
            String line;
            int index=0;
            while ((line=reader.readLine())!=null){
                movies[index]=parseMovie(line);

            }

            // Serialize the movies array to a binary file
            FileOutputStream manifestSerrialized=new FileOutputStream(genreFile.replace(".csv", ".ser"));
            ObjectOutputStream out=new ObjectOutputStream(manifestSerrialized);
     }
     catch (IOException e){
            e.printStackTrace();
     }

    }

   private static int countRecords(String fileName) throws IOException {
        int lines=0;
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
           while (reader.readLine() != null) lines++;
       return lines;
   }

   private static Movie parseMovie(String csvFile){
        String[] parts=csvFile.split(",");
        Movie movie=new Movie(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]),parts[3], parts[4], Double.parseDouble(parts[5]),parts[6], parts[7], parts[8],parts[9]);
        return movie;
   }
}