package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Shailesh on 8/31/16.
 */
public class ItemTest {

    private Item testItem;

    @Before
    public void setUp() {
        testItem = new Item("foo", 0, 0);
    }

    @Test
    public void testNameAs_returnsTrue_whenItemNameDoesMatch() {
        assertThat(testItem.nameAs("foo"), is(true));
    }

    @Test
    public void testNameAs_returnsFalse_whenItemNameDoesNotMatch() {
        assertThat(testItem.nameAs("blah"), is(false));
    }

    @Test
    public void testIsSellDatePassed_returnsTrue_whenSellDateIsPassed() {
        testItem.setSellInDays(-1);
        assertThat(testItem.isSellDatePassed(), is(true));
    }

    @Test
    public void testIsSellDatePassed_returnsFalse_whenSellDateIsNotPassed() {
        assertThat(testItem.isSellDatePassed(), is(false));
    }

    @Test
    public void testIsQualityInLimit_returnsTrue_whenQualityIsAboveZero() {
        testItem.setQuality(1);
        assertThat(testItem.isQualityInLimit(), is(true));
    }

    @Test
    public void testIsQualityInLimit_returnsFalse_whenQualityIsBelowZero() {
        testItem.setQuality(-1);
        assertThat(testItem.isQualityInLimit(), is(false));
    }

    @Test
    public void testIsQualityInLimit_returnsFalse_whenQualityIsAboveFifty() {
        testItem.setQuality(55);
        assertThat(testItem.isQualityInLimit(), is(false));
    }

    @Test
    public void testIsQualityInLimit_returnsTrue_whenQualityIsBelowFifty() {
        testItem.setQuality(45);
        assertThat(testItem.isQualityInLimit(), is(true));
    }

    @Test
    public void testDecreaseQuality_decreasesQuality_whenQualityIsInLimit() {
        testItem.setQuality(20);
        testItem.decreaseQuality();
        assertThat(testItem.getQuality(), is(19));
    }

    @Test
    public void testDecreaseQualityInLimitBy_doesNotDecreaseQuality_whenQualityIsNotInLimit() {
        testItem.setQuality(0);
        testItem.decreaseQuality();
        assertThat(testItem.getQuality(), is(0));
    }

    @Test
    public void testIncreaseQuality_increasesQualityByOne_whenQualityIsInLimit() {
        testItem.setQuality(20);
        testItem.increaseQuality();
        assertThat(testItem.getQuality(), is(21));
    }

    @Test
    public void testIncreaseQuality_doesNotIncreaseQuality_whenQualityIsNotInLimit() {
        testItem.setQuality(50);
        testItem.increaseQuality();
        assertThat(testItem.getQuality(), is(50));
    }

    @Test
    public void testIsSellInLessThan_returnsTrue_whenSellInDaysLessThanNumberOfDays() {
        testItem.setSellInDays(3);
        assertThat(testItem.isSellInLessThan(6), is(true));
    }

    @Test
    public void testIsSellInLessThan_returnsFalse_whenSellInDaysMoreThanNumberOfDays() {
        testItem.setSellInDays(10);
        assertThat(testItem.isSellInLessThan(6), is(false));
    }

    @Test
    public void testReduceSellInDays_reduceSellInDaysByOne_whileReducingSellInDays() {
        testItem.setSellInDays(10);
        testItem.reduceSellInDays();
        assertThat(testItem.getSellInDays(), is(9));
    }

}