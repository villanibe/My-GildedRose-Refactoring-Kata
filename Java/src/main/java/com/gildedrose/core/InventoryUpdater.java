package com.gildedrose.core;

import com.gildedrose.application.ItemAdapter;

public class InventoryUpdater {

    public static void applyUpdateRule(ItemAdapter itemAdapter) {
        final UpdateInventoryTemplateRule rule = RuleRegistry.getRule(itemAdapter.getItemType());
        if (rule != null) {
            rule.processItem(itemAdapter);
        } else {
            throw new IllegalArgumentException("No rule found for item type: " + itemAdapter.getItemType());
        }
    }
}
