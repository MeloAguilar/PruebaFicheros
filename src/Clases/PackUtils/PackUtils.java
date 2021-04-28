package Clases.PackUtils;

public class PackUtils {
    public static void packBoolean(boolean b, byte[] buffer, int offset) {
        if (b) {
            buffer[offset] = (byte) 1;
        } else {
            buffer[offset] = (byte) 0;
        }
    }

    public static boolean unpackBoolean(byte[] buffer, int offset) {
        return buffer[offset] == (byte) 1;
    }

    public static void packChar(char c, byte[] buffer, int offset) {
        buffer[offset] = (byte) (0xFF & (c >> 8));
        buffer[offset + 1] = (byte) (0xFF & c);
    }

    public static char unpackChar(byte[] buffer, int offset) {
        return (char) ((buffer[offset] << 8) | (buffer[offset + 1] & 0xFF));
    }

    public static void packPequenioStrng(String texto, int maxLength, byte[] buffer, int offset) {
        for (int i = 0; i < maxLength; i++) {
            if (i < texto.length ( )) {
                packChar (texto.charAt (i), buffer, offset + 2 * i);
            } else {
                packChar ('\0', buffer, offset + 2 * i);
                break;
            }
        }
    }

    public static String unpackPequenioString(int maxLength, byte[] buffer, int offset) {
        String resultado = "";
        for (int i = 0; i < maxLength; i++) {
            char c = unpackChar (buffer, offset + 2 * i);
            if (c != '\0') {
                resultado += c;
            } else {
                break;
            }

        }
        return resultado;
    }


    /**
     * Método que desempaqueta un número entero de manera más sencilla que en
     * la clase BitOperations.
     *
     * @param num
     * @param buffer
     * @param offset
     */
    public static void packInt(int num,
                               byte[] buffer,
                               int offset) {
        buffer[offset] = (byte) (num >> 24);
        buffer[offset + 1] = (byte) (num >> 16);
        buffer[offset + 2] = (byte) (num >> 8);
        buffer[offset + 3] = (byte) (num);
    }

    public static int unpackInt(byte[] buffer, int offset) {
        return ((buffer[offset]) << 24) |
                ((buffer[offset + 1] & 0xFF) << 16) |
                ((buffer[offset + 2] & 0xFF) << 8) |
                ((buffer[offset + 3] & 0xFF));
    }


    public static void packLong(long num,
                                byte[] buffer,
                                int offset) {
        buffer[offset] = (byte) (num >> 56);
        buffer[offset + 1] = (byte) (num >> 48);
        buffer[offset + 2] = (byte) (num >> 40);
        buffer[offset + 3] = (byte) (num >> 32);
        buffer[offset + 4] = (byte) (num >> 24);
        buffer[offset + 5] = (byte) (num >> 12);
        buffer[offset + 6] = (byte) (num >> 8);
        buffer[offset + 7] = (byte) (num);
    }

    public static long unpackLong(byte[] buffer, int offset) {
        return ((long) (buffer[offset]) << 56) |
                ((long) (buffer[offset + 1] & 0xFF) << 48) |
                ((long) (buffer[offset + 2] & 0xFF) << 40) |
                ((long) (buffer[offset + 3] & 0xFF) << 32) |
                ((long) (buffer[offset + 4] & 0xFF) << 24) |
                ((long) (buffer[offset + 5] & 0xFF) << 16) |
                ((long) (buffer[offset + 6] & 0xFF) << 8) |
                ((long) (buffer[offset + 7] & 0xFF));
    }

    public static void packDouble(double num,
                                  byte[] buffer,
                                  int offset) {
        long bits = Double.doubleToRawLongBits (num);
        packLong (bits, buffer, offset);
    }

    public static double unpackDouble(byte[] buffer,
                                      int offset) {
        long bits = unpackLong (buffer, offset);
        return Double.longBitsToDouble (bits);
    }


}
