package facade;

import java.io.File;

public class DefaultEncryptFacadeImpl extends AbstractEncryptFacade {
    private final FileReader fr;
    private final FileWriter fw;
    private final EncryptEngine encryptEngine;

    public DefaultEncryptFacadeImpl() {
        this.fr = new FileReader();
        this.fw = new FileWriter();
        this.encryptEngine = new NewEncryptEngine();
    }

    @Override
    public void encryptFile(String src, String dest) throws Exception {
        byte[] originData = fr.readAll(src);
        byte[] result = encryptEngine.encrypt(originData, "testkey");
        boolean status = fw.write(dest, result);
        System.out.println("File write final status: " + status);
    }
}
