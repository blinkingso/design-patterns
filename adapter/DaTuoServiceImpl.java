package adapter;

public class DaTuoServiceImpl implements AdapterService {
    public DaTuoResponse occupySeat() {
        return new DaTuoResponse();
    }

    @Override
    public TicketResponse occupy() {
        return AdapterResponse.resolve(this.occupySeat());
    }
}
