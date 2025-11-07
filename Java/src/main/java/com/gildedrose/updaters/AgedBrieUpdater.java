package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends Updater {

    private static final int MAX_QUALITY = 50;

    public AgedBrieUpdater() {
        super("Aged Brie");
    }

    @Override
    public void update(Item item) {
        item.sellIn-=1;
        int increment = item.sellIn < 0 ? 2 : 1;
        item.quality = Math.min(MAX_QUALITY, item.quality + increment);

    }
}
