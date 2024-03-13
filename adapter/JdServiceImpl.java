package adapter;

public class JdServiceImpl implements AdapterService {
    public JdResponse occupyJd() {
        return new JdResponse();
    }

    @Override
    public TicketResponse occupy() {
        return AdapterResponse.resolve(this.occupyJd());
    }
}
