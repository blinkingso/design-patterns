package bridge;

public class WiFiTransfer implements ITransfer {
    @Override
    public void transfer(byte[] data) {
        System.out.println("模拟通过为WIFI进行数据传输，数据长度为: " + data.length);
    }
}
