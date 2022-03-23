package net.philippklei.facharbeit;

import net.fabricmc.api.ModInitializer;
import net.philippklei.facharbeit.block.ModBlocks;
import net.philippklei.facharbeit.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacharbeitMod implements ModInitializer {
    public static final String MOD_ID = "facharbeit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Hier in der Hauptklasse der Mod werden die wichtigsten funktion aufgerufen um alles zu laden.
    @Override
    public void onInitialize() {
        // Hier werden alle Items und Blöcke registriert damit sie im Spiel erscheinen koennen.
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
