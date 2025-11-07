package com.gildedrose.updaters;

import com.gildedrose.Item;

public abstract class Updater {

    private final String itemName;

    protected Updater(String itemName) {
        this.itemName = itemName;
    }

    public boolean matches(Item item) {
        return itemName.equals(item.name);
    }

    public abstract void update(Item item);
}
