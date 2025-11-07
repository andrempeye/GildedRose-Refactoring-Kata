package com.gildedrose;

import com.gildedrose.updaters.AgedBrieUpdater;
import com.gildedrose.updaters.DefaultUpdater;
import com.gildedrose.updaters.Updater;

import java.util.ArrayList;
import java.util.List;

public class UpdaterFactory {

    private List<Updater> updaters = new ArrayList<>();
    private Updater defaultUpdater = new DefaultUpdater();

    public UpdaterFactory() {
        defaultUpdater = new DefaultUpdater();
        updaters.add(new AgedBrieUpdater());
    }
    public Updater forName(String name) {
        return updaters.stream().filter(u -> u.matches(name)).findAny().orElse(defaultUpdater);
    }
}
