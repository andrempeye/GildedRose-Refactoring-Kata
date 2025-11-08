package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    private final UpdaterStrategy updaterStrategy;

    public GildedRose(Item[] items) {
        updaterStrategy = new UpdaterStrategy();
        this.items = items;
    }

    private void update(Item item) {
        updaterStrategy.forItem(item).update(item);
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::update);
    }
}
