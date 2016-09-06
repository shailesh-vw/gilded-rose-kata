package com.gildedrose;


import com.gildedrose.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {

    private GildedRose testGildedRose;
    private static final int DEFAULT_SELL_IN_DAYS = 0;

    private static final int DEFAULT_QUALITY = 0;
    private static final Item AGED_BRIE_ITEM = new AgedBrie(DEFAULT_SELL_IN_DAYS, DEFAULT_QUALITY);

    private static final Item BACKSTAGE_PASSES_ITEM = new BackstagePasses(DEFAULT_SELL_IN_DAYS, DEFAULT_QUALITY);
    private static final Item SULFURAS_ITEM = new Sulfuras(DEFAULT_SELL_IN_DAYS, DEFAULT_QUALITY);
    private static final Item NORMAL_ITEM = new NormalItem(DEFAULT_SELL_IN_DAYS, DEFAULT_QUALITY);
    private static final Item CONJURED_ITEM = new ConjuredItem(DEFAULT_SELL_IN_DAYS, DEFAULT_QUALITY);


    @Before
    public void setUp() {
        testGildedRose = new GildedRose();
    }


    @Test
    public void testUpdateQualityAndSellInDays_increaseInQuality_whenAgedBrieGetsMoreOlder() {
        givenAvailableItemIs(AGED_BRIE_ITEM, withSellInDays(12), andQualityAs(40));

        whenQualityIsUpdated();

        thenQuality(isAt(41));
    }

    @Test
    public void testUpdateQualityAndSellInDays_increaseInQuality_whenBackstagePassesGetsMoreOlder() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(12), andQualityAs(45));

        whenQualityIsUpdated();

        thenQuality(isAt(46));
    }


    @Test
    public void testUpdateQualityAndSellInDays_doesNotIncreaseQualityAboveLimit_whenBackstagePassesGetsMoreOlder() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(12), andQualityAs(50));

        whenQualityIsUpdated();

        thenQuality(isAt(50));
    }

    @Test
    public void testUpdateQualityAndSellInDays_increaseInQualityByTwo_whenSellInDaysAreLessThanTenDaysForBackstagePasses() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(9), andQualityAs(45));

        whenQualityIsUpdated();

        thenQuality(isAt(47));
    }

    @Test
    public void testUpdateQualityAndSellInDays_increaseInQualityByThree_whenSellInDaysAreLessThanFiveDaysForBackstagePasses() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(4), andQualityAs(45));

        whenQualityIsUpdated();

        thenQuality(isAt(48));
    }

    @Test
    public void testUpdateQualityAndSellInDays_twiceIncreaseInQuality_whenSellInDaysArePassedForAgedBrieItem() {
        givenAvailableItemIs(AGED_BRIE_ITEM, withSellInDays(0), andQualityAs(48));

        whenQualityIsUpdated();

        thenQuality(isAt(50));
    }

    @Test
    public void testUpdateQualityAndSellInDays_qualityNeverGoesToNegative_whenSellInDaysAreReducedOrPassed() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(0), andQualityAs(0));

        whenQualityIsUpdated();

        thenQuality(isAt(0));
    }


    @Test
    public void testUpdateQualityAndSellInDays_makeQualityToZero_whenBackstagePassesAtConcert() {
        givenAvailableItemIs(BACKSTAGE_PASSES_ITEM, withSellInDays(0), andQualityAs(50));

        whenQualityIsUpdated();

        thenQuality(isAt(0));
    }


    @Test
    public void testUpdateQualityAndSellInDays_noChangeInItemDetails_whenItemIsSulfuras() {
        givenAvailableItemIs(SULFURAS_ITEM, withSellInDays(10), andQualityAs(50));


        whenQualityIsUpdated();

        thenSellInDays(isAt(10));
        thenQuality(isAt(50));
    }

    @Test
    public void testUpdateQualityAndSellInDays_decreasesInQualityByTwo_forAllNormalItem() {
        givenAvailableItemIs(NORMAL_ITEM, withSellInDays(10), andQualityAs(10));

        whenQualityIsUpdated();

        thenSellInDays(isAt(9));
        thenQuality(isAt(8));
    }

    @Test
    public void testUpdateQualityAndSellInDays_decreasesInQualityTwiceAsNormalItem_forAllConjuredItems(){
        givenAvailableItemIs(CONJURED_ITEM, withSellInDays(10), andQualityAs(15));

        whenQualityIsUpdated();

        thenSellInDays(isAt(9));
        thenQuality(isAt(11));
    }

    private void givenAvailableItemIs(Item newItem, int sellInDays, int quality) {
        newItem.setSellInDays(sellInDays);
        newItem.setQuality(quality);
        testGildedRose.getItems().add(newItem);
    }

    private int withSellInDays(int sellInDays) {
        return sellInDays;
    }

    private int andQualityAs(int quality) {
        return quality;
    }

    private void whenQualityIsUpdated() {
        testGildedRose.updateQualityAndSellInDays();
    }

    private void thenSellInDays(int expectedSellIn) {
        assertThat(testGildedRose.getItems().get(0).getSellInDays(), is(expectedSellIn));
    }

    private void thenQuality(int expectedQuality) {
        assertThat(testGildedRose.getItems().get(0).getQuality(), is(expectedQuality));
    }

    private int isAt(int value) {
        return value;
    }
}