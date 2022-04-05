package net.philippklei.titano.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.philippklei.titano.TitanoMod;
import net.philippklei.titano.item.ModItemGroups;


public class ModBlocks {

    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(16.0f).requiresTool()), ModItemGroups.TITANO);

    public static final Block END_TITANIUM_ORE= registerBlock("end_titanium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(32.0f).requiresTool()), ModItemGroups.TITANO);

    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(28.0f).requiresTool()), ModItemGroups.TITANO);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TitanoMod.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(TitanoMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        System.out.println("Registriere Mod-Bloecke fuer " + TitanoMod.MOD_ID);
    }
}