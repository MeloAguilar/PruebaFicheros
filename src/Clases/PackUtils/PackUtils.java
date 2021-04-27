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
}
