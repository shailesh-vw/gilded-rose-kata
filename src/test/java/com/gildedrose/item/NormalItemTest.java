package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Shailesh on 9/2/16.
 */
public class NormalItemTest {

    private Item normalItem;

    @Before
    public void setUp() throws Exception {
        normalItem = new NormalItem(0, 0);
    }

    @Test
    public void testObjectCreated_returnsNotNullObject_whenNewObjectIsCreated() {
        assertThat(normalItem, is(notNullValue()));
    }

    @Test
    public void testGetItemName_returnsItemName_whenNewObjectIsCreated() {
        assertThat(normalItem.getName(), is("Normal Item"));
    }

    @Test
    public void testUpdateQuality_updatesQuality_whenSellInDaysArePassed() {
        Item normalItem = new NormalItem(10, 10);
        normalItem.updateQuality();
        assertThat(normalItem.getQuality(), is(8));
    }
}