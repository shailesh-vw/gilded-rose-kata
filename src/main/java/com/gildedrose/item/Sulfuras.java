package com.gildedrose.item;

/**
 * Created by Shailesh on 9/1/16.
 */
public class Sulfuras extends Item {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellInDays, int quality) {
        super(SULFURAS, sellInDays, quality);
    }

    @Override
    public void updateQuality(){
        //do nothing
    }

    @Override
    public void reduceSellInDays(){
        //do nothing
    }
}
