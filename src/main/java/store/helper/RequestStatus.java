package store.helper;

public enum RequestStatus {

    OK_STATUS(1),
    BAD_STATUS(2);

    private Integer status;

    RequestStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
