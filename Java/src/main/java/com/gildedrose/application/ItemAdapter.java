package com.gildedrose.application;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemType;

public class ItemAdapter {
    private final Item item;
    private final ItemType itemType;

    public ItemAdapter(ItemType itemType, Item item) {
        this.itemType = itemType;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public String toStringFull() { return this.toString() + ", " + itemType.getName(); }

    public static ItemAdapter createItemAdapter(Item item) {
        ItemType itemType = ItemType.findByValue(item.name);
        return new ItemAdapter(itemType, item);
    }
}
