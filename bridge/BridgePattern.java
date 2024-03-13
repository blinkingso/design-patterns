package bridge;

import bridge.pay.*;

import java.math.BigDecimal;

/**
 * 桥接模式： 通过将抽象部分和实现部分分离，将多种可匹配的使用进行组合。
 * 核心实现： A类中含有B类的接口，通过构造函数传递B类。这个类B就是设计的桥。
 * 比如手机可以通过蓝牙WIFI等进行文件传输，抽象出来的传输接口就是桥。
 * 可以过滤部分if...else语句
 */
public class BridgePattern {
    public static void main(String[] args) {
        byte[] data = new byte[]{1, 2, 3};
        new PCDevice(new BluetoothTransfer()).transferData(data);
        new PCDevice(new WiFiTransfer()).transferData(data);
        new PhoneDevice(new WiFiTransfer()).transferData(data);
        new PhoneDevice(new BluetoothTransfer()).transferData(data);

        System.out.println("===================");
        new WxPayService(new FaceMode()).pay("uid0123", new BigDecimal("10.0"));
        new WxPayService(new PasswordMode("pass")).pay("uid0123", new BigDecimal("20.0"));
        new AliPayService(new FingerMode(1, "admin")).pay("uid1234", new BigDecimal("30.0"));
    }
}
