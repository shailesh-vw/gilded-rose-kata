package com.gildedrose.item;

public class Item {

    private String name;

    private int sellInDays;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellInDays = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellInDays + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellInDays() {
        return sellInDays;
    }

    public void setSellInDays(int sellInDays) {
        this.sellInDays = sellInDays;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public boolean nameAs(String checkName) {
        return name.equals(checkName);
    }

    public boolean isSellDatePassed() {
        return sellInDays < 0;
    }

    public boolean isQualityInLimit() {
        return quality > 0 && quality < 50;
    }

    public void decreaseQuality() {
        if (isQualityInLimit()) {
            quality--;
        }
    }

    public void increaseQuality() {
        if (isQualityInLimit()) {
            quality++;
        }
    }

    public boolean isSellInLessThan(int numberOfDays) {
        return sellInDays < numberOfDays;
    }

    public void updateQuality() {

    }

    public void reduceSellInDays() {
        sellInDays--;
    }
}