package com.gildedrose.application.sulfuras;

import com.gildedrose.core.rule.UpdateInventoryTemplateRule;
import com.gildedrose.domain.item.ItemAdapter;

public class SulfurasRule extends UpdateInventoryTemplateRule {

    final int SULFURAS_DEFAULT_QUALITY = 80;

    @Override
    public final void processItem(final ItemAdapter itemAdapter) {

        // Enforce Sulfuras quality constraint
        itemAdapter.getItem().quality = SULFURAS_DEFAULT_QUALITY;
        // Don't process: never changes
    }

    @Override
    protected boolean canSubtractSellIn(final ItemAdapter itemAdapter) {
        return false;
    }

    @Override
    protected int getQualityFactor(final boolean isExpired, final ItemAdapter itemAdapter) {
        return 0;
    }

    @Override
    protected boolean canIncreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return false;
    }

    @Override
    protected boolean canDecreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return false;
    }
}
