package com.gildedrose;

import com.gildedrose.updaters.AgedBrieUpdater;
import com.gildedrose.updaters.BackstagePassUpdater;
import com.gildedrose.updaters.ConjuredUpdater;
import com.gildedrose.updaters.DefaultUpdater;
import com.gildedrose.updaters.SulfurasUpdater;
import com.gildedrose.updaters.Updater;

import java.util.ArrayList;
import java.util.List;

public class UpdaterFactory {

    private final List<Updater> updaters = new ArrayList<>();
    private final Updater defaultUpdater;

    public UpdaterFactory() {
        defaultUpdater = new DefaultUpdater();
        updaters.add(new AgedBrieUpdater());
        updaters.add(new SulfurasUpdater());
        updaters.add(new BackstagePassUpdater());
        updaters.add(new ConjuredUpdater());
    }
    public Updater forName(String name) {
        return updaters.stream().filter(u -> u.matches(name)).findAny().orElse(defaultUpdater);
    }
}
