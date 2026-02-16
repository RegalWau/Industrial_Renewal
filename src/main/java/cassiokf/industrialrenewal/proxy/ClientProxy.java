package cassiokf.industrialrenewal.proxy;

import cassiokf.industrialrenewal.References;
import cassiokf.industrialrenewal.handlers.IRSoundHandler;
import cassiokf.industrialrenewal.init.RenderHandler;
import cassiokf.industrialrenewal.model.ModelLoaderCustom;
import cassiokf.industrialrenewal.tesr.TESRBatteryBank;
import cassiokf.industrialrenewal.tesr.TESRBulkConveyor;
import cassiokf.industrialrenewal.tesr.TESRCableGauge;
import cassiokf.industrialrenewal.tesr.TESRCargoLoader;
import cassiokf.industrialrenewal.tesr.TESRDamGenerator;
import cassiokf.industrialrenewal.tesr.TESRDamTurbine;
import cassiokf.industrialrenewal.tesr.TESREnergyLevelGauge;
import cassiokf.industrialrenewal.tesr.TESRFirstAidKit;
import cassiokf.industrialrenewal.tesr.TESRFluidLoader;
import cassiokf.industrialrenewal.tesr.TESRFluidTank;
import cassiokf.industrialrenewal.tesr.TESRGauge;
import cassiokf.industrialrenewal.tesr.TESRIndBatteryBank;
import cassiokf.industrialrenewal.tesr.TESRLathe;
import cassiokf.industrialrenewal.tesr.TESRMining;
import cassiokf.industrialrenewal.tesr.TESRPipeGauge;
import cassiokf.industrialrenewal.tesr.TESRPortableGenerator;
import cassiokf.industrialrenewal.tesr.TESRRecordPlayer;
import cassiokf.industrialrenewal.tesr.TESRSmallWindTurbine;
import cassiokf.industrialrenewal.tesr.TESRSolarPanelFrame;
import cassiokf.industrialrenewal.tesr.TESRSteamBoiler;
import cassiokf.industrialrenewal.tesr.TESRSteamTurbine;
import cassiokf.industrialrenewal.tesr.TESRStorage;
import cassiokf.industrialrenewal.tesr.TESRTransformerHV;
import cassiokf.industrialrenewal.tesr.TESRWindTurbinePillar;
import cassiokf.industrialrenewal.tesr.TESRWire;
import cassiokf.industrialrenewal.tileentity.TEFluidTank;
import cassiokf.industrialrenewal.tileentity.TEStorage;
import cassiokf.industrialrenewal.tileentity.TileEntityBatteryBank;
import cassiokf.industrialrenewal.tileentity.TileEntityBulkConveyor;
import cassiokf.industrialrenewal.tileentity.TileEntityDamGenerator;
import cassiokf.industrialrenewal.tileentity.TileEntityDamTurbine;
import cassiokf.industrialrenewal.tileentity.TileEntityEnergyLevel;
import cassiokf.industrialrenewal.tileentity.TileEntityFirstAidKit;
import cassiokf.industrialrenewal.tileentity.TileEntityGauge;
import cassiokf.industrialrenewal.tileentity.TileEntityHVConnectorBase;
import cassiokf.industrialrenewal.tileentity.TileEntityMining;
import cassiokf.industrialrenewal.tileentity.TileEntityPortableGenerator;
import cassiokf.industrialrenewal.tileentity.TileEntityRecordPlayer;
import cassiokf.industrialrenewal.tileentity.TileEntitySmallWindTurbine;
import cassiokf.industrialrenewal.tileentity.TileEntitySolarPanelFrame;
import cassiokf.industrialrenewal.tileentity.TileEntitySteamBoiler;
import cassiokf.industrialrenewal.tileentity.TileEntitySteamTurbine;
import cassiokf.industrialrenewal.tileentity.TileEntityTransformerHV;
import cassiokf.industrialrenewal.tileentity.TileEntityWindTurbinePillar;
import cassiokf.industrialrenewal.tileentity.machines.TEIndustrialBatteryBank;
import cassiokf.industrialrenewal.tileentity.machines.TELathe;
import cassiokf.industrialrenewal.tileentity.railroad.TileEntityCargoLoader;
import cassiokf.industrialrenewal.tileentity.railroad.TileEntityFluidLoader;
import cassiokf.industrialrenewal.tileentity.tubes.TileEntityEnergyCableGauge;
import cassiokf.industrialrenewal.tileentity.tubes.TileEntityFluidPipeGauge;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{

    @Override
    public void Init()
    {
        super.Init();
        MinecraftForge.EVENT_BUS.register(IRSoundHandler.class);
    }

    @Override
    public void preInit()
    {
        //IRConfig.clientPreInit();
        RenderHandler.registerEntitiesRender();
        RenderHandler.registerCustomMeshesAndStates();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(References.MODID + ":" + id, "inventory"));
    }

    @Override
    public void registerRenderers()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirstAidKit.class, new TESRFirstAidKit());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGauge.class, new TESRGauge());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBatteryBank.class, new TESRBatteryBank());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamBoiler.class, new TESRSteamBoiler());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamTurbine.class, new TESRSteamTurbine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallWindTurbine.class, new TESRSmallWindTurbine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindTurbinePillar.class, new TESRWindTurbinePillar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBulkConveyor.class, new TESRBulkConveyor());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMining.class, new TESRMining());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarPanelFrame.class, new TESRSolarPanelFrame());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidPipeGauge.class, new TESRPipeGauge());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCableGauge.class, new TESRCableGauge());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyLevel.class, new TESREnergyLevelGauge());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidLoader.class, new TESRFluidLoader());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCargoLoader.class, new TESRCargoLoader());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHVConnectorBase.class, new TESRWire());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransformerHV.class, new TESRTransformerHV());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDamTurbine.class, new TESRDamTurbine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDamGenerator.class, new TESRDamGenerator());
        ClientRegistry.bindTileEntitySpecialRenderer(TELathe.class, new TESRLathe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPortableGenerator.class, new TESRPortableGenerator());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRecordPlayer.class, new TESRRecordPlayer());
        ClientRegistry.bindTileEntitySpecialRenderer(TEFluidTank.class, new TESRFluidTank());
        ClientRegistry.bindTileEntitySpecialRenderer(TEIndustrialBatteryBank.class, new TESRIndBatteryBank());
        ClientRegistry.bindTileEntitySpecialRenderer(TEStorage.class, new TESRStorage());

        ModelLoaderRegistry.registerLoader(new ModelLoaderCustom());
    }
}