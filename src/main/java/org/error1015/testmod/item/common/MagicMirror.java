package org.error1015.testmod.item.common;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.hiedacamellia.camellialib.common.item.ItemWithTooltip;
import org.jetbrains.annotations.NotNull;

public class MagicMirror extends ItemWithTooltip {
    public MagicMirror(Properties pProperties) {
        super(pProperties);
    }

    public MagicMirror() {
        this(new Properties().stacksTo(1));
    }

    /**
     * 使用魔镜返回重生点
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (!pLevel.isClientSide && pUsedHand == InteractionHand.MAIN_HAND) {
            if (pPlayer instanceof ServerPlayer player) {
                BlockPos respawnPosition = player.getRespawnPosition();
                if (pLevel.dimension() == Level.OVERWORLD) {
                    if (respawnPosition != null) {
                        player.teleportTo(respawnPosition.getX(), respawnPosition.getY() + 0.5, respawnPosition.getZ());
                        player.displayClientMessage(Component.translatable("message.testmod.magic_mirror_succeed"), true);
                        pPlayer.getCooldowns().addCooldown(this, 20 * 10);

                    }
                } else player.displayClientMessage(Component.translatable("message.testmod.magic_mirror_failed"), true);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public @NotNull Rarity getRarity(@NotNull ItemStack pStack) {
        return Rarity.EPIC;
    }
}
