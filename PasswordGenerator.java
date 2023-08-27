


import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Enter  password length: ");
        int length = scn.nextInt();
        if(length <8){
            System.out.println("invalid length");
        }else{

        
        
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
        
        int strength = checkPasswordStrength(password);
        String strengthLabel = getStrengthLabel(strength);
        System.out.println("Password Strength: " + strengthLabel);
        }

    
        
        scn.close();
    }
    
    public static String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        
        return password.toString();
    }
    
    public static int checkPasswordStrength(String password) {
        int length = password.length();
        int strength = 0;
        
        if (length >= 8) {
            strength++;
        }
        
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        
        if (password.matches(".*\\d.*")) {
            strength++;
        }
        
        if (password.matches(".*[!@#$%^&*()-_=+].*")) {
            strength++;
        }
        
        return strength;
    }
    
    public static String getStrengthLabel(int strength) {
        switch (strength) {
            case 1:
                return "Weak";
            case 2:
                return "Moderate";
            case 3:
                return "Strong";
            case 4:
                return "Very Strong";
            case 5:
                return "Extremely Strong";
            default:
                return "Unknown";
        }
    }
}




        