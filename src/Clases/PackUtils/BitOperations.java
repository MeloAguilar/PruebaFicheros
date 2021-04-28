package Clases.PackUtils;

public class BitOperations {

    /**
     * Método que pasa un entero a un byte mostrando los 32 bits internos del entero
     * El método recorre
     * @param num
     * @return
     */
    private static String intToBinaryString(int num){
        /**
         * Ya existe una clase en Jaa que contiene un método para pasar un entero a binario
         * pero crearé esta para aprender mejor el manejo de los bytes.
         */

        String binary = "";
        for(int i = 0; i < 32; i++){
            if(num >= 0){
                binary += "0";
            } else {
                binary += "1";
            }
            num = num << 1;
        }
        return binary;
    }

    private void printIntExpression(String expr, int value){
        System.out.println (expr + this.intToBinaryString (value) + " -->  " + String.valueOf (value) );
    }

    public void run(){
        int a = 84;
        int b = -29;
        System.out.println ("Operaciones usando Enteros" );
        printIntExpression ("      a = ", a);
        printIntExpression ("\n      b = ", b);
        printIntExpression ("\n     ~a = ", ~a);
        printIntExpression ("\n     ~b = ",	~b);
        printIntExpression ("\n    a&b = ",	a&b);
        printIntExpression ("\n    a|b = ",	a|b);
        printIntExpression ("\n    a^b = ",	a^b);
        printIntExpression ("\n   a<<1 = ",	a<<1);
        printIntExpression ("\n   a>>1 = ",	a>>1);
        printIntExpression ("\n  a>>>1 = ",	a>>>1);
        printIntExpression ("\n   b<<1 = ",	b<<1);
        printIntExpression ("\n   b>>1 = ",	b>>1);
        printIntExpression ("\n  b>>>1 = ",	b>>>1);

        System.out.println (toByteArray (a));
        byte[] bytes = new byte[4];

    }


    /**
     * Método que transforma un entero en un array de bytes
     * Para hacer que todos los bits estén lo más a la derecha posible se desplazan
     * los de la primera posicion del array 24, ya que puede que no necesitemos los 32 bits al completo,
     * luego desplazamos los bits en segunda posición del array 16 posiciones a la derecha y la tercera
     * posición del array 8 posiciones(Habiendo casteado en todos los casos num a byte).
     * La cuarta posición será ocupada por num casteado a byte
     * @param num
     * @return
     */
    private static byte[] toByteArray(int num){
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (num >> 24);
        bytes[1] = (byte) (num >> 16);
        bytes[2] = (byte) (num >> 8);
        bytes[3] = (byte) (num);
        return bytes;
    }

    private static int toInteger(byte[] bytes) {
        int n = bytes[0] << 24;
        n |= (bytes[1] & 0xFF) << 16;
        n |= (bytes[2] & 0xFF) << 8;
        n |= (bytes[3] & 0xFF);
        return n;
    }
}
