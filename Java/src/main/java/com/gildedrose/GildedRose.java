package com.gildedrose;

import com.gildedrose.core.InventoryUpdater;
import com.gildedrose.domain.Item;
import com.gildedrose.application.ItemAdapter;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemAdapter itemAdapter = ItemAdapter.createItemAdapter(item);
            InventoryUpdater.applyUpdateRule(itemAdapter);
        }
    }
}
