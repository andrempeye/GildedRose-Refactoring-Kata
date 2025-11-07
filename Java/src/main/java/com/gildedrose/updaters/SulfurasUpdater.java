package com.gildedrose.updaters;

import com.gildedrose.Item;

public class SulfurasUpdater extends Updater {

    private static final int CONSTANT_QUALITY = 80;

    public SulfurasUpdater() {
        super("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void update(Item item) {
        if(item.quality != CONSTANT_QUALITY) {
            throw new IllegalStateException("Sulfuras quality is always " + CONSTANT_QUALITY + "!");
        }
    }
}
