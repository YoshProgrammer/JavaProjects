/*
    Interface for the Secret and Password objects, which implement the encrypt() & decrypt() methods
 */

public interface Encryptable {
    public void encrypt();
    public String decrypt();
}
