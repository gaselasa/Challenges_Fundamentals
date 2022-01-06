import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NamesValidator {
    // simple regex
    //private static final String USERNAME_PATTERN = "^[a-z0-9\\._-]{5,20}$";

    // strict regex
    private static final String USERNAME_PATTERN =
            "^[a-zA-Z]([._-](?![._-])|[a-zA-Z]){3,18}[a-zA-Z]$";

    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    public static boolean isValid(final String username)
    {
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    static Stream<String> invalidNamesProvider()
    {
        return Stream.of(
                "abc  // invalid length 3, length must between 5-20",
                "01234567890123456789a  // invalid length 21, length must between 5-20 and numbers",
                "_javaregex_  // invalid start and last character",
                ".javaregex.  // invalid start and last character",
                "-javaregex-  // invalid start and last character",
                "javaregex#$%@123  // invalid symbols, support dot, hyphen and underscore*/",
                "java..regex  // dot cant appear consecutively",
                "java--regex  // hyphen can't appear consecutively",
                "java__regex  // underscore can't appear consecutively",
                "java._regex   // dot and underscore can't appear consecutively",
                "java.-regex  // dot and hyphen can't appear consecutively",
                "________",
                "   // empty",
                "");
    }


}
