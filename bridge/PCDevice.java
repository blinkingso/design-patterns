package bridge;

public class PCDevice extends AbstractDevice {
    public PCDevice(ITransfer transfer) {
        super(transfer);
    }


    @Override
    public void transferData(byte[] data) {
        System.out.println("pc端传输数据准备");
        transfer.transfer(data);
        System.out.println("pc端数据传输完成");
    }
}
