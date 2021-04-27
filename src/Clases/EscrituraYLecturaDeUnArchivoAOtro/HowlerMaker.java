package Clases.EscrituraYLecturaDeUnArchivoAOtro;

import java.io.*;

public class HowlerMaker {
        private static String MAIL_NAME = "input.txt";
    private static String HOWLER_NAME = "howler.txt";


    private String howlerize(String text) {
        return text.toUpperCase ( );
    }


    public void run() {
        try{
            BufferedReader input = new BufferedReader (new FileReader (MAIL_NAME));
            BufferedWriter output = new BufferedWriter (new FileWriter (HOWLER_NAME));

            String linea = input.readLine ();
            while(linea != null){
                String howledLine = this.howlerize (linea);
                output.write(howledLine, 0, howledLine.length ());
                output.newLine ();
                linea = input.readLine ();
            }
            input.close ();
            output.close ();
        }catch(IOException ex){
            System.out.println ("MAybe	you	know	who	has	come	:-(" );
        }
    }
}
