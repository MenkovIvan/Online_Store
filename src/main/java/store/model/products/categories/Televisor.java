package store.model.products.categories;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "televisor",schema = "store")
public class Televisor {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Expose
    private String weight;
    @Expose
    private String size;
    @Expose
    private String diagonal;
    @Expose
    @Column(name = "screensize")
    private String screenSize;
    @Expose
    @Column(name = "soundpower")
    private String soundPower;
    @Expose
    @Column(name = "numberspeakers")
    private String numberSpeakers;
    @Expose
    private Boolean wifi;
    @Expose
    private Boolean bluetooth;
    @Expose
    @Column(name = "smarttv")
    private Boolean smartTV;
    @Expose
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
