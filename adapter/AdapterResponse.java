package adapter;

import java.util.Date;

public class AdapterResponse {

    public static TicketResponse resolve(DaTuoResponse daTuoResponse) {
        final TicketResponse response = new TicketResponse();
        response.setOccupyDateTime(new Date());
        response.setStatus(daTuoResponse.getOrderStatus());
        response.setSeatNo(daTuoResponse.getSeatNo());
        response.setUsername(daTuoResponse.getUserName());
        response.setUserCard(daTuoResponse.getUserCard());
        return response;

    }

    public static TicketResponse resolve(JdResponse jdResponse) {
        final TicketResponse response = new TicketResponse();
        response.setUserCard(jdResponse.getUserNo());
        response.setUsername(jdResponse.getName());
        response.setStatus(jdResponse.getJdOccupyStatus());
        response.setSeatNo(jdResponse.getOccupySeatNo());
        response.setOccupyDateTime(jdResponse.getSuccessDatetime());
        return response;
    }
}
