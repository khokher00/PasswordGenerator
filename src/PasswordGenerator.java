import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
public class PasswordGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+{}:<>?";

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                          boolean includeDigits, boolean includeSpecialCharacters) {
        StringBuilder password = new StringBuilder();
        String allowed = "";
        if (includeUppercase)
            allowed+=ALPHABET.toUpperCase();

        if (includeLowercase)
            allowed+=ALPHABET;
        if (includeDigits)
            allowed+=DIGITS;
        if (includeSpecialCharacters)
            allowed+=SPECIAL_CHARACTERS;
        Random random = new Random();
        for (int i = 0; i < length; i++)
            password.append(allowed.charAt(random.nextInt(allowed.length())));
        return password.toString();
    }
    public static void main(String... args){
        System.out.println(generatePassword(10,true,true,true,true));

        PassGUI gui = new PassGUI();
        gui.setSize(240,320);
        gui.setUndecorated(true);
        gui.setShape(new RoundRectangle2D.Float(0,0,240,320,20,20));
        gui.setTitle("Password Generator by Vivek...");
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}