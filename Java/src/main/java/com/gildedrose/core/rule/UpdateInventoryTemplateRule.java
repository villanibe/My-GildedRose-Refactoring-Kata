package com.gildedrose.core.rule;

import com.gildedrose.domain.item.ItemAdapter;

public abstract class UpdateInventoryTemplateRule {

    final int MINIMUM_QUALITY = 0;
    final int MAXIMUM_QUALITY = 50;
    final int SELL_IN_EXPIRED = 0;
    final int SELL_IN_UNIT = 1;

    public final void processItem(final ItemAdapter itemAdapter) {
        preProcess(itemAdapter);

        boolean isExpired = isExpired(itemAdapter);
        int qualityFactor = getQualityFactor(isExpired, itemAdapter);

        if (isExpired) {
            onExpired(itemAdapter);
        }

        if (canIncreaseQuality(isExpired, itemAdapter)) {
            increaseQuality(itemAdapter, qualityFactor);
        }

        if (canSubtractSellIn(itemAdapter)) {
            subtractSellIn(itemAdapter);
        }

        if (canDecreaseQuality(isExpired, itemAdapter)) {
            decreaseQuality(itemAdapter, qualityFactor);
        }

        postProcess(itemAdapter);
    }

    protected abstract boolean canSubtractSellIn(final ItemAdapter itemAdapter);
    protected abstract int getQualityFactor(final boolean isExpired, final ItemAdapter itemAdapter);
    protected abstract boolean canIncreaseQuality(final boolean isExpired, final ItemAdapter itemAdapter);
    protected abstract boolean canDecreaseQuality(final boolean isExpired, final ItemAdapter itemAdapter);


    protected void onExpired(final ItemAdapter itemAdapter) {
        // default: do nothing
    }

    protected void preProcess(final ItemAdapter itemAdapter) {
        // default: do nothing
    }

    protected void postProcess(final ItemAdapter itemAdapter) {
        // default: do nothing
    }

    private void subtractSellIn(final ItemAdapter itemAdapter) {
        itemAdapter.getItem().sellIn -= SELL_IN_UNIT;
    }

    private boolean isExpired(final ItemAdapter itemAdapter) {
        return itemAdapter.getItem().sellIn <= SELL_IN_EXPIRED;
    }

    private void increaseQuality(final ItemAdapter itemAdapter, final int qualityFactor) {
        int increasedQuality = itemAdapter.getItem().quality + qualityFactor;
        itemAdapter.getItem().quality = Math.min(increasedQuality, MAXIMUM_QUALITY);
    }

    private void decreaseQuality(final ItemAdapter itemAdapter, final int qualityFactor) {
        int decreasedQuality = itemAdapter.getItem().quality - qualityFactor;
        itemAdapter.getItem().quality = Math.max(decreasedQuality, MINIMUM_QUALITY);
    }
}
