package org.error1015.testmod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public abstract class SwordMixin {
    @Inject(at = @At("HEAD"), method = "canAttackBlock", cancellable = true)
    public void test(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
