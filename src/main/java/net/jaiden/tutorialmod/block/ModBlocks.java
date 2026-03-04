package net.jaiden.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jaiden.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK =
            registerBlock("pink_garnet_block",
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    //press shift twice then look at the blocks and click include non-project items(click on net.minecraft.block) --> there you can see all the setting every block has to give you some inspo
    public static final Block RAW_PINK_GARNET_BLOCK =
            registerBlock("raw_pink_garnet_block",
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_CLUSTER));

    private static Block registerBlock(String name, AbstractBlock.Settings settings) {

        RegistryKey<Block> key = RegistryKey.of(
                RegistryKeys.BLOCK,
                Identifier.of(TutorialMod.MOD_ID, name)
        );

        Block block = new Block(settings.registryKey(key));

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(TutorialMod.MOD_ID, name)
        );

        BlockItem item = new BlockItem(
                block,
                new Item.Settings().registryKey(key)
        );

        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}

//make a function for block (public static Final Block ...)
//add to group events listed right above
//add translation to en_us.json
//copy existing json files and slightly modify (block, blockstates, item[both])
// add pngs to texture