package com.gildedrose.application.rules;

import com.gildedrose.core.UpdateInventoryTemplateRule;
import com.gildedrose.application.ItemAdapter;

public class AgedBrieRule extends UpdateInventoryTemplateRule {

    @Override
    protected boolean canSubtractSellIn(final ItemAdapter itemAdapter) {
        return true;
    }

    @Override
    protected int getQualityFactor(final boolean isExpired, final ItemAdapter itemAdapter) {
        return isExpired ? 2 : 1;
    }

    @Override
    protected boolean canIncreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return true;
    }

    @Override
    protected boolean canDecreaseQuality(boolean isExpired, final ItemAdapter itemAdapter) {
        return false;
    }
}
