package net.mehvahdjukaar.supplementaries.setup;

import net.mehvahdjukaar.supplementaries.client.ClockBlockTileRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(final FMLClientSetupEvent event){

        //planter
        RenderTypeLookup.setRenderLayer(Registry.PLANTER.get(), RenderType.getCutout());
        //clock
        RenderTypeLookup.setRenderLayer(Registry.CLOCK_BLOCK.get(), RenderType.getCutout());
        ClientRegistry.bindTileEntityRenderer(Registry.CLOCK_BLOCK_TILE.get(), ClockBlockTileRenderer::new);






    }


}