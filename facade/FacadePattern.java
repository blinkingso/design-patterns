package facade;

/**
 * 门面模式： 将多个单一职责的服务聚合到一起，完成一个完成的服务并暴露给客户端。
 * 比如: 对一个文件进行加密处理包含了文件读取， 加密以及文件写入三个步骤。
 * 对功能进行抽象剥离在聚合。
 */
public class FacadePattern {
    public static void main(String[] args) throws Exception {
        new DefaultEncryptFacadeImpl().encryptFile("facade/text.origin", "dest.origin.1");
        System.out.println("=========================================");
        new NewEncryptFacadeImpl().encryptFile("facade/text.origin", "dest.origin.2");
    }
}
