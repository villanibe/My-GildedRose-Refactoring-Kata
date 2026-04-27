package com.gildedrose.application.rules;

import com.gildedrose.core.UpdateInventoryTemplateRule;
import com.gildedrose.application.ItemAdapter;

public class ConjuredRule extends UpdateInventoryTemplateRule {

    @Override
    protected boolean canSubtractSellIn(ItemAdapter itemAdapter) {
        return true;
    }

    @Override
    protected int getQualityFactor(boolean isExpired, ItemAdapter itemAdapter) {
        return isExpired ? 4 : 2;
    }

    @Override
    protected boolean canIncreaseQuality(boolean isExpired, ItemAdapter itemAdapter) {
        return false;
    }

    @Override
    protected boolean canDecreaseQuality(boolean isExpired, ItemAdapter itemAdapter) {
        return true;
    }
}
