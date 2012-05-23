package net.minecraft.src.Plasmacraft;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldClient;

public class PCClientProxy implements IPCProxy
{
	public PCClientProxy()
	{
	}
	
	@Override
	public String getMinecraftDirectory()
	{
		File dir = Minecraft.getAppDir("minecraft");
		return dir.getAbsolutePath() + "/";
	}

	public boolean isClient (World world) {
		return world instanceof WorldClient;
	}

	@Override
	public boolean getEntityInstanceOf(Entity entity) {
		return entity instanceof EntityPlayerSP;
	}

	@Override
	public int getLightBrightnessForSkyBlocks(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return iblockaccess.getLightBrightnessForSkyBlocks(i, j, k, l);
	}

	@Override
	public float getLightBrightess(IBlockAccess iblockaccess, int i, int j,
			int k) {
		return iblockaccess.getLightBrightness(i, j, k);
	}

	@Override
	public double getAverageEdgeLength(AxisAlignedBB boundingBox) {
		return boundingBox.getAverageEdgeLength();
	}
	
}