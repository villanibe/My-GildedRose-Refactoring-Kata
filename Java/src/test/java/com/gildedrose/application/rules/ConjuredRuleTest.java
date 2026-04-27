package com.gildedrose.application.rules;

import com.gildedrose.domain.Item;
import com.gildedrose.application.ItemAdapter;
import com.gildedrose.domain.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredRuleTest {

    @Test
    void conjuredItemQualityDecreasesByTwo() {
        //given
        Item testItem = new Item("Conjured Mana Cake", 3, 6);
        ItemAdapter itemAdapter = new ItemAdapter(ItemType.CONJURED, testItem);
        ConjuredRule conjuredRule = new ConjuredRule();

        //when
        conjuredRule.processItem(itemAdapter);

        //then
        assertEquals(2, itemAdapter.getItem().sellIn);
        assertEquals(4, itemAdapter.getItem().quality);
    }

    @Test
    void conjuredItemQualityDecreasesByFourWhenExpired() {
        //given
        Item testItem = new Item("Conjured Mana Cake", 0, 6);
        ItemAdapter itemAdapter = new ItemAdapter(ItemType.CONJURED, testItem);
        ConjuredRule conjuredRule = new ConjuredRule();

        //when
        conjuredRule.processItem(itemAdapter);

        //then
        assertEquals(-1, itemAdapter.getItem().sellIn);
        assertEquals(2, itemAdapter.getItem().quality);
    }
}
