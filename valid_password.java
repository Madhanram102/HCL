import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    // Regex enforcing: 8-20 chars, 1 digit, 1 lower, 1 upper, 1 special, no spaces
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(final String password) {
        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("StrongPass1!: " + isValid("StrongPass1!")); // true
        System.out.println("weakpass: " + isValid("weakpass"));         // false
        System.out.println("No Space1!: " + isValid("No Space1!"));     // false
    }
}
