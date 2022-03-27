package net.philippklei.titano.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.philippklei.titano.TitanoMod;

public class ModItemGroups {

    //Hier wird eine eigene ItemGruppe erstellt welche den neuen Items zugewiesen werden kann.
    public static final ItemGroup TITANO = FabricItemGroupBuilder.build(new Identifier(TitanoMod.MOD_ID, "titano"),
            () -> new ItemStack(ModItems.TITANIUM_INGOT));
}