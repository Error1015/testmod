package org.error1015.testmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.error1015.testmod.item.ItemRegistry;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("createivetab.testmod"))
            .icon(() -> ItemRegistry.MAGIC_MIRROR.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.TEST_CURIO.get());
                output.accept(ItemRegistry.MAGIC_MIRROR.get());
            }).build());
}
