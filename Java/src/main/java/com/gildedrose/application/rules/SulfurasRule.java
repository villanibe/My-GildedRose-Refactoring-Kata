package com.gildedrose.application.rules;

import com.gildedrose.core.UpdateInventoryTemplateRule;
import com.gildedrose.application.ItemAdapter;

public class SulfurasRule extends UpdateInventoryTemplateRule {

    final int SULFURAS_DEFAULT_QUALITY = 80;

    @Override
    protected void preProcess(ItemAdapter itemAdapter) {
        itemAdapter.getItem().quality = SULFURAS_DEFAULT_QUALITY;
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
