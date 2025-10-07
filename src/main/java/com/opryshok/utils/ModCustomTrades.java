package com.opryshok.utils;

import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerWanderingTraderOffers(factories -> factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL, ((entity, random) ->
                new TradeOffer(new TradedItem(Items.EMERALD), new ItemStack(ModBlocks.LEMON_SAPLING_ITEM),
                        12, 3, 0.05f))));
    }
}
