package hr.java.production.model;

import java.util.Arrays;
import java.util.Objects;

public class Factory {
    private String name;
    private Address address;
    private Item[] items;

    public Factory(String name, Address address, Item[] items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factory factory = (Factory) o;
        return Objects.equals(name, factory.name) && Objects.equals(address, factory.address) && Arrays.equals(items, factory.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, address);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

