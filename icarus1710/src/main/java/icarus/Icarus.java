package icarus;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="icarus", name="Icarus", version="1.0")
public class Icarus {
	public static Item fireWork;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		fireWork = new Firework().setUnlocalizedName("Firework").setTextureName("icarus:firework");
		GameRegistry.registerItem(fireWork, fireWork.getUnlocalizedName().substring(5));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(OnWorldLoadEvent.instance);
	}
}