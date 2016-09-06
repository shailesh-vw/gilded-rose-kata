package com.gildedrose.item;

/**
 * Created by Shailesh on 9/2/16.
 */
public class NormalItem extends Item {
    public NormalItem(int sellInDays, int quality) {
        super("Normal Item", sellInDays, quality);
    }

    @Override
    public void updateQuality() {
        for (int numberOfTimes = 0; numberOfTimes < 2; numberOfTimes++) {
            decreaseQuality();
        }
    }
}
