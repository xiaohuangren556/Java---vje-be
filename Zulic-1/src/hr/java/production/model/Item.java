package hr.java.production.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String name;
    private Category category;
    private BigDecimal width, height, length, productionCost, sellingPrice;

    public Item(String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice) {
        this.name = name;
        this.category = category;
        this.width = width;
        this.height = height;
        this.length = length;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(BigDecimal productionCost) {
        this.productionCost = productionCost;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(category, item.category) && Objects.equals(width, item.width) && Objects.equals(height, item.height) && Objects.equals(length, item.length) && Objects.equals(productionCost, item.productionCost) && Objects.equals(sellingPrice, item.sellingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, width, height, length, productionCost, sellingPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", productionCost=" + productionCost +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}

