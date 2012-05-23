package net.minecraft.src.Plasmacraft;

import java.io.File;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Potion;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class PCServerProxy implements IPCProxy
{
	public PCServerProxy()
	{
	}
	
	public boolean isClient (World world) {
		return false;
	}
	
	@Override
	public String getMinecraftDirectory()
	{
		return "";
	}

	@Override
	public boolean getEntityInstanceOf(Entity entity) {
		return entity instanceof EntityPlayerMP;
	}

	@Override
	public int getLightBrightnessForSkyBlocks(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getLightBrightess(IBlockAccess iblockaccess, int i, int j,
			int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageEdgeLength(AxisAlignedBB boundingBox) {
		return 0;
	}
	
}