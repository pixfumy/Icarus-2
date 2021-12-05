package icarus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="icarus", name="Icarus", version="1.0")
public class Icarus {
	public static Item fireWork;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) throws NoSuchMethodException, SecurityException {
		fireWork = new Firework().setUnlocalizedName("firework");
		GameRegistry.registerItem(fireWork, fireWork.getUnlocalizedName().substring(5));
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				fireWork, 0, new ModelResourceLocation("icarus:firework", "inventory"));
		MinecraftForge.EVENT_BUS.register(OnWorldLoadEvent.instance);
	}
}