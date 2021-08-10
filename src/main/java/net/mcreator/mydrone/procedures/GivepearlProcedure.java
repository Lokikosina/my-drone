package net.mcreator.mydrone.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mydrone.MyDroneModElements;
import net.mcreator.mydrone.MyDroneMod;

import java.util.Map;

@MyDroneModElements.ModElement.Tag
public class GivepearlProcedure extends MyDroneModElements.ModElement {
	public GivepearlProcedure(MyDroneModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MyDroneMod.LOGGER.warn("Failed to load dependency entity for procedure Givepearl!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.ENDER_PEARL, (int) (1)))
				: false))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.ENDER_PEARL, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
