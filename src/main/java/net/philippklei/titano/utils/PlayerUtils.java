package net.philippklei.titano.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class PlayerUtils {
    public static void sendMessage(PlayerEntity player, String message) {
        player.sendMessage(new LiteralText(message), false);
    }

    public static void sendMessage(PlayerEntity player, TranslatableText message) {
        player.sendMessage(message, false);
    }
}
