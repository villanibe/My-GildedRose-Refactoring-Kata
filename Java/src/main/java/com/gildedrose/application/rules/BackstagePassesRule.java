package com.gildedrose.application.rules;

import com.gildedrose.core.UpdateInventoryTemplateRule;
import com.gildedrose.application.ItemAdapter;

public class BackstagePassesRule extends UpdateInventoryTemplateRule {

    final int SELL_IN_DAY10 = 10;
    final int SELL_IN_DAY5 = 5;

    @Override
    protected void onExpired(final ItemAdapter itemAdapter) {
        itemAdapter.getItem().quality = 0;
    }

    @Override
    protected boolean canSubtractSellIn(final ItemAdapter itemAdapter) {
        return true;
    }

    @Override
    protected int getQualityFactor(final boolean isExpired, final ItemAdapter itemAdapter) {
        int qualityFactor = 1;
        if (itemAdapter.getItem().sellIn <= SELL_IN_DAY5) {
            qualityFactor = 3;
        } else if (itemAdapter.getItem().sellIn <= SELL_IN_DAY10) {
            qualityFactor = 2;
        }
        return qualityFactor;
    }

    @Override
    protected boolean canIncreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return !isExpired;
    }

    @Override
    protected boolean canDecreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return isExpired;
    }
}
