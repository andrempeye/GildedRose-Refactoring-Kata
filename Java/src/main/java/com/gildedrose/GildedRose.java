package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    private final UpdaterFactory updaterFactory;

    public GildedRose(Item[] items) {
        updaterFactory = new UpdaterFactory();
        this.items = items;
    }

    private void update(Item item) {
        updaterFactory.forItem(item).update(item);
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::update);
    }
}
