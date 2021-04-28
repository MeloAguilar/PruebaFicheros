package Main;

import Clases.EscrituraDeArchivos.BackwardsWriter;
import Clases.LecuraDeArchivos.CountingVocals;
import Clases.EscrituraYLecturaDeUnArchivoAOtro.HowlerMaker;
import Clases.PackUtils.BitOperations;
import Clases.Persona.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        /**
        //Lectura de ficheros o archivos
        CountingVocals n = new CountingVocals ();
        n.runAdvanced ();
        //Escritura de ficheros o archivos

        BackwardsWriter bb = new BackwardsWriter ();
        bb.run ();
        //Lectura de archivo y escritura de el mismo pero en mayusculas en otro archivo
        HowlerMaker bi = new HowlerMaker ();
        bi.run ();
         BitOperations bibi = new BitOperations ();
         bibi.run ();

         */

        Persona pepe = new Persona ("Pepe",  12413, 34);
        byte[] personaEnpaquetada = pepe.toBytes ();
        System.out.println (pepe = Persona.fromBytes (personaEnpaquetada) );
    }
}
