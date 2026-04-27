package com.gildedrose.core;

import com.gildedrose.application.rules.*;
import com.gildedrose.domain.ItemType;

import java.util.Map;

public class RuleRegistry {

    private static final Map<ItemType, UpdateInventoryTemplateRule> RULES =
        Map.of(
            ItemType.AGED_BRIE, new AgedBrieRule(),
            ItemType.SULFURAS, new SulfurasRule(),
            ItemType.BACKSTAGE_PASSES, new BackstagePassesRule(),
            ItemType.STANDARD, new StandardItemRule(),
            ItemType.CONJURED, new ConjuredRule()
        );

    public static UpdateInventoryTemplateRule getRule(final ItemType itemType) {
        return RULES.get(itemType);
    }
}
