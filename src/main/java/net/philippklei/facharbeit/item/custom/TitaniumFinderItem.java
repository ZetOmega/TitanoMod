package net.philippklei.facharbeit.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;

import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.philippklei.facharbeit.block.ModBlocks;

public class TitaniumFinderItem extends Item {
    public TitaniumFinderItem(Settings settings) {
        super(settings);
    }
    // Die Methode der useOnBlock() der Klasse Item wird von dem TitaniumFinder ueberschrieben um eigene funktionen einzufuegen.
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionUsed = context.getBlockPos();
            getRadius(context, context.getPlayer(), positionUsed);
        }
        // Hier wird das das Item nach seiner Nutzung beschaedigt.
        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    // Diese Methode untersucht in einem Radius um den Spieler herum ob ein Titanium Erz zwischen Hoehe 0 und 256 liegt
    private void getRadius(ItemUsageContext context, PlayerEntity player, BlockPos positionUsed){
        for(int i = 0; i <= 256; i++) {
            /*
            Diese If Abfrage fragt die 9 verschiedenen Blöcke um den Spieler ab. Wenn kein Erz gefunden wird, wird auf einer anderen Hoehe weitergesucht.
            Sobald ein Block gefunden wurde, wird er ausgegeben und die Methode wird beendet.
            */
            if (isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(1,-1,i)).getBlock())){
                outputCoordinates(positionUsed.add(1,-1,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(1,0,i)).getBlock())){
                outputCoordinates(positionUsed.add(1,0,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(1,1,i)).getBlock())){
                outputCoordinates(positionUsed.add(1,1,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(0,-1,0)).getBlock())){
                outputCoordinates(positionUsed.add(0,-1,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(0,0,i)).getBlock())){
                outputCoordinates(positionUsed.add(0,0,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(0,1,i)).getBlock())){
                outputCoordinates(positionUsed.add(0,1,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(-1,-1,i)).getBlock())){
                outputCoordinates(positionUsed.add(-1,-1,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(-1,0,i)).getBlock())){
                outputCoordinates(positionUsed.add(-1,0,i), player);
                break;
            }
            else if(isTitaniumOre(context.getWorld().getBlockState(context.getBlockPos().add(-1,0,i)).getBlock())){
                outputCoordinates(positionUsed.add(-1,0,i), player);
                break;
            }

        }
    }


    private void outputCoordinates(BlockPos blockPos, PlayerEntity player) {
        player.sendMessage(new LiteralText("Titanium Erz bei " +
                "(" + blockPos.getX() + ", " + blockPos.getZ() + ")" + " gefunden"), false);
    }

    // hier wird untersucht ob der mitgegebene Block ein Titanium Erz ist
    private boolean isTitaniumOre(Block block) {
        return block == ModBlocks.END_TITANIUM_ORE;
    }
}