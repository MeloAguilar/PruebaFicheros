package Clases.EscrituraDeArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BackwardsWriter {

    private static String FILE_NAME = "backwards.txt";
    private static Scanner sc = new Scanner (System.in);

    public void run() {
        try {
            String text = ("Enter	a	text:	");
            System.out.println (text );
            String here = sc.nextLine ();
            FileWriter output = new FileWriter (FILE_NAME);
            for (int i = here.length ( ) - 1; i >= 0; i--) {
                output.write (here.charAt (i));
            }
            output.close ( );
        } catch (IOException ex) {
            System.out.println ("Something	bad	has	happended	:-(");
        }
    }
}
