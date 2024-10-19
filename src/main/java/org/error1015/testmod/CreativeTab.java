package org.error1015.testmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            // .icon(() -> TestMod.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // output.accept();
            }).build());
}
