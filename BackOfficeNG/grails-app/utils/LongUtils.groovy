/**
 *
 * @author bor
 */
class LongUtils {

    public static stringToLong(String s) {
        try {
            return Long.parseLong(s.trim())
        } catch (NumberFormatException nfe) {
            return null
        }
    }
}
