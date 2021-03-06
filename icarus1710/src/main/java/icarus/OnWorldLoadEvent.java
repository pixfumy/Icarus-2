package icarus;
import java.lang.reflect.Field;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class OnWorldLoadEvent {
	public static final OnWorldLoadEvent instance = new OnWorldLoadEvent();
	
    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent entityJoinWorldEvent) {
        Entity entity = entityJoinWorldEvent.entity;
        if (entity instanceof EntityPlayerMP && entity.worldObj.getWorldInfo().getWorldTotalTime() < 20) {
            EntityPlayerMP player = (EntityPlayerMP) entity;
            Item firework = GameData.getItemRegistry().getObject("icarus:Firework");
            ItemStack fireworkStack = new ItemStack(firework, 64);
            Item elytra = GameData.getItemRegistry().getObject("backlytra:elytra");
            elytra.setMaxDamage(69420);
            ItemStack elytraStack = new ItemStack(elytra);
            player.inventory.addItemStackToInventory(fireworkStack);
            player.inventory.armorInventory[2] = elytraStack;
        }
    }
}