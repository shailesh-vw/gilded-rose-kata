package com.gildedrose.item;

/**
 * Created by Shailesh on 9/2/16.
 */
public class ConjuredItem extends Item {
    public ConjuredItem(int sellInDays, int quality) {
        super("Conjured Item", sellInDays, quality);
    }

    @Override
    public void updateQuality() {
        for (int numberOfTimes = 0; numberOfTimes < 4; numberOfTimes++) {
            decreaseQuality();
        }
    }
}
