package net.philippklei.facharbeit.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.philippklei.facharbeit.FacharbeitMod;

public class ModItemGroups {

    //Hier wird eine eigene ItemGruppe erstellt welche den neuen Items zugewiesen werden kann.
    public static final ItemGroup FACHARBEIT = FabricItemGroupBuilder.build(new Identifier(FacharbeitMod.MOD_ID, "facharbeit"),
            () -> new ItemStack(ModItems.TITANUM_INGOT));
}
