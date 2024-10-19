package org.error1015.testmod.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Inject(at = @At("HEAD"), method = "getHurtSound", cancellable = true)
    public void playerHurtSound(CallbackInfoReturnable<SoundEvent> cir) {
        cir.setReturnValue(SoundEvents.PLAYER_LEVELUP);
        cir.cancel();
    }
}