package facade;

public interface EncryptEngine {
    byte[] encrypt(byte[] src, String key) throws Exception;
}
