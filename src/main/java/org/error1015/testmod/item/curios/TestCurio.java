package org.error1015.testmod.item.curios;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.camellialib.common.item.ItemWithTooltip;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class TestCurio extends ItemWithTooltip implements ICurioItem {
    public TestCurio(Properties properties) {
        super(properties);
    }

    public TestCurio() {
        this(new Properties().stacksTo(1));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        MobEffect effect = MobEffects.WITHER;
        if (player.hasEffect(effect)) player.removeEffect(effect);
    }

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        Player player = (Player) slotContext.entity();
        return !player.isCreative();
    }
}