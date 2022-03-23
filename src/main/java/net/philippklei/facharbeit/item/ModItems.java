package net.philippklei.facharbeit.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.philippklei.facharbeit.FacharbeitMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    // Hier wird das Item erstellt und es bekommt einen Namen sowie eine Itemklasse im Spiel (hier MISC).
    public static final Item TITANUM_INGOT = registerItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    // Jedes Item erbt von der Standardklasse ITEM von Minecraft.
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FacharbeitMod.MOD_ID, name), item);
    }

    // Diese Methode "registriert" die Items damit sie auch ins Spiel geladen werden koennen.
    public static void registerModItems(){
        System.out.println("Registriere Mod-Items fuer " + FacharbeitMod.MOD_ID);
    }
}
