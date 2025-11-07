package com.gildedrose.updaters;

import com.gildedrose.Item;

public interface Updater {

    boolean matches(String name);
    void update(Item item);
}
