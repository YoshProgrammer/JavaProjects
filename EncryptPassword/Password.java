/*
    Takes a password, no spaces, and can encrypt/decrypt.
    NIFTY POINTS PERHAPS: I'm using a substitution cipher but I create a new key everytime it's called.
 */

import java.lang.*;
import java.util.*;

public class Password implements Encryptable {

    private String key = "";
    private String message;
    private boolean encrypted;
    private char currentCharacter;

    public Password(String msg) {
        message = msg;
        encrypted = false;
        generateKey();
    }

    private void generateKey() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> alphabetChars = new ArrayList<String>();
        char[] alphabetCharacters = alphabet.toCharArray();
        for (char c: alphabetCharacters) {
            String temp = String.valueOf(c);
            alphabetChars.add(temp);
        }

        Collections.shuffle(alphabetChars);

        for (String alphabetLetter: alphabetChars) {
            key += alphabetLetter;
        }
    }

    public void encrypt() {
        String result = "";
        char encryptedCharacter;
        if (!isEncrypted()) {
            for (int index = 0; index < message.length(); index++) {
                currentCharacter = (char)message.charAt(index);
                if (Character.isLetter(currentCharacter)) {
                    encryptedCharacter = key.charAt(Character.toUpperCase(currentCharacter) - 'A');
                    result += encryptedCharacter;
                }

            }
            message = result;
            encrypted = true;
        } else {
            System.out.println("Already encrypted");
        }

    }

    public String decrypt() {
        String result = "";
        char decryptedCharacter;
        if (isEncrypted()) {
            for (int i = 0; i < message.length(); i++) {
                int index = key.indexOf(message.charAt(i));

                if (index != -1) {
                    decryptedCharacter = (char)('A' + index);
                    result += decryptedCharacter;
                }
            }
            message = result;
            encrypted = false;
        } else {
            System.out.println("Error. Password is not encrypted.");
        }
        return message;

    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public String toString() {
        return message;
    }

}
