package adapter;

import java.util.Date;

public class TicketResponse {

    private String username;
    private String userCard;
    private String status;
    private String seatNo;
    private Date occupyDateTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Date getOccupyDateTime() {
        return occupyDateTime;
    }

    public void setOccupyDateTime(Date occupyDateTime) {
        this.occupyDateTime = occupyDateTime;
    }
}
