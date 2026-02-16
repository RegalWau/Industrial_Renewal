package cassiokf.industrialrenewal.init;

import cassiokf.industrialrenewal.References;
import cassiokf.industrialrenewal.entity.EntityCargoContainer;
import cassiokf.industrialrenewal.entity.EntityFlatCart;
import cassiokf.industrialrenewal.entity.EntityFluidContainer;
import cassiokf.industrialrenewal.entity.EntityHopperCart;
import cassiokf.industrialrenewal.entity.EntityLogCart;
import cassiokf.industrialrenewal.entity.EntityPassengerCar;
import cassiokf.industrialrenewal.entity.EntitySteamLocomotive;
import cassiokf.industrialrenewal.entity.EntityTenderBase;
import cassiokf.industrialrenewal.entity.render.RenderCargoContainer;
import cassiokf.industrialrenewal.entity.render.RenderFlatCart;
import cassiokf.industrialrenewal.entity.render.RenderFluidContainer;
import cassiokf.industrialrenewal.entity.render.RenderHopperCart;
import cassiokf.industrialrenewal.entity.render.RenderLogCart;
import cassiokf.industrialrenewal.entity.render.RenderPassengerCar;
import cassiokf.industrialrenewal.entity.render.RenderSteamLocomotive;
import cassiokf.industrialrenewal.entity.render.RenderTender;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{

    public static void registerEntitiesRender()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCargoContainer.class, RenderCargoContainer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFluidContainer.class, RenderFluidContainer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySteamLocomotive.class, RenderSteamLocomotive::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLogCart.class, RenderLogCart::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPassengerCar.class, RenderPassengerCar::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFlatCart.class, RenderFlatCart::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHopperCart.class, RenderHopperCart::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTenderBase.class, RenderTender::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityContainerShip.class, RenderContainerShip::new);
    }

    public static void registerCustomMeshesAndStates()
    {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.steamBlock), stack -> new ModelResourceLocation(References.MODID + ":steam", "fluid"));

        ModelLoader.setCustomStateMapper(ModBlocks.steamBlock, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(References.MODID + ":steam", "fluid");
            }
        });
    }
}
