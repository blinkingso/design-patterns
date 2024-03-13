package bridge;

public abstract class AbstractDevice {
    protected ITransfer transfer;

    public AbstractDevice(ITransfer transfer) {
        this.transfer = transfer;
    }


    public abstract void transferData(byte[] data);
}
