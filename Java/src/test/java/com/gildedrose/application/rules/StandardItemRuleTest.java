package com.gildedrose.application.rules;

import com.gildedrose.domain.Item;
import com.gildedrose.application.ItemAdapter;
import com.gildedrose.domain.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardItemRuleTest {

    @Test
    void standardItemQualityDecreasesByTwoWhenExpired() {
        //given
        Item testItem = new Item("standard item", 0, 3);
        ItemAdapter itemAdapter = new ItemAdapter(ItemType.STANDARD, testItem);
        StandardItemRule standardItemRule = new StandardItemRule();

        //when
        standardItemRule.processItem(itemAdapter);

        //then
        assertEquals(-1, itemAdapter.getItem().sellIn);
        assertEquals(1, itemAdapter.getItem().quality);
    }

    @Test
    void qualityOfAnItemIsNeverNegative() {
        //given
        Item testItem = new Item("standard item", 0, 0);
        ItemAdapter itemAdapter = new ItemAdapter(ItemType.STANDARD, testItem);
        StandardItemRule standardItemRule = new StandardItemRule();

        //when
        standardItemRule.processItem(itemAdapter);

        //then
        assertEquals(-1, itemAdapter.getItem().sellIn);
        assertEquals(0, itemAdapter.getItem().quality);
    }

    @Test
    void standardItemQualityDecreasesByOne() {
        //given
        Item testItem = new Item("standard item", 5, 2);
        ItemAdapter itemAdapter = new ItemAdapter(ItemType.STANDARD, testItem);
        StandardItemRule standardItemRule = new StandardItemRule();

        //when
        standardItemRule.processItem(itemAdapter);

        //then
        assertEquals(4, itemAdapter.getItem().sellIn);
        assertEquals(1, itemAdapter.getItem().quality);
    }
}
