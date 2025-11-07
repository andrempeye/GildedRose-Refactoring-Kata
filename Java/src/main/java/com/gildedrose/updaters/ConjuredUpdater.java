package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredUpdater extends Updater {

    public ConjuredUpdater() {
        super("Conjured Mana Cake");
    }
    @Override
    public void update(Item item) {
        item.sellIn-=1;
        int decrement = item.sellIn < 0 ? 4 : 2;
        item.quality = Math.max(0, item.quality - decrement);
    }
}
