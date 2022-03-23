package net.philippklei.facharbeit;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacharbeitMod implements ModInitializer {
    public static final String MOD_ID = "facharbeitmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {


        LOGGER.info("Hello Fabric world!");
    }
}
