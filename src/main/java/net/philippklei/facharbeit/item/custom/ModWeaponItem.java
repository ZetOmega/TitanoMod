package net.philippklei.facharbeit.item.custom;


import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ModWeaponItem extends SwordItem {
    public ModWeaponItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}