package org.error1015.testmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.error1015.testmod.TestMod;
import org.error1015.testmod.item.curios.TestCurio;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<TestCurio> TEST_CURIO = ITEMS.register("test_curio", TestCurio::new);
}
