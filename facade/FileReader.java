package facade;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    public byte[] readAll(String src) {
        System.out.println("准备读取文件: " + src);
        File file = new File(src);
        try (FileInputStream fis = new FileInputStream(file);) {
            byte[] bytes = fis.readAllBytes();
            System.out.println("文件读取结束： " + src);
            return bytes;
        } catch (Exception e) {
            System.out.println("文件读取失败: " + src);
            return new byte[0];
        }
    }
}
