package main.java.hexa;

import java.util.HashMap;
import java.util.Map;

public class HexUtil {


    /** table to convert a nibble to a hex char. */
    static char[] hexChar =
            {
                    '0', '1', '2', '3',
                    '4', '5', '6', '7',
                    '8', '9', 'a', 'b',
                    'c', 'd', 'e', 'f'}
            ;


    public static byte[] fromHexString(String theHexString) {

        int stringLength = theHexString.length();
        if ((stringLength & 0x1) != 0) {
            throw new IllegalArgumentException("fromHexString requires an even number of hex characters");
        }

        byte[] b = new byte[stringLength / 2];

        for (int i = 0, j = 0; i < stringLength; i += 2, j++) {
            int high = charToNibble(theHexString.charAt(i));
            int low = charToNibble(theHexString.charAt(i + 1));
            b[j] = (byte) ((high << 4) | low);
        }

        return b;
    }

    /**
     * convert a single char to corresponding nibble.
     *
     * @param c char to convert. must be 0-9 a-f A-F, no
     *          spaces, plus or minus signs.
     * @return corresponding integer
     */
    private static int charToNibble(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('a' <= c && c <= 'f') {
            return c - 'a' + 0xa;
        } else if ('A' <= c && c <= 'F') {
            return c - 'A' + 0xa;
        } else {
            throw new IllegalArgumentException("Invalid hex character: " + c);
        }
    }

    /**
     * Converts a char to hex.
     * E.g.:
     * - 'a' is converted to "0061"
     * - '#' is converted to "20ac"
     *
     * @param theChar The unicode char
     * @return The hex for char (4 chars)
     */
    public static String charToHexString(char theChar) {
        StringBuffer aString = new StringBuffer();

        aString.append(hexChar[(theChar & 0xf000) >> 12]);
        aString.append(hexChar[(theChar & 0x0f00) >> 8]);
        aString.append(hexChar[(theChar & 0x00f0) >> 4]);
        aString.append(hexChar[(theChar & 0x000f)]);

        return aString.toString();
    }


    /**
     * @see HexUtil#toHexString(byte[])
     *
     * @param theByteArray The bytea array to convert
     * @param theSize
     * @return The HEX string.
     */
    public static String toHexString(byte[] theByteArray, int theSize) {

        if (theByteArray == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer(theSize * 2);
        for (int i = 0; i < theSize; i++) {
            // look up high nibble char
            sb.append(hexChar[(theByteArray[i] & 0xf0) >>> 4]);

            // look up low nibble char
            sb.append(hexChar[theByteArray[i] & 0x0f]);
        }
        return sb.toString();
    }

    /////////////////////////////////////////////////////////////////////////////////

    static final Map<String , String> theANSItoIA5ExtendedMap = new HashMap<String , String>() {{



        put("\u00E8","04");
        put("\u00E9","05");
        put("\u00EA","65");
        put("\u00EC","07");
        put("\u00EC","07");
        put("\u00ED","69");
        put("\u00F1","7D");
        put("\u00F2","08");
        put("\u00F3","6F");
        put("\u00F6","7C");
        put("\u00F8","0C");
        put("\u00F9","06");
        put("\u00FA","75");
        put("\u00FC","7E");
        put("\u00FD","79");
        put("\u00BF","60");
        put("\u00C4","5B");
        put("\u00C5","0E");
        put("\u00C6","1C");
        put("\u00C7","09");
        put("\u00C9","1F");
        put("\u00D1","5D");
        put("\u00D6","5C");
        put("\u00D8","0B");
        put("\u00DC","5E");
        put("\u00DD","59");
        put("\u00E0","1F");
        put("\u00E4","7B");
        put("\u00E5","0F");
        put("\u00E6","1D");
        put("\u00AE","72");
        put("\u00A9","63");
        put("\u00A7","5F");
        put("\u00A5","03");
        put("\u00A4","24");
        put("\u00A3","01");
        put("\u00A1","40");
        put("~","3D");
        put("{","28");
        put("}","29");
        put("\u00A1","40");

       /* put("è", "04");
        put("é", "05");
        put("ê", "65");
        put("ì", "07");
        put("ì", "07");
        put("í", "69");
        put("ñ", "7D");
        put("ò", "08");
        put("ó", "6F");
        put("ö", "7C");
        put("ø", "0C");
        put("ù", "06");
        put("ú", "75");
        put("ü", "7E");
        put("ý", "79");
        put("¿", "60");
        put("Ä", "5B");
        put("Å", "0E");
        put("Æ", "1C");
        put("Ç", "09");
        put("É", "1F");
        put("Ñ", "5D");
        put("Ö", "5C");
        put("Ø", "0B");
        put("Ü", "5E");
        put("Ý", "59");
        put("à", "1F");
        put("ä", "7B");
        put("å", "0F");
        put("æ", "1D");
        put("®", "72");
        put("©", "63");
        put("§", "5F");
        put("¥", "03");
        put("€", "24");
        put("£", "01");
        put("¡", "40");
        put("~", "3D");
        put("{", "28");
        put("}", "29");
        put("¡", "40");*/

    }};

    /**
     * stringToHexa   ---------- Adapter
     * convert string to char
     * @param text
     * @param isUnicode
     * @return
     */
    public static String stringToHexa(String text , boolean isUnicode) {

        int c;//int's equivalent to char
        String hexChar;

        StringBuffer buff = new StringBuffer(text.length());
        for (int i = 0; i < text.length(); i++) {
            c=text.charAt(i);
            String theChar = Character.toString(text.charAt(i));
            if (isUnicode) {
                buff.append(HexUtil.charToHexString((char) c));
            } else {


                //  GSM code
                if (theANSItoIA5ExtendedMap.containsKey(theChar)){
                    hexChar = theANSItoIA5ExtendedMap.get(theChar);

                // UTF-8 code
                } else {
                    hexChar = Integer.toHexString(c);

                    //hexChar = String.format("%02x", c);
                }

                buff.append(hexChar);
            }

        }
        return buff.toString().toUpperCase();
    }
}
