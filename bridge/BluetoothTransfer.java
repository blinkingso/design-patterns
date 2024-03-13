package bridge;

public class BluetoothTransfer implements ITransfer {
    @Override
    public void transfer(byte[] data) {
        System.out.println("模拟蓝牙传输数据， 数据长度: " + data.length);
    }
}
