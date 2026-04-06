package ReadWriteIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadHereWriteThere {
    public static void main(String[] args) {
        readWriteFile();
    }

    private static void readWriteFile() {
        Path readPath = Paths.get("src/ReadWriteIO/read.txt");
        Path writePath = Paths.get("src/ReadWriteIO/write.txt");
        try(BufferedReader reader = Files.newBufferedReader(readPath);
            BufferedWriter writer = Files.newBufferedWriter(writePath, StandardOpenOption.TRUNCATE_EXISTING)){
            String line;
            //variable for numbering lines
            int num=1;
            //counter for total number of lines
            int count=0;
            while((line = reader.readLine()) != null){
                if(!line.isBlank()) {
                    writer.write(num + ":" + line.toUpperCase());
                    num++;
                    count++;
                    writer.newLine();
                }
            }
            writer.write("There are a total of "+count+" lines");
        } catch (IOException e) {
            System.out.println("Specified file not found "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
