package facade;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StdEncryptEngine implements EncryptEngine {
    @Override
    public byte[] encrypt(byte[] src, String key) throws Exception {
        final byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        final byte[] result = Arrays.copyOf(src, src.length + keyBytes.length);
        System.arraycopy(keyBytes, 0, result, src.length, keyBytes.length);
        return result;
    }
}
