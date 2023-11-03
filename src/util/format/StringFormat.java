package util.format;

public abstract class StringFormat {
    public static String standardise(String toFormat, int newLength) {
        // If input string fits in required length, pad with spaces
        if (toFormat.length() <= newLength) {
            return String.format("%1$-" + newLength + "s", toFormat);
        }
        // If the string is too long, get a substring and add ellipsis
        else {
            return String.format("%1$-" + newLength + "s", toFormat.substring(0, newLength - 3) + "...");
        }
    }
}
