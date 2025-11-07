package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater implements Updater {

    public static final String AGED_BRIE = "Aged Brie";
    private static final int MAX_QUALITY = 50;

    @Override
    public boolean matches(String name) {
        return AGED_BRIE.equals(name);
    }

    @Override
    public void update(Item item) {
        item.sellIn-=1;
        item.quality = Math.min(MAX_QUALITY, item.quality + 1);
    }
}
