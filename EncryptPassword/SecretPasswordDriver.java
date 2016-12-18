/*
    Java Driver class demonstrating the encrypt/decrypt methods of the secret and password classes.
    This demonstrates using an interface as each method is different, but since it implements the interface it has
    to implement all the methods specified.

    Testing approach: I ran through several scenarios but you can see an example of one in the third comment block.
    When you run the program, I wanted to verify that the key that is generated each time is working correctly, so
    you can see that password and passwordTwo are the same but the encryption is different.

    Also. I call isEncrypted() within the Password.java class as the boolean flag check to make sure we aren't
    decrypting an unencrypted password and vice versa.
 */


public class SecretPasswordDriver {

    public static void main(String[] args) {
        Encryptable encryptable;

        encryptable = new Secret("BRAND NEW SECRET");

        /* SECRET METHOD TESTING */
        System.out.println("The secret entered is: " + encryptable + "\n");
        encryptable.encrypt();
        System.out.println("The encrypted secret entered is: " + encryptable + "\n");
        encryptable.decrypt();
        System.out.println("The decrypted secret entered is: " + encryptable + "\n");

        /* PASSWORD METHOD TESTING */
        encryptable = new Password("BRANDNEWPASSWORD");
        System.out.println("The password entered is: " + encryptable + "\n");
        encryptable.encrypt();
        System.out.println("The encrypted password is: " + encryptable + "\n");
        encryptable.decrypt();
        System.out.println("The decrypted password is: " + encryptable + "\n");


        /* PASSWORD METHOD TESTING CONT */
        Password passwordTwo = new Password("BRANDNEWPASSWORD");
        System.out.println("The password entered is: " + passwordTwo + "\n");
        passwordTwo.encrypt();
        System.out.println("The encrypted password is: " + passwordTwo + "\n");
        passwordTwo.decrypt();
        System.out.println("The decrypted password is: " + passwordTwo + "\n");
    }
}
