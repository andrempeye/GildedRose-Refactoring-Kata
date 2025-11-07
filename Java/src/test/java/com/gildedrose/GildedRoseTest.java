package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    public static final String DEFAULT_ITEM_NAME = "DefaultItem";
    public static final String EXPIRED_ITEM_NAME = "ExpiredItem";
    public static final String ZERO_QUALITY_ITEM_NAME = "ZeroQualityItem";
    public static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_NAME = "Conjured Mana Cake";
    Item DEFAULT_ITEM = new Item(DEFAULT_ITEM_NAME, 5, 10);
    Item EXPIRED_ITEM = new Item(EXPIRED_ITEM_NAME, -1, 10);
    Item ZERO_QUALITY_ITEM = new Item(ZERO_QUALITY_ITEM_NAME, 5, 0);
    Item AGED_BRIE = new Item(AGED_BRIE_NAME, 5, 10);
    Item AGED_BRIE_EXPIRED = new Item(AGED_BRIE_NAME, -1, 10);
    Item AGED_BRIE_MAX_QUALITY = new Item(AGED_BRIE_NAME, 5, 50);
    Item SULFURAS = new Item(SULFURAS_NAME, 0, 80);
    Item SULFURAS_79 = new Item(SULFURAS_NAME, 0, 79);
    Item BACKSTAGE_PASSES_LOW_URGENCY = new Item(BACKSTAGE_PASSES_NAME, 11, 10);
    Item BACKSTAGE_PASSES_HIGH_URGENCY = new Item(BACKSTAGE_PASSES_NAME, 6, 10);
    Item BACKSTAGE_PASSES_CRITICAL_URGENCY = new Item(BACKSTAGE_PASSES_NAME, 4, 10);
    Item BACKSTAGE_PASSES_EXPIRED = new Item(BACKSTAGE_PASSES_NAME, -1, 10);
    Item CONJURED = new Item(CONJURED_NAME, 5, 10);
    Item CONJURED_EXPIRED = new Item(CONJURED_NAME, -1, 10);
    Item ZERO_QUALITY_CONJURED = new Item(CONJURED_NAME, 5, 0);

    @Test
    void updateQuality_defaultBehavior_decrementsQualityAndSellInOf1() {
        Item[] items = new Item[] { DEFAULT_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(DEFAULT_ITEM_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateQuality_expired_decrementsQualityOf2() {
        Item[] items = new Item[] { EXPIRED_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(EXPIRED_ITEM_NAME, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateQuality_qualityIsZero_qualityDoesNotDecrease() {
        Item[] items = new Item[] { ZERO_QUALITY_ITEM };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ZERO_QUALITY_ITEM_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_AgedBrie_qualityIncreases() {
        Item[] items = new Item[] { AGED_BRIE };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_AgedBrieExpired_qualityActuallyIncreasesTwiceAsFast() {
        Item[] items = new Item[] { AGED_BRIE_EXPIRED };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE_NAME, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateQuality_AgedBrieQuality50_qualityDoesNotIncrease() {
        Item[] items = new Item[] {AGED_BRIE_MAX_QUALITY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_Sulfuras_qualityStaysAt80() {
        Item[] items = new Item[] {SULFURAS};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS_NAME, app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

//    @Test
//    void updateQuality_SulfurasNotAt80_throwsException() {
//        Item[] items = new Item[] {SULFURAS_79};
//        GildedRose app = new GildedRose(items);
//        assertThrows(IllegalStateException.class, app::updateQuality);
//    }

    @Test
    void updateQuality_BackstagePassesWithLowUrgency_qualityIncreasesOf1() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_LOW_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_NAME, app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesWithHighUrgency_qualityIncreasesOf2() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_HIGH_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_NAME, app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesWithCriticalUrgency_qualityIncreasesOf3() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_CRITICAL_URGENCY};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_NAME, app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePassesExpired_qualityIsZero() {
        Item[] items = new Item[] {BACKSTAGE_PASSES_EXPIRED};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_NAME, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_Conjured_qualityDecreasesOf2() {
        Item[] items = new Item[] {CONJURED};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateQuality_ConjuredAndExpired_qualityDecreasesOf4() {
        Item[] items = new Item[] {CONJURED_EXPIRED};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED_NAME, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void updateQuality_ConjuredAndQualityZero_qualityDoesNotDecrease() {
        Item[] items = new Item[] {ZERO_QUALITY_CONJURED};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(CONJURED_NAME, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
