package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Shailesh on 9/1/16.
 */
public class BackstagePassesTest {

    private Item backstagePasses;

    @Before
    public void setUp() throws Exception {
        backstagePasses = new BackstagePasses(0, 0);
    }

    @Test
    public void testObjectCreated_returnsNotNullObject_whenNewObjectIsCreated() {
        assertThat(backstagePasses, is(notNullValue()));
    }

    @Test
    public void testGetItemName_returnsItemName_whenNewObjectIsCreated() {
        assertThat(backstagePasses.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
    }

    @Test
    public void testUpdateQuality_updatesQualityToZero_whenSellInDaysArePassed() {
        Item backstagePasses = new BackstagePasses(-1, 10);

        backstagePasses.updateQuality();
        assertThat(backstagePasses.getQuality(), is(0));
    }

    @Test
    public void testUpdateQuality_updatesQuality_whenSellInDaysWithinConcert() {
        Item backstagePasses = new BackstagePasses(23, 15);

        backstagePasses.updateQuality();
        assertThat(backstagePasses.getQuality(), is(16));
    }

    @Test
    public void testUpdateQuality_increaseQualityByTwo_whenSellInDaysBelowTenAndWithinConcert() {
        Item backstagePasses = new BackstagePasses(9, 10);

        backstagePasses.updateQuality();
        assertThat(backstagePasses.getQuality(), is(12));
    }

    @Test
    public void testUpdateQuality_increaseQualityByThree_whenSellInDaysBelowFiveAndWithinConcert() {
        Item backstagePasses = new BackstagePasses(4, 35);

        backstagePasses.updateQuality();
        assertThat(backstagePasses.getQuality(), is(38));
    }
}
