package hr.java.production.model;

import java.util.Arrays;
import java.util.Objects;

public class Store {
    private String name;
    private String webAddress;
    private Item[] items;

    public Store(String name, String webAddress, Item[] items) {
        this.name = name;
        this.webAddress = webAddress;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
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
        Store store = (Store) o;
        return Objects.equals(name, store.name) && Objects.equals(webAddress, store.webAddress) && Arrays.equals(items, store.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, webAddress);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

