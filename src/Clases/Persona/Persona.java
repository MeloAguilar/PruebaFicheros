package Clases.Persona;

import Clases.PackUtils.PackUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private long identificador;
    private int edad;
    private boolean mayorEdad;
    private static final int NAME_LIMIT = 20;
    public static final int SIZE = 8 + 2 * NAME_LIMIT + 4 + 1;


    public Persona(String nombre,
                   long identificador,
                   int edad) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.edad = edad;
        mayorEdad = edad >= 18;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public byte[] toBytes(){
        byte[] personaEnBytes = new byte[SIZE];
        int offset = 0;
        PackUtils.packLong (identificador,personaEnBytes,offset);
        offset += 8;
        PackUtils.packPequenioStrng (nombre, NAME_LIMIT, personaEnBytes,offset);
        offset += 2*NAME_LIMIT;
        PackUtils.packInt (edad,personaEnBytes,offset);
        offset += 4;
        PackUtils.packBoolean (mayorEdad, personaEnBytes, offset);
        return personaEnBytes;
    }

    public static Persona fromBytes(byte[] personaEnBytes){
        int offset = 0;
        long identificador = PackUtils.unpackLong (personaEnBytes, offset);
        offset += 8;
        String nombre = PackUtils.unpackPequenioString (NAME_LIMIT,personaEnBytes, offset);
        offset += 2 * NAME_LIMIT;
        int edad = PackUtils.unpackInt (personaEnBytes, offset);
        return new Persona (nombre, identificador,edad);
    }



    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + identificador + '\'' +
                ", edad=" + edad +
                '}';
    }
}
