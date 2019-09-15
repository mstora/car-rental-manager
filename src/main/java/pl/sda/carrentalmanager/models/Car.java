package pl.sda.carrentalmanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Car {

    @Id
    private String id;
    private String brand;
    private String model;
    private int mileage;
    private boolean isDamaged;
    private boolean isAvailable;
    private int pricePerDay;
    @OneToMany(mappedBy = "car")
    private Set<Rental> rentals = new HashSet<>();
    private boolean exist;

    public Car() {
        this.isAvailable = true;
        this.exist = true;
    }

    public Car(String id, String brand, String model, int pricePerDay, int mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isDamaged = false;
        this.isAvailable = true;
        this.pricePerDay = pricePerDay;
        this.exist = true;
        this.mileage = mileage;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage &&
                isDamaged == car.isDamaged &&
                isAvailable == car.isAvailable &&
                pricePerDay == car.pricePerDay &&
                exist == car.exist &&
                Objects.equals(id, car.id) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, mileage, isDamaged, isAvailable, pricePerDay, exist);
    }
}


