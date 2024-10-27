package org.error1015.testmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static org.error1015.testmod.CreativeTab.CREATIVE_MODE_TABS;
import static org.error1015.testmod.block.BlockRegistry.BLOCKS;
import static org.error1015.testmod.item.ItemRegistry.ITEMS;

@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}