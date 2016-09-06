package com.gildedrose.item;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Shailesh on 9/1/16.
 */
public class SulfurasTest {
    private Item sulfuras;


    @Before
    public void setUp() {
        sulfuras = new Sulfuras(0, 0);
    }

    @Test
    public void testObjectCreated_returnsNotNullObject_whenNewObjectIsCreated() {
        assertThat(sulfuras, is(notNullValue()));
    }

    @Test
    public void testGetItemName_returnsItemName_whenNewObjectIsCreated() {
        assertThat(sulfuras.getName(), is("Sulfuras, Hand of Ragnaros"));
    }

    @Test
    public void testUpdateQuality_neverUpdatesAnything_whateverIsTheCase() {
        sulfuras.updateQuality();
        assertThat(sulfuras.getQuality(), is(0));
        assertThat(sulfuras.getSellInDays(), is(0));
    }
}
