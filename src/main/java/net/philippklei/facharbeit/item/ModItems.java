package net.philippklei.facharbeit.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.philippklei.facharbeit.FacharbeitMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.philippklei.facharbeit.item.custom.ModPickaxeItem;
import net.philippklei.facharbeit.item.custom.ModWeaponItem;
import net.philippklei.facharbeit.item.custom.TitaniumFinderItem;


public class ModItems {

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item TITANIUM_MASHER = registerItem("titanium_masher",
            new ModWeaponItem(ModToolMaterial.TITANIUM, 21, -3.5f,
                    new FabricItemSettings().group(ModItemGroups.FACHARBEIT)));

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe",
            new ModPickaxeItem(ModToolMaterial.TITANIUM, 1, -2f,
                    new FabricItemSettings().group(ModItemGroups.FACHARBEIT)));

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.FACHARBEIT)));

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget",
            new Item(new FabricItemSettings().group(ModItemGroups.FACHARBEIT)));

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item RAW_TITANIUM = registerItem("raw_titanium",
            new Item(new FabricItemSettings().group(ModItemGroups.FACHARBEIT)));

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier die eigens erstelle Klasse FACHARBEIT).
    public static final Item TITANIUM_FINDER= registerItem("titanium_finder",
            new TitaniumFinderItem(new FabricItemSettings().group(ModItemGroups.FACHARBEIT).maxDamage(420)));

    // Jedes Item erbt von der Standardklasse ITEM von Minecraft.
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FacharbeitMod.MOD_ID, name), item);
    }

    // Diese Methode "registriert" die Items damit sie auch ins Spiel geladen werden koennen.
    public static void registerModItems(){
        System.out.println("Registriere Mod-Items fuer " + FacharbeitMod.MOD_ID);
    }
}