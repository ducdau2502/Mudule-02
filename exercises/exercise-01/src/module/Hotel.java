package module;

public class Hotel {
    private int numberStay;
    private String kindOfRoom;
    private double priceOfRoom;
    private Customer customer;

    public Hotel() {
    }

    public Hotel(int numberStay, String kindOfRoom, double priceOfRoom) {
        this.numberStay = numberStay;
        this.kindOfRoom = kindOfRoom;
        this.priceOfRoom = priceOfRoom;
    }

    public Hotel(int numberStay, String kindOfRoom, double priceOfRoom, Customer customer) {
        this.numberStay = numberStay;
        this.kindOfRoom = kindOfRoom;
        this.priceOfRoom = priceOfRoom;
        this.customer = customer;
    }

    public int getNumberStay() {
        return numberStay;
    }

    public void setNumberStay(int numberStay) {
        this.numberStay = numberStay;
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public void setKindOfRoom(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public double getPriceOfRoom() {
        return priceOfRoom;
    }

    public void setPriceOfRoom(double priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
       return String.format("%-15d %-15s %-15.2f %s ", getNumberStay(), getKindOfRoom(), getPriceOfRoom(), getCustomer());
    }
}
