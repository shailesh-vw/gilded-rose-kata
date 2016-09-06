package com.gildedrose.item;

/**
 * Created by Shailesh on 9/1/16.
 */
public class BackstagePasses extends Item {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(int sellInDays, int quality) {
        super(BACKSTAGE_PASSES, sellInDays, quality);
    }

    @Override
    public void updateQuality() {
        if (isSellDatePassed()) {
            setQuality(0);
        }

        if (isSellInLessThan(10)) {
            increaseQuality();
        }

        if (isSellInLessThan(5)) {
            increaseQuality();
        }
        increaseQuality();
    }
}
