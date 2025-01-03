package net.partlicloudi.nftutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partlicloudi.nftutorialmod.TutorialMod;
import net.partlicloudi.nftutorialmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> RUBY_ITEMS_TAB = CREATIVE_MODE_TAB.register("ruby_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.POLISHED_RUBY.get()))
                    .title(Component.translatable("creativetab.nftutorialmod.ruby_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.POLISHED_RUBY);
                    }).build());


    public static final Supplier<CreativeModeTab> RUBY_BLOCKS_TAB = CREATIVE_MODE_TAB.register("ruby_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ruby_items_tab"))
                    .title(Component.translatable("creativetab.nftutorialmod.ruby_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModBlocks.RUBY_NETHER_ORE);
                        output.accept(ModBlocks.RUBY_END_STONE_ORE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
