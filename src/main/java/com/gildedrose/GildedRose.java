package com.gildedrose;

import com.gildedrose.item.Item;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

class GildedRose {
    private List<Item> items;

    public GildedRose(Item... items) {
        this.items = new LinkedList(asList(items));
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQualityAndSellInDays() {
        for (Item currentItem : items) {
            currentItem.reduceSellInDays();
            currentItem.updateQuality();
        }
    }
}