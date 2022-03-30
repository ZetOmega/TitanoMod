package net.philippklei.titano.item.custom;


import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

// Hier wird die Klasse ModWeaponItem initialisert und der Konstruktor wird aufgerufen.
public class ModWeaponItem extends SwordItem {
    public ModWeaponItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}