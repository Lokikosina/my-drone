
package net.mcreator.mydrone.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.mydrone.MyDroneModElements;

@MyDroneModElements.ModElement.Tag
public class SonicEnchantment extends MyDroneModElements.ModElement {
	@ObjectHolder("my_drone:sonic")
	public static final Enchantment enchantment = null;
	public SonicEnchantment(MyDroneModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("sonic"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 50;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 100;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
