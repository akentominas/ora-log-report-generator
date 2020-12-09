package model;

public class Request {
    private String address;
    private String dateTime;
    private String timestamp;
    private String requestMethod;
    private String endPoint;
    private String protocol;
    private String status;
    private String someNumber;

    public Request(String address, String dateTime, String timestamp, String requestMethod, String endPoint, String protocol, String status, String someNumber) {
        this.address = address;
        this.dateTime = dateTime;
        this.timestamp = timestamp;
        this.requestMethod = requestMethod;
        this.endPoint = endPoint;
        this.protocol = protocol;
        this.status = status;
        this.someNumber = someNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(String someNumber) {
        this.someNumber = someNumber;
    }

    @Override
    public String toString() {
        return "Request{" +
                "address='" + address + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", protocol='" + protocol + '\'' +
                ", status='" + status + '\'' +
                ", someNumber='" + someNumber + '\'' +
                '}';
    }
}
