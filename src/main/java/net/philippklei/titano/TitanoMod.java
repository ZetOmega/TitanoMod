package net.philippklei.titano;

import net.fabricmc.api.ModInitializer;
import net.philippklei.titano.block.ModBlocks;
import net.philippklei.titano.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TitanoMod implements ModInitializer {
    public static final String MOD_ID = "titano";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}