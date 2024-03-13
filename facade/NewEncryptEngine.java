package facade;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class NewEncryptEngine implements EncryptEngine {
    @Override
    public byte[] encrypt(byte[] src, String key) throws Exception {
        System.out.println("source: " + Arrays.toString(src));
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        final byte[] padding = " padding".getBytes(Charset.defaultCharset());
        System.out.println("padding: " + Arrays.toString(padding));
        final byte[] result = Arrays.copyOf(src, src.length + keyBytes.length + padding.length);
        System.arraycopy(keyBytes, 0, result, src.length, keyBytes.length);
        System.arraycopy(padding, 0, result, src.length + keyBytes.length, padding.length);
        System.out.println("result: " + Arrays.toString(result));
        return result;
    }
}
