package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item DEFAULT_ITEM = new Item("DefaultItem", 5, 10);
    Item EXPIRED_ITEM = new Item("ExpiredItem", -1, 10);
    Item ZERO_QUALITY_ITEM = new Item("ZeroQualityItem", 5, 0);
    Item AGED_BRIE = new Item("Aged Brie", 5, 10);
    Item AGED_BRIE_MAX_QUALITY = new Item("Aged Brie", 5, 50);
    Item SULFURAS = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    Item BACKSTAGE_PASSES_LOW_URGENCY = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
    Item BACKSTAGE_PASSES_HIGH_URGENCY = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);
    Item BACKSTAGE_PASSES_CRITICAL_URGENCY = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10);
    Item BACKSTAGE_PASSES_EXPIRED = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    Item CONJURED = new Item("Conjured", 5, 10);

    @Test
    void updateQuality_defaultBehavior_decrementsQualityAndSellInOf1() {
        Item[] items = new Item[] { DEFAULT_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("DefaultItem", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateQuality_expired_decrementsQualityOf2() {
        Item[] items = new Item[] { EXPIRED_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("ExpiredItem", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateQuality_qualityIsZero_qualityDoesNotDecrease() {
        Item[] items = new Item[] { ZERO_QUALITY_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("ZeroQualityItem", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_AgedBrie_qualityIncreases() {
        Item[] items = new Item[] { AGED_BRIE };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_AgedBrieQuality50_qualityDoesNotIncrease() {
        Item[] items = new Item[] {AGED_BRIE_MAX_QUALITY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_Sulfuras_qualityStaysAt80() {
        Item[] items = new Item[] {SULFURAS};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesWithLowUrgency_qualityIncreasesOf1() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_LOW_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesWithHighUrgency_qualityIncreasesOf2() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_HIGH_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesWithCriticalUrgency_qualityIncreasesOf3() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_CRITICAL_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesExpired_qualityIsZero() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_EXPIRED};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

//    @Test
//    void updateQuality_Conjured_qualityDecreasesOf2() {
//        Item[] items = new Item[] {CONJURED};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("Conjured", app.items[0].name);
//        assertEquals(4, app.items[0].sellIn);
//        assertEquals(8, app.items[0].quality);
//    }

}
