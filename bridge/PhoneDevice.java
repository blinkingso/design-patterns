package bridge;

public class PhoneDevice extends AbstractDevice {
    public PhoneDevice(ITransfer transfer) {
        super(transfer);
    }

    @Override
    public void transferData(byte[] data) {
        System.out.println("手机端-》 开始传输数据");
        transfer.transfer(data);
        System.out.println("手机端-》数据传输结束");
    }
}
