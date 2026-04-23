package com.gildedrose.domain.item;

public final class ItemAdapterResolver {

    public static ItemAdapter createItemAdapter(Item item) {
        ItemType itemType = ItemType.findByValue(item.name);
         return new ItemAdapter(itemType, item);
    }
}
