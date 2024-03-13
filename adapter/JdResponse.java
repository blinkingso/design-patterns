package adapter;

import java.io.Serializable;
import java.util.Date;

public class JdResponse implements Serializable {
    private String jdTicketNo;
    private String jdOccupyStatus;
    private String userNo;
    private String name;
    private String occupySeatNo;
    private Date successDatetime;

    public String getJdTicketNo() {
        return jdTicketNo;
    }

    public void setJdTicketNo(String jdTicketNo) {
        this.jdTicketNo = jdTicketNo;
    }

    public String getJdOccupyStatus() {
        return jdOccupyStatus;
    }

    public void setJdOccupyStatus(String jdOccupyStatus) {
        this.jdOccupyStatus = jdOccupyStatus;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupySeatNo() {
        return occupySeatNo;
    }

    public void setOccupySeatNo(String occupySeatNo) {
        this.occupySeatNo = occupySeatNo;
    }

    public Date getSuccessDatetime() {
        return successDatetime;
    }

    public void setSuccessDatetime(Date successDatetime) {
        this.successDatetime = successDatetime;
    }
}
