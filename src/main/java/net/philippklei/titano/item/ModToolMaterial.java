package net.philippklei.titano.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

// Hier wird das Enum ModToolMaterial mit ToolMaterial erstellt. Außerdem werden einige Eigenschaften festgelegt.
public enum ModToolMaterial implements ToolMaterial {
    TITANIUM(MiningLevels.DIAMOND, 5000, 40F, 3.5F, 25, () ->
            Ingredient.ofItems(ModItems.TITANIUM_INGOT));

    // Hier werden Variablen für die Eigenschaften erstellt.
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    // Hier werden dden Eigenschaftsvariablen Werte uebergeben.
    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                            int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    // Hier fangen die Getter an.
    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
