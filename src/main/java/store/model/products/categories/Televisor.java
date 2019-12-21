package store.model.products.categories;

public class Televisor {
    private Integer id;
    private String weight;
    private String size;
    private String diagonal;
    private String screenSize;
    private String soundPower;
    private String numberSpeakers;
    private Boolean wifi;
    private Boolean bluetooth;
    private Boolean smartTV;
    private Boolean usb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getSoundPower() {
        return soundPower;
    }

    public void setSoundPower(String soundPower) {
        this.soundPower = soundPower;
    }

    public String getNumberSpeakers() {
        return numberSpeakers;
    }

    public void setNumberSpeakers(String numberSpeakers) {
        this.numberSpeakers = numberSpeakers;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getSmartTV() {
        return smartTV;
    }

    public void setSmartTV(Boolean smartTV) {
        this.smartTV = smartTV;
    }

    public Boolean getUsb() {
        return usb;
    }

    public void setUsb(Boolean usb) {
        this.usb = usb;
    }
}
