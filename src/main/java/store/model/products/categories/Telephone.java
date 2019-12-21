package store.model.products.categories;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "telephone",schema = "store")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String os;

    private String weight;

    private String size;

    private String diagonal;

    private String processor;

    @Column(name = "internalmemory")
    private String internalMemory;

    private String ram;

    @Column(name = "batterycapacity")
    private String batteryCapacity;

    @Column(name = "numbercamera")
    private String numberCamera;

    private Boolean nfc;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getNumberCamera() {
        return numberCamera;
    }

    public void setNumberCamera(String numberCamera) {
        this.numberCamera = numberCamera;
    }

    public Boolean getNfc() {
        return nfc;
    }

    public void setNfc(Boolean nfc) {
        this.nfc = nfc;
    }
}
