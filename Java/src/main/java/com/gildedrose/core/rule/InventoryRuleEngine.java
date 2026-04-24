package com.gildedrose.core.rule;

import com.gildedrose.application.agedbrie.AgedBrieRule;
import com.gildedrose.application.backstagepasses.BackstagePassesRule;
import com.gildedrose.application.conjured.ConjuredRule;
import com.gildedrose.application.standard.StandardItemRule;
import com.gildedrose.application.sulfuras.SulfurasRule;
import com.gildedrose.domain.item.ItemAdapter;
import com.gildedrose.domain.item.ItemType;

import java.util.Map;

public class InventoryRuleEngine {

    private static final Map<ItemType, UpdateInventoryTemplateRule> updateInventoryRules =
        Map.of(
            ItemType.AGED_BRIE, new AgedBrieRule(),
            ItemType.SULFURAS, new SulfurasRule(),
            ItemType.BACKSTAGE_PASSES, new BackstagePassesRule(),
            ItemType.STANDARD, new StandardItemRule(),
            ItemType.CONJURED, new ConjuredRule()
        );

    public static void applyUpdateRule(ItemAdapter itemAdapter) {
        final UpdateInventoryTemplateRule rule = updateInventoryRules.get(itemAdapter.getItemType());
        if (rule != null) {
            rule.processItem(itemAdapter);
        } else {
            throw new IllegalArgumentException("No rule found for item type: " + itemAdapter.getItemType());
        }
    }
}
