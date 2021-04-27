package Clases.LecuraDeArchivos;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;

import static java.sql.DriverManager.println;

public class CountingVocals {

    private static final String FILE_NAME = "input.txt";
    private static final String VOCALS = "aeiou";

    public void runAdvanced() {
        FileReader input = null;
        try {
            CharCounter counters = new CharCounter (VOCALS, false);
            input = new FileReader (FILE_NAME);
            int c;
            while ((c = input.read ( )) != -1) {
                counters.countIfTargeted ((char) c);
            }
            System.out.println (counters);
        } catch (FileNotFoundException ex) {
            println ("Problems	opening " + FILE_NAME);
        } catch (IOException ex) {
            println ("Problems	reading " + FILE_NAME);
        } finally {
            try {
                input.close ( );
            } catch (IOException ex) {
                println ("Problems	closing " + FILE_NAME);
            }
        }
    }
}
