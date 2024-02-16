package Orders;

import MainPackage.Utility;

public class Order {
    protected String  orderType;
    protected String  clientPhoneNumber;
    protected String  clientAddress;
    protected String  clientLocationLink;
    protected String  orderEmployeeId;
    protected String  missionEmployeeId;
    protected boolean status;

    public Order(
            String clientPhoneNumber,
            String clientAddress,
            String clientLocationLink,
            String orderEmployeeId,
            String missionEmployeeId
    ) {
        this.clientPhoneNumber  = clientPhoneNumber;
        this.clientAddress      = clientAddress;
        this.clientLocationLink = clientLocationLink;
        this.orderEmployeeId    = orderEmployeeId;
        this.missionEmployeeId  = missionEmployeeId;
        status = false;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientLocationLink(String clientLocationLink) {
        this.clientLocationLink = clientLocationLink;
    }

    public void setOrderEmployeeId(String orderEmployeeId) {
        this.orderEmployeeId = orderEmployeeId;
    }

    public void setMissionEmployeeId(String missionEmployeeId) {
        this.missionEmployeeId = missionEmployeeId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientLocationLink() {
        return clientLocationLink;
    }

    public String getOrderEmployeeId() {
        return orderEmployeeId;
    }

    public String getMissionEmployeeId() {
        return missionEmployeeId;
    }

    public boolean getStatus() {
        return status;
    }
}
