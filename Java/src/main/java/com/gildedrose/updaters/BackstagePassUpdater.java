package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater extends Updater {

    private static final int HIGH_URGENCY_LIMIT = 10;
    private static final int CRITICAL_URGENCY_LIMIT = 5;

    public BackstagePassUpdater() {
        super("Backstage passes to a TAFKAL80ETC concert");
    }
    @Override
    public void update(Item item) {
        item.sellIn-=1;
        int increment = 1;
        if(item.sellIn < HIGH_URGENCY_LIMIT ) {
            increment = 2;
        }
        if(item.sellIn < CRITICAL_URGENCY_LIMIT ) {
            increment = 3;
        }
        if (item.sellIn < 0) {
           item.quality = 0;
        } else {
            item.quality = Math.min(50, item.quality + increment);
        }
    }
}
