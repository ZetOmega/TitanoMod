package net.philippklei.titano.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.realms.gui.screen.RealmsCreateRealmScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.philippklei.titano.block.ModBlocks;
import net.philippklei.titano.utils.BlockUtils;
import net.philippklei.titano.utils.PlayerUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TitaniumFinderItem extends Item {
    public TitaniumFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionUsed = context.getBlockPos();
            getChecks(context, context.getPlayer(), positionUsed);
        }
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }


    private void getChecks(ItemUsageContext context, PlayerEntity player, BlockPos currentBlockPos) {

        final int X = currentBlockPos.getX();
        final int Y = currentBlockPos.getY();
        final int Z = currentBlockPos.getZ();

        final int WORLD_MIN_HEIGHT = context.getWorld().getBottomY();
        final int WORLD_MAX_HEIGHT = context.getWorld().getTopY();

        final int Y_BOTTOM_OFFSET = Y < 0
                ? WORLD_MIN_HEIGHT - Y
                : Y - WORLD_MIN_HEIGHT;

        final int Y_TOP_OFFSET = WORLD_MAX_HEIGHT - Y;

        final int X_LOWER_RADIUS = 1;
        final int Y_LOWER_RADIUS = Y_TOP_OFFSET;
        final int Z_LOWER_RADIUS = 1;

        final int X_UPPER_RADIUS = 1;
        final int Y_UPPER_RADIUS = Y_BOTTOM_OFFSET;
        final int Z_UPPER_RADIUS = 1;

        for(int x = X - X_LOWER_RADIUS; x <= X + X_UPPER_RADIUS; x++) {
            for(int y = Y - Y_LOWER_RADIUS; y <= Y + Y_UPPER_RADIUS; y++) {
                for(int z = Z - Z_LOWER_RADIUS; z <= Z + Z_UPPER_RADIUS; z++) {
                    BlockPos checkedBlockPos = new BlockPos(x, y, z);
                    if(BlockUtils.isOfType(context.getWorld().getBlockState(checkedBlockPos).getBlock(), ModBlocks.END_TITANIUM_ORE)) {
                        outputCoordinates(checkedBlockPos, player);
                    }
                }
            }
        }
    }

    private void outputCoordinates(BlockPos blockPos, PlayerEntity player) {
        String message = "Found at: {" +
                blockPos.getX() + ", " +
                blockPos.getY() + ", " +
                blockPos.getZ() + "}";
        PlayerUtils.sendMessage(player, message);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.titano.titanium_finder.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.titano.titanium_finder.tooltip"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
