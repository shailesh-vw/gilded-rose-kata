package com.gildedrose.item;

/**
 * Created by Shailesh on 9/1/16.
 */
public class AgedBrie extends Item {
    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(int sellInDays, int quality) {
        super(AGED_BRIE, sellInDays, quality);
    }

    @Override
    public void updateQuality() {
        if (isSellDatePassed()) {
            increaseQuality();
        }

        increaseQuality();
    }
}
