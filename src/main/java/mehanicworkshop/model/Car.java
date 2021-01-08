package mehanicworkshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"}, ignoreUnknown=true)
@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Type(type = "pg-uuid")
    @Column(name = "car_uuid")
    private UUID carUuid;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "rego")
    private String rego;

    public Car() {
    }

    public Car(Long carId, Customer customer, UUID carUuid, String mark, String model, String rego) {
        this.carId = carId;
        this.customer = customer;
        this.carUuid = carUuid;
        this.mark = mark;
        this.model = model;
        this.rego = rego;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public UUID getCarUuid() {
        return carUuid;
    }

    public void setCarUuid(UUID carUuid) {
        this.carUuid = carUuid;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
