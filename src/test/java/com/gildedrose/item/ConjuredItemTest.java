package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Shailesh on 9/2/16.
 */
public class ConjuredItemTest {


    private Item conjuredItem;

    @Before
    public void setUp() throws Exception {
        conjuredItem = new ConjuredItem(0, 0);
    }

    @Test
    public void testObjectCreated_returnsNotNullObject_whenNewObjectIsCreated() {
        assertThat(conjuredItem, is(notNullValue()));
    }

    @Test
    public void testGetItemName_returnsItemName_whenNewObjectIsCreated() {
        assertThat(conjuredItem.getName(), is("Conjured Item"));
    }

    @Test
    public void testUpdateQuality_updatesQuality_whenSellInDaysArePassed() {
        Item conjuredItem = new ConjuredItem(10, 15);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.getQuality(), is(11));
    }


}