package facade;

public class NewEncryptFacadeImpl extends AbstractEncryptFacade {
    private final FileReader fr;
    private final FileWriter fw;
    private final EncryptEngine encryptEngine;

    public NewEncryptFacadeImpl() {
        this.fr = new FileReader();
        this.fw = new FileWriter();
        this.encryptEngine = new StdEncryptEngine();
    }

    @Override
    public void encryptFile(String src, String dest) throws Exception {
        byte[] data = fr.readAll(src);
        byte[] result = encryptEngine.encrypt(data, "newkey");
        boolean status = fw.write(dest, result);
        System.out.println("write to file status: " + status);
    }
}
