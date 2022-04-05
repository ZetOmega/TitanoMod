package net.philippklei.titano.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.philippklei.titano.TitanoMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.philippklei.titano.item.custom.ModPickaxeItem;
import net.philippklei.titano.item.custom.ModWeaponItem;
import net.philippklei.titano.item.custom.TitaniumFinderItem;


public class ModItems {

    public static final Item TITANIUM_MASHER = registerItem("titanium_masher",
            new ModWeaponItem(ModToolMaterial.TITANIUM, 21, -3.5f,
                    new FabricItemSettings().group(ModItemGroups.TITANO)));

    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe",
            new ModPickaxeItem(ModToolMaterial.TITANIUM, 1, -2f,
                    new FabricItemSettings().group(ModItemGroups.TITANO)));

    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.TITANO)));

    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget",
            new Item(new FabricItemSettings().group(ModItemGroups.TITANO)));

    public static final Item RAW_TITANIUM = registerItem("raw_titanium",
            new Item(new FabricItemSettings().group(ModItemGroups.TITANO)));

    public static final Item TITANIUM_FINDER= registerItem("titanium_finder",
            new TitaniumFinderItem(new FabricItemSettings().group(ModItemGroups.TITANO).maxDamage(420)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(TitanoMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("Registriere Mod-Items fuer " + TitanoMod.MOD_ID);
    }
}