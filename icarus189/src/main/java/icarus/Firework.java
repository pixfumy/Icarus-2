package icarus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class Firework extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		// (1, y, 0) = east
		// (-1, y, 0) = west
		// (0, y, 1) = south
		// (0, y, -1) = north
		if (!player.onGround && !player.isInWater()){
			--item.stackSize;		
			double x = -2 * Math.sin(Math.toRadians(player.rotationYaw));
			double y = -2 * Math.sin(Math.toRadians(player.rotationPitch));
			double z = 2 * Math.cos(Math.toRadians(player.rotationYaw));
			player.setVelocity(x,y,z);
			world.playSoundAtEntity(player, "icarus:launch", 10, 1);
		}
		return item;
	}
}