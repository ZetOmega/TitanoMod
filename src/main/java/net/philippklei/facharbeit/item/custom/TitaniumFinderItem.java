package net.philippklei.facharbeit.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.philippklei.facharbeit.block.ModBlocks;

public class TitaniumFinderItem extends Item {
    public TitaniumFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionUsed = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean blockFound = false;

            for(int i = 0; i <= positionUsed.getY(); i++) {
                Block blockBelow = context.getWorld().getBlockState(positionUsed.down(i)).getBlock();

                if(isTitaniumOre(blockBelow)) {
                    gebeKoordinatenAus(positionUsed, player, blockBelow);
                    blockFound = true;
                    break;
                }
            }

            if(!blockFound) {
                player.sendMessage(new TranslatableText("item.facharbeit.titanium_finder.no_titanium"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void gebeKoordinatenAus(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(new LiteralText("Titanium Erz bei " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")" + " gefunden"), false);
    }

    private boolean isTitaniumOre(Block block) {
        return block == ModBlocks.END_TITANIUM_ORE;
    }
}