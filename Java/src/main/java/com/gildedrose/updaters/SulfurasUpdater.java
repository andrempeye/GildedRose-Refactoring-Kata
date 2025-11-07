package com.gildedrose.updaters;

import com.gildedrose.Item;

public class SulfurasUpdater implements Updater {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int CONSTANT_QUALITY = 80;

    @Override
    public boolean matches(String name) {
        return SULFURAS.equals(name);
    }

    @Override
    public void update(Item item) {

    }
}
