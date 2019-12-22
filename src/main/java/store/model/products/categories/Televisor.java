package store.model.products.categories;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "televisor",schema = "store")
public class Televisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String weight;

    private String size;

    private String diagonal;

    @Column(name = "screensize")
    private String screenSize;

    @Column(name = "soundpower")
    private String soundPower;

    @Column(name = "numberspeakers")
    private String numberSpeakers;

    private String wifi;

    private String bluetooth;

    @Column(name = "smarttv")
    private String smartTV;

    private String usb;

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

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getSmartTV() {
        return smartTV;
    }

    public void setSmartTV(String smartTV) {
        this.smartTV = smartTV;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }
}
