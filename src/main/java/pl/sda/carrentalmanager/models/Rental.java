package pl.sda.carrentalmanager.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rental {

    @Id
    @GeneratedValue(generator = "rentSeq")
    @SequenceGenerator(name = "rentSeq", sequenceName = "rent_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfRental;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfReturn;
    private int mileage;
    private boolean damaged;
    private boolean rented;
    private int deposit;
    private int totalPrice;

    public Rental() {
    }

    public Rental(Car car, Client client, LocalDate dateOfRental,
                  LocalDate dateOfReturn, int mileage, boolean damaged, boolean rented, int deposit, int totalPrice) {
        this.car = car;
        this.client = client;
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
        this.mileage = mileage;
        this.damaged = damaged;
        this.rented = rented;
        this.deposit = deposit;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(LocalDate dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return mileage == rental.mileage &&
                damaged == rental.damaged &&
                rented == rental.rented &&
                deposit == rental.deposit &&
                totalPrice == rental.totalPrice &&
                Objects.equals(id, rental.id) &&
                Objects.equals(car, rental.car) &&
                Objects.equals(client, rental.client) &&
                Objects.equals(dateOfRental, rental.dateOfRental) &&
                Objects.equals(dateOfReturn, rental.dateOfReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, client, dateOfRental, dateOfReturn, mileage, damaged, rented, deposit, totalPrice);
    }
}
