package net.minecraft.src;

import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Plasmacraft.EntityAcid;
import net.minecraft.src.Plasmacraft.EntityAcidGrenade;
import net.minecraft.src.Plasmacraft.EntityAcidTNTPrimed;
import net.minecraft.src.Plasmacraft.EntityCausticBoat;
import net.minecraft.src.Plasmacraft.EntityCryoBlast;
import net.minecraft.src.Plasmacraft.EntityLaser;
import net.minecraft.src.Plasmacraft.EntityLaserShotgun;
import net.minecraft.src.Plasmacraft.EntityMutantCow;
import net.minecraft.src.Plasmacraft.EntityPlasma;
import net.minecraft.src.Plasmacraft.EntityRailGun;
import net.minecraft.src.Plasmacraft.GuiPlasmaBench;
import net.minecraft.src.Plasmacraft.PCClientProxy;
import net.minecraft.src.Plasmacraft.PlasmaCraftCore;
import net.minecraft.src.Plasmacraft.RenderAcid;
import net.minecraft.src.Plasmacraft.RenderAcidGrenade;
import net.minecraft.src.Plasmacraft.RenderAcidTNTPrimed;
import net.minecraft.src.Plasmacraft.RenderCausticBoat;
import net.minecraft.src.Plasmacraft.RenderCryoBlast;
import net.minecraft.src.Plasmacraft.RenderLaser;
import net.minecraft.src.Plasmacraft.RenderLaserShotgun;
import net.minecraft.src.Plasmacraft.RenderPlasma;
import net.minecraft.src.Plasmacraft.RenderRailGun;
import net.minecraft.src.Plasmacraft.TextureFrameAnimFX;
import net.minecraft.src.Plasmacraft.TextureTintedFlowFX;
import net.minecraft.src.Plasmacraft.TextureTintedStillFX;
import net.minecraft.src.Plasmacraft.TileEntityPlasmaBench;
import net.minecraft.src.forge.MinecraftForgeClient;

public class mod_PlasmaCraft extends BaseModMp
{
    private static mod_PlasmaCraft instance;
	public int causticRenderID;

    public String getVersion()
    {
        return PlasmaCraftCore.Version();
    }
    
    public mod_PlasmaCraft()
    {
    }

    public void load()
    {
        PlasmaCraftCore.proxy = new PCClientProxy();
        ModLoaderMp.Init();
        instance = this;
        causticRenderID = ModLoader.getUniqueBlockModelID(instance, false);
        PlasmaCraftCore.init(causticRenderID);

        ModLoaderMp.RegisterGUI(this, 159);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityLaser.class, 160);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityLaserShotgun.class, 161);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityPlasma.class, 162);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityRailGun.class, 163);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityAcid.class, 164);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityAcidTNTPrimed.class, 165);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityAcidGrenade.class, 166);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityCryoBlast.class, 167);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityCausticBoat.class, 168);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityAcidTNTPrimed.class, 169);
        ModLoaderMp.RegisterNetClientHandlerEntity(EntityMutantCow.class, 170);

        ModLoader.AddName(PlasmaCraftCore.cryoniteStill, "Cryonite (Still)");
        ModLoader.AddName(PlasmaCraftCore.cryoniteMoving, "Cryonite (Moving)");
        ModLoader.AddName(PlasmaCraftCore.acidMoving, "Acid (Moving)");
        ModLoader.AddName(PlasmaCraftCore.acidStill, "Acid (Still)");
        ModLoader.AddName(PlasmaCraftCore.plutoniumMoving, "Plutonium (Moving)");
        ModLoader.AddName(PlasmaCraftCore.plutoniumStill, "Plutonium (Still)");
        ModLoader.AddName(PlasmaCraftCore.radioniteMoving, "Radionite (Moving)");
        ModLoader.AddName(PlasmaCraftCore.radioniteStill, "Radionite (Still)");
        ModLoader.AddName(PlasmaCraftCore.netherflowMoving, "Netherflow (Moving)");
        ModLoader.AddName(PlasmaCraftCore.netherflowStill, "Netherflow (Still)");
        ModLoader.AddName(PlasmaCraftCore.neptuniumMoving, "Neptunium (Moving)");
        ModLoader.AddName(PlasmaCraftCore.neptuniumStill, "Neptunium (Still)");
        ModLoader.AddName(PlasmaCraftCore.obsidiumMoving, "Obsidium (Moving)");
        ModLoader.AddName(PlasmaCraftCore.obsidiumStill, "Obsidium (Still)");
        ModLoader.AddName(PlasmaCraftCore.uraniumMoving, "Uranium (Moving)");
        ModLoader.AddName(PlasmaCraftCore.uraniumStill, "Uranium (Still)");
        ModLoader.AddName(PlasmaCraftCore.oreUranium, "Uranium Ore");
        ModLoader.AddName(PlasmaCraftCore.frozenCryonite, "Frozen Cryonite");
        ModLoader.AddName(PlasmaCraftCore.glowCloth1, "Green Glowcloth");
        ModLoader.AddName(PlasmaCraftCore.glowCloth2, "Purple Glowcloth");
        ModLoader.AddName(PlasmaCraftCore.acidGrenade, "Acid Grenade");
        ModLoader.AddName(PlasmaCraftCore.orePlutonium, "Plutonium Ore");
        ModLoader.AddName(PlasmaCraftCore.oreRadionite, "Radionite Ore");
        ModLoader.AddName(PlasmaCraftCore.oreNeptunium, "Neptunium Ore");
        ModLoader.AddName(PlasmaCraftCore.oreObsidium, "Obsidium Ore");
        ModLoader.AddName(PlasmaCraftCore.reinforcedGlass, "Reinforced Glass");
        ModLoader.AddName(PlasmaCraftCore.plasmificatorIdle, "Plasmificator");
        ModLoader.AddName(PlasmaCraftCore.plasmificatorActive, "Plasmificator");
        ModLoader.AddName(PlasmaCraftCore.acidHot, "Acidic Barrier");
        ModLoader.AddName(PlasmaCraftCore.acidTnt, "Acidic TNT");
        ModLoader.AddName(PlasmaCraftCore.ingotPlutonium, "Plutonium Ingot");
        ModLoader.AddName(PlasmaCraftCore.ingotRadionite, "Radionite Ingot");
        ModLoader.AddName(PlasmaCraftCore.energyCell, "Energy Cell");
        ModLoader.AddName(PlasmaCraftCore.beamSplitter, "Rifle Beam Splitter");
        ModLoader.AddName(PlasmaCraftCore.BatteryEmpty, "Caustic Battery: Empty");
        ModLoader.AddName(PlasmaCraftCore.ThermoPellet, "Thermonuclear Pellet");
        ModLoader.AddName(PlasmaCraftCore.BatteryCryo, "Cryo Battery");
        ModLoader.AddName(PlasmaCraftCore.BatteryCharged, "Caustic Battery: Charged");
        ModLoader.AddName(PlasmaCraftCore.BatteryOvercharged, "Caustic Battery: Overcharged");
        ModLoader.AddName(PlasmaCraftCore.BatteryPlasma, "Caustic Battery: Plasma");
        ModLoader.AddName(PlasmaCraftCore.ingotNeptunium, "Neptunium Ingot");
        ModLoader.AddName(PlasmaCraftCore.ingotObsidium, "Obsidium Ingot");
        ModLoader.AddName(PlasmaCraftCore.ingotCryonite, "Cryonite Ingot");
        ModLoader.AddName(PlasmaCraftCore.ingotUranium, "Uranium Ingot");
        ModLoader.AddName(PlasmaCraftCore.ingotNetherflow, "Netherflow Ingot");
        ModLoader.AddName(PlasmaCraftCore.goopPlutonium, "Plutonium Goop");
        ModLoader.AddName(PlasmaCraftCore.goopRadionite, "Radionite Goop");
        ModLoader.AddName(PlasmaCraftCore.goopNeptunium, "Neptunium Goop");
        ModLoader.AddName(PlasmaCraftCore.goopNetherflow, "Netherflow Goop");
        ModLoader.AddName(PlasmaCraftCore.goopObsidium, "Obsidium Goop");
        ModLoader.AddName(PlasmaCraftCore.goopCryonite, "Cryonite Goop");
        ModLoader.AddName(PlasmaCraftCore.goopUranium, "Uranium Goop");
        ModLoader.AddName(PlasmaCraftCore.acidVial, "Empty Vial");
        ModLoader.AddName(PlasmaCraftCore.fullAcidVial, "Acid Vial");
        ModLoader.AddName(PlasmaCraftCore.plutoniumVial, "Plutonium Vial");
        ModLoader.AddName(PlasmaCraftCore.radioniteVial, "Radionite Vial");
        ModLoader.AddName(PlasmaCraftCore.uraniumVial, "Uranium Vial");
        ModLoader.AddName(PlasmaCraftCore.neptuniumVial, "Neptunium Vial");
        ModLoader.AddName(PlasmaCraftCore.netherflowVial, "Netherflow Vial");
        ModLoader.AddName(PlasmaCraftCore.obsidiumVial, "Obsidium Vial");
        ModLoader.AddName(PlasmaCraftCore.cryoniteVial, "Cryonite Vial");
        ModLoader.AddName(PlasmaCraftCore.plasmaGel, "Plasma Goop");
        ModLoader.AddName(PlasmaCraftCore.plasmaLeather, "Plasma-Coated Leather");
        ModLoader.AddName(PlasmaCraftCore.plasma, "Plasma");
        ModLoader.AddName(PlasmaCraftCore.lasergun, "Laser Rifle");
        ModLoader.AddName(PlasmaCraftCore.plasmagun, "Plasma Rifle");
        ModLoader.AddName(PlasmaCraftCore.plasmagunsplit, "Plasma Rifle + Beam Splitter");
        ModLoader.AddName(PlasmaCraftCore.lasergunsplit, "Laser Rifle + Beam Splitter");
        ModLoader.AddName(PlasmaCraftCore.acidgun, "Acid Launcher");
        ModLoader.AddName(PlasmaCraftCore.railgun, "Rail Gun");
        //ModLoader.AddName(PlasmaCraftCore.cryoblaster, "Cryo Blaster");
        ModLoader.AddName(PlasmaCraftCore.lasershotgun, "Laser Shotgun");
        ModLoader.AddName(PlasmaCraftCore.causticBoat, "Radionite Boat");
        ModLoader.AddName(PlasmaCraftCore.helmetHazmat, "Hazmat Hood");
        ModLoader.AddName(PlasmaCraftCore.plateHazmat, "Hazmat Jacket");
        ModLoader.AddName(PlasmaCraftCore.legsHazmat, "Hazmat Pants");
        ModLoader.AddName(PlasmaCraftCore.bootsHazmat, "Hazmat Boots");
        
        MinecraftForgeClient.preloadTexture(PlasmaCraftCore.itemTexture);
        MinecraftForgeClient.preloadTexture(PlasmaCraftCore.terrainTexture);
    }

    public static int floatColorsToDamage(float f, float f1, float f2)
    {
        int i = (int)(f * 255F);
        int j = (int)(f1 * 255F);
        int k = (int)(f2 * 255F);
        if(i < 0)
        {
            i = 0;
        }
        if(j < 0)
        {
            j = 0;
        }
        if(k < 0)
        {
            k = 0;
        }
        if(i > 255)
        {
            i = 255;
        }
        if(j > 255)
        {
            j = 255;
        }
        if(k > 255)
        {
            k = 255;
        }
        return i << 16 | j << 8 | k;
    }


    public int AddFuel(int i)
    {
        if(i == PlasmaCraftCore.netherflowVial.shiftedIndex)
        {
            return 0x7a120;
        }
        return i != PlasmaCraftCore.ThermoPellet.shiftedIndex ? 0 : 0xf4240;
    }

    public void RegisterAnimation(Minecraft minecraft)
    {
        ModLoader.addAnimation(new TextureFrameAnimFX(PlasmaCraftCore.plasmificatorFront, "/PlasmaCraftSprites/animations/animatedplasmificator.png"));
        registerLiquidFX(PlasmaCraftCore.cryoniteStillIndex, 0.5F, 0.8F, 1.0F, 1.0F, 128F, 230F, 255F, 146F, 32F, 50F, 36F, 55F);
        registerLiquidFX(PlasmaCraftCore.acidStillIndex, 0.5F, 1.0F, 0.5F, 1.0F, 32F, 255F, 50F, 146F, 32F, 64F, 64F, 50F);
        registerLiquidFX(PlasmaCraftCore.plutoniumStillIndex, 0.5F, 0.9F, 1.0F, 1.0F, 32F, 64F, 64F, 255F, 32F, 64F, 64F, 75F);
        registerLiquidFX(PlasmaCraftCore.radioniteStillIndex, 0.7F, 0.75F, 1.0F, 1.0F, 64F, 64F, 64F, 255F, 64F, 48F, 64F, 75F);
        registerLiquidFX(PlasmaCraftCore.uraniumStillIndex, 0.9F, 0.9F, 0.3F, 1.0F, 255F, 255F, 64F, 160F, 64F, 64F, 32F, 50F);
        registerLiquidFX(PlasmaCraftCore.neptuniumStillIndex, 1.0F, 0.75F, 0.5F, 1.0F, 255F, 128F, 64F, 180F, 64F, 50F, 36F, 55F);
        registerLiquidFX(PlasmaCraftCore.netherflowStillIndex, 1.0F, 0.4F, 0.4F, 1.0F, 255F, 32F, 32F, 200F, 64F, 32F, 32F, 60F);
        registerLiquidFX(PlasmaCraftCore.obsidiumStillIndex, 0.35F, 0.1F, 0.35F, 1.0F, 72F, 64F, 72F, 250F, 40F, 32F, 40F, 10F);
        /*ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.cryoniteStillIndex, 0.5F, 0.8F, 1.0F, 1.0F, 128F, 230F, 255F, 146F, 32F, 50F, 36F, 55F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.cryoniteMovingIndex, 0.5F, 0.8F, 1.0F, 1.0F, 128F, 230F, 255F, 146F, 32F, 50F, 36F, 55F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.acidStillIndex, 0.5F, 1.0F, 0.5F, 1.0F, 32F, 255F, 50F, 146F, 32F, 64F, 64F, 50F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.acidMovingIndex, 0.5F, 1.0F, 0.5F, 1.0F, 32F, 255F, 50F, 146F, 32F, 64F, 64F, 50F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.plutoniumStillIndex, 0.5F, 0.9F, 1.0F, 1.0F, 32F, 64F, 64F, 255F, 32F, 64F, 64F, 75F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.plutoniumMovingIndex, 0.5F, 0.9F, 1.0F, 1.0F, 32F, 64F, 64F, 255F, 32F, 64F, 64F, 75F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.radioniteStillIndex, 0.9F, 0.4F, 1.0F, 1.0F, 64F, 64F, 64F, 255F, 64F, 32F, 64F, 75F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.radioniteMovingIndex, 0.9F, 0.4F, 1.0F, 1.0F, 64F, 32F, 64F, 255F, 64F, 32F, 64F, 75F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.uraniumStillIndex, 0.9F, 0.9F, 0.3F, 1.0F, 255F, 255F, 64F, 160F, 64F, 64F, 32F, 50F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.uraniumMovingIndex, 0.9F, 0.9F, 0.3F, 1.0F, 255F, 255F, 64F, 160F, 64F, 64F, 32F, 50F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.neptuniumStillIndex, 1.0F, 0.75F, 0.5F, 1.0F, 255F, 128F, 64F, 180F, 64F, 50F, 36F, 55F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.neptuniumMovingIndex, 1.0F, 0.75F, 0.5F, 1.0F, 255F, 128F, 64F, 180F, 64F, 50F, 36F, 55F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.netherflowStillIndex, 1.0F, 0.4F, 0.4F, 1.0F, 255F, 32F, 32F, 200F, 64F, 32F, 32F, 60F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.netherflowMovingIndex, 1.0F, 0.4F, 0.4F, 1.0F, 255F, 32F, 32F, 200F, 64F, 32F, 32F, 60F, 16, 16));
        ModLoader.addAnimation(new TextureTintedStillFX(PlasmaCraftCore.obsidiumStillIndex, 0.15F, 0.1F, 0.15F, 1.0F, 72F, 64F, 72F, 220F, 40F, 32F, 40F, 70F, 16, 16));
        ModLoader.addAnimation(new TextureTintedFlowFX(PlasmaCraftCore.obsidiumMovingIndex, 0.15F, 0.1F, 0.15F, 1.0F, 72F, 64F, 72F, 220F, 40F, 32F, 40F, 70F, 16, 16));*/
    }
    
    private void registerLiquidFX(int stillIndex, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12)
    {
    	int width = 16;
    	int height = 16;
    	ModLoader.addAnimation(new TextureTintedStillFX(stillIndex, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, width, height));
    	ModLoader.addAnimation(new TextureTintedFlowFX(stillIndex + 1, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, width, height));
    	ModLoader.addAnimation(new TextureTintedFlowFX(stillIndex + 2, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, width, height));
    	ModLoader.addAnimation(new TextureTintedFlowFX(stillIndex + 17, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, width, height));
    	ModLoader.addAnimation(new TextureTintedFlowFX(stillIndex + 18, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, width, height));
    }

    private float getFluidHeight(IBlockAccess iblockaccess, int i, int j, int k, Material mat)
    {
        int l = 0;
        float f = 0.0F;
        for(int i1 = 0; i1 < 4; i1++)
        {
            int j1 = i - (i1 & 1);
            int k1 = j;
            int l1 = k - (i1 >> 1 & 1);
            if(iblockaccess.getBlockMaterial(j1, k1 + 1, l1) == Material.water)
            {
                return 1.0F;
            }
            Material material = iblockaccess.getBlockMaterial(j1, k1, l1);
            if(material == Material.water)
            {
                int i2 = iblockaccess.getBlockMetadata(j1, k1, l1);
                if(i2 >= 8 || i2 == 0)
                {
                    f += BlockFluid.getFluidHeightPercent(i2) * 10F;
                    l += 10;
                }
                f += BlockFluid.getFluidHeightPercent(i2);
                l++;
                continue;
            }
            if(!material.isSolid())
            {
                f++;
                l++;
            }
        }

        return 1.0F - f / (float)l;
    }

    public void renderBottomFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minX * 16D) / 256D;
        double d4 = (((double)j + block.maxX * 16D) - 0.01D) / 256D;
        double d5 = ((double)k + block.minZ * 16D) / 256D;
        double d6 = (((double)k + block.maxZ * 16D) - 0.01D) / 256D;
        if(block.minX < 0.0D || block.maxX > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 15.99F) / 256F;
        }
        if(block.minZ < 0.0D || block.maxZ > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 15.99F) / 256F;
        }
        double d7 = d + block.minX;
        double d8 = d + block.maxX;
        double d9 = d1 + block.minY;
        double d10 = d2 + block.minZ;
        double d11 = d2 + block.maxZ;
        tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
        tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
    }

    public boolean renderBlockCaustics(RenderBlocks renderblocks, IBlockAccess iblockaccess, Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = block.colorMultiplier(iblockaccess, i, j, k);
        float f = (float)(l >> 16 & 0xff) / 255F;
        float f1 = (float)(l >> 8 & 0xff) / 255F;
        float f2 = (float)(l & 0xff) / 255F;
        boolean flag = block.shouldSideBeRendered(iblockaccess, i, j + 1, k, 1);
        boolean flag1 = block.shouldSideBeRendered(iblockaccess, i, j - 1, k, 0);
        boolean aflag[] = {
            block.shouldSideBeRendered(iblockaccess, i, j, k - 1, 2), block.shouldSideBeRendered(iblockaccess, i, j, k + 1, 3), block.shouldSideBeRendered(iblockaccess, i - 1, j, k, 4), block.shouldSideBeRendered(iblockaccess, i + 1, j, k, 5)
        };
        if(!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3])
        {
            return false;
        }
        boolean flag2 = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        double d = 0.0D;
        double d1 = 1.0D;
        Material material = block.blockMaterial;
        int i1 = iblockaccess.getBlockMetadata(i, j, k);
        double d2 = getFluidHeight(iblockaccess, i, j, k, material);
        double d3 = getFluidHeight(iblockaccess, i, j, k + 1, material);
        double d4 = getFluidHeight(iblockaccess, i + 1, j, k + 1, material);
        double d5 = getFluidHeight(iblockaccess, i + 1, j, k, material);
        double d6 = 0.0010000000474974513D;
        if(renderblocks.renderAllFaces || flag)
        {
            flag2 = true;
            int j1 = block.getBlockTextureFromSideAndMetadata(1, i1);
            float f7 = (float)BlockFluid.func_293_a(iblockaccess, i, j, k, material);
            if(f7 > -999F)
            {
                j1 = block.getBlockTextureFromSideAndMetadata(2, i1);
            }
            d2 -= d6;
            d3 -= d6;
            d4 -= d6;
            d5 -= d6;
            int k2 = (j1 & 0xf) << 4;
            int l1 = j1 & 0xf0;
            double d7 = ((double)k2 + 8D) / 256D;
            double d8 = ((double)l1 + 8D) / 256D;
            if(f7 < -999F)
            {
                f7 = 0.0F;
            } else
            {
                d7 = (float)(k2 + 16) / 256F;
                d8 = (float)(l1 + 16) / 256F;
            }
            double d10 = (double)(MathHelper.sin(f7) * 8F) / 256D;
            double d12 = (double)(MathHelper.cos(f7) * 8F) / 256D;
            tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, i, j, k));
            float f9 = 1.0F;
            tessellator.setColorOpaque_F(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
            tessellator.addVertexWithUV(i + 0, (double)j + d2, k + 0, d7 - d12 - d10, (d8 - d12) + d10);
            tessellator.addVertexWithUV(i + 0, (double)j + d3, k + 1, (d7 - d12) + d10, d8 + d12 + d10);
            tessellator.addVertexWithUV(i + 1, (double)j + d4, k + 1, d7 + d12 + d10, (d8 + d12) - d10);
            tessellator.addVertexWithUV(i + 1, (double)j + d5, k + 0, (d7 + d12) - d10, d8 - d12 - d10);
        }
        if(renderblocks.renderAllFaces || flag1)
        {
            tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, i, j - 1, k));
            float f8 = 1.0F;
            tessellator.setColorOpaque_F(f3 * f8, f3 * f8, f3 * f8);
            renderBottomFace(block, i, (double)j + d6, k, block.getBlockTextureFromSide(0));
            flag2 = true;
        }
        for(int k1 = 0; k1 < 4; k1++)
        {
            int j2 = i;
            int i2 = k;
            if(k1 == 0)
            {
                i2 = k - 1;
            }
            if(k1 == 1)
            {
                i2++;
            }
            if(k1 == 2)
            {
                j2 = i - 1;
            }
            if(k1 == 3)
            {
                j2++;
            }
            int l2 = block.getBlockTextureFromSideAndMetadata(k1 + 2, i1);
            int i3 = (l2 & 0xf) << 4;
            int j3 = l2 & 0xf0;
            if(renderblocks.renderAllFaces || aflag[k1])
            {
                double d9;
                double d11;
                double d13;
                double d14;
                double d15;
                double d16;
                if(k1 == 0)
                {
                    d11 = d2;
                    d9 = d5;
                    d14 = i;
                    d16 = i + 1;
                    d13 = (double)k + d6;
                    d15 = (double)k + d6;
                } else
                if(k1 == 1)
                {
                    d11 = d4;
                    d9 = d3;
                    d14 = i + 1;
                    d16 = i;
                    d13 = (double)(k + 1) - d6;
                    d15 = (double)(k + 1) - d6;
                } else
                if(k1 == 2)
                {
                    d11 = d3;
                    d9 = d2;
                    d14 = (double)i + d6;
                    d16 = (double)i + d6;
                    d13 = k + 1;
                    d15 = k;
                } else
                {
                    d11 = d5;
                    d9 = d4;
                    d14 = (double)(i + 1) - d6;
                    d16 = (double)(i + 1) - d6;
                    d13 = k;
                    d15 = k + 1;
                }
                flag2 = true;
                double d17 = (float)(i3 + 0) / 256F;
                double d18 = ((double)(i3 + 16) - 0.01D) / 256D;
                double d19 = ((double)j3 + (1.0D - d11) * 16D) / 256D;
                double d20 = ((double)j3 + (1.0D - d9) * 16D) / 256D;
                double d21 = ((double)(j3 + 16) - 0.01D) / 256D;
                tessellator.setBrightness(block.getMixedBrightnessForBlock(iblockaccess, j2, j, i2));
                float f10 = 1.0F;
                if(k1 < 2)
                {
                    f10 *= f5;
                } else
                {
                    f10 *= f6;
                }
                tessellator.setColorOpaque_F(f4 * f10 * f, f4 * f10 * f1, f4 * f10 * f2);
                tessellator.addVertexWithUV(d14, (double)j + d11, d13, d17, d19);
                tessellator.addVertexWithUV(d16, (double)j + d9, d15, d18, d20);
                tessellator.addVertexWithUV(d16, j + 0, d15, d18, d21);
                tessellator.addVertexWithUV(d14, j + 0, d13, d17, d21);
            }
        }

        block.minY = d;
        block.maxY = d1;
        return flag2;
    }

    public boolean RenderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
        if(l == causticRenderID)
        {
            return renderBlockCaustics(renderblocks, iblockaccess, block, i, j, k);
        }
        else
        {
            return false;
        }
    }

    public static void pressKey(int i)
    {
        ModLoaderMp.SendKey(instance, i);
    }

    public GuiScreen HandleGUI(int i)
    {
        if(i == 159)
        {
            return new GuiPlasmaBench(ModLoader.getMinecraftInstance().thePlayer.inventory, new TileEntityPlasmaBench());
        }
        else
        {
            return null;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void AddRenderer(Map map)
    {
        map.put(EntityAcidTNTPrimed.class, new RenderAcidTNTPrimed());
        map.put(EntityCausticBoat.class, new RenderCausticBoat());
        map.put(EntityAcidGrenade.class, new RenderAcidGrenade(PlasmaCraftCore.acidGrenade.iconIndex));
        map.put(EntityPlasma.class, new RenderPlasma());
        map.put(EntityLaser.class, new RenderLaser());
        map.put(EntityRailGun.class, new RenderRailGun());
        map.put(EntityLaserShotgun.class, new RenderLaserShotgun());
        map.put(EntityAcid.class, new RenderAcid());
        map.put(EntityCryoBlast.class, new RenderCryoBlast());
    }
    
    public void GenerateNether(World world, Random random, int i, int j)
    {
    	PlasmaCraftCore.GenerateNether(world, random, i, j);
    }

    public void GenerateSurface(World world, Random random, int i, int j)
    {
    	PlasmaCraftCore.GenerateSurface(world, random, i, j);
    }
}