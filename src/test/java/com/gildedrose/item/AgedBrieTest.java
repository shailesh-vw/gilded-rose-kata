package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Shailesh on 9/1/16.
 */
public class AgedBrieTest {

    private Item agedBrie;

    @Before
    public void setUp() throws Exception {
        agedBrie = new AgedBrie(0, 0);
    }

    @Test
    public void testObjectCreated_returnsNotNullObject_whenNewObjectIsCreated() {
        assertThat(agedBrie, is(notNullValue()));
    }

    @Test
    public void testGetItemName_returnsItemName_whenNewObjectIsCreated() {
        assertThat(agedBrie.getName(), is("Aged Brie"));
    }

    @Test
    public void testUpdateQuality_updatesQuality_whenSellInDaysArePassed() {
        Item agedBrie = new AgedBrie(-1, 10);
        agedBrie.updateQuality();
        assertThat(agedBrie.getQuality(), is(12));
    }
}
