package com.elvenwater.malkierian.Plasmacraft.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenCaustics extends WorldGenerator
{
    private int causticID;

    public WorldGenCaustics(int i)
    {
        causticID = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        if(world.getBlockId(i, j + 1, k) != Block.stone.blockID)
        {
            return false;
        }
        if(world.getBlockId(i, j - 1, k) != Block.stone.blockID)
        {
            return false;
        }
        if(world.getBlockId(i, j, k) != 0 && world.getBlockId(i, j, k) != Block.stone.blockID)
        {
            return false;
        }
        int l = 0;
        if(world.getBlockId(i - 1, j, k) == Block.stone.blockID)
        {
            l++;
        }
        if(world.getBlockId(i + 1, j, k) == Block.stone.blockID)
        {
            l++;
        }
        if(world.getBlockId(i, j, k - 1) == Block.stone.blockID)
        {
            l++;
        }
        if(world.getBlockId(i, j, k + 1) == Block.stone.blockID)
        {
            l++;
        }
        int i1 = 0;
        if(world.isAirBlock(i - 1, j, k))
        {
            i1++;
        }
        if(world.isAirBlock(i + 1, j, k))
        {
            i1++;
        }
        if(world.isAirBlock(i, j, k - 1))
        {
            i1++;
        }
        if(world.isAirBlock(i, j, k + 1))
        {
            i1++;
        }
        if(l == 3 && i1 == 1)
        {
            world.setBlockWithNotify(i, j, k, causticID);
            world.scheduledUpdatesAreImmediate = true;
            Block.blocksList[causticID].updateTick(world, i, j, k, random);
            world.scheduledUpdatesAreImmediate = false;
        }
        return true;
    }
}
