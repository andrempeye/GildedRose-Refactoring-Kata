package com.gildedrose.updaters;

import com.gildedrose.Item;

public class DefaultUpdater extends Updater {

    public DefaultUpdater() {
        super(null);
    }
    @Override
    public boolean matches(String name) {
        return false;
    }

    @Override
    public void update(Item item) {
        item.sellIn-=1;
        int decrement = item.sellIn < 0 ? 2 : 1;
        item.quality = Math.max(0, item.quality - decrement);
    }
}
