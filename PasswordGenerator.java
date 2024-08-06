import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);
        
        scanner.close();
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterSet = new StringBuilder();
        
        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        
        if (includeLowercase) {
            characterSet.append(LOWERCASE);
        }
        
        if (includeDigits) {
            characterSet.append(DIGITS);
        }
        
        if (includeSpecial) {
            characterSet.append(SPECIAL_CHARACTERS);
        }
        
        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be included");
        }
        
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        
        return password.toString();
    }
}
