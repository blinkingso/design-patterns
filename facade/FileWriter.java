package facade;

import java.io.File;
import java.io.FileOutputStream;

public class FileWriter {

    public boolean write(String dest, byte[] data) {
        File file = new File(dest);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
            fos.flush();
            System.out.println("成功写入文件: " + dest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
