/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author User
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class EmailValidator {

    private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static Stream<String> invalidEmailFormat() {
        return Stream.of(
                // this regex doesn't support unicode
                "hello    // email need at least one @ ",
                "hello@2020@example.com  // email doesn't allow more than one @",
                ".hello@example.com  // local-part can't start with a dot .",
                "hello.@example.com  // local-part can't end with a dot .",
                "hello..world@example.com  // local part don't allow dot . appear consecutively",
                "hello!+2020@example.com  // local-part don't allow special characters like !+",
                "hello@example.a  // domain tld min 2 chars",
                "hello@example..com  // domain doesn't allow dot . appear consecutively",
                "hello@.com  // domain doesn't start with a dot .",
                "hello@.com.  // domain doesn't end with a dot .",
                "hello@-example.com    // domain doesn't allow to start with a hyphen -",
                "hello@example.com-   // domain doesn't allow to end with a hyphen -",
                "hello@example_example.com  // domain doesn't allow underscore",
                "1234567890123456789012345678901234567890123456789012345678901234xx@example.com  // local part is longer than 64 characters");
    }


}
