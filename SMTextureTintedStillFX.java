package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode


public class SMTextureTintedStillFX extends TextureFX
{

    public SMTextureTintedStillFX(int baseIndex, float rt, float gt, float bt, float at,
    										  float rb, float gb, float bb, float ab,
    										  float rs, float gs, float bs, float as,
    										  int w, int h)
	{
        super(baseIndex);
        width = w;
        height = h;
        field_1158_g = new float[width*height];
        field_1157_h = new float[width*height];
        field_1156_i = new float[width*height];
        field_1155_j = new float[width*height];
        tickCounter = 0;
        rTint = rt;
        gTint = gt;
        bTint = bt;
        aTint = at;
        rBase = rb;
        gBase = gb;
        bBase = bb;
        aBase = ab;
        rSpread = rs;
        gSpread = gs;
        bSpread = bs;
        aSpread = as;
    }

    public void onTick()
    {
        tickCounter++;
        for(int i = 0; i < width; i++)
        {
            for(int k = 0; k < height; k++)
            {
                float f = 0.0F;
                for(int j1 = i - 1; j1 <= i + 1; j1++)
                {
                    int k1 = j1 & 0xf;
                    int i2 = k & 0xf;
                    f += field_1158_g[k1 + i2 * width];
                }

                field_1157_h[i + k * width] = f / 3.3F + field_1156_i[i + k * width] * 0.8F;
            }

        }

        for(int j = 0; j < width; j++)
        {
            for(int l = 0; l < height; l++)
            {
                field_1156_i[j + l * width] += field_1155_j[j + l * width] * 0.05F;
                if(field_1156_i[j + l * width] < 0.0F)
                {
                    field_1156_i[j + l * width] = 0.0F;
                }
                field_1155_j[j + l * width] -= 0.1F;
                if(Math.random() < 0.050000000000000003D)
                {
                    field_1155_j[j + l * width] = 0.5F;
                }
            }

        }

        float af[] = field_1157_h;
        field_1157_h = field_1158_g;
        field_1158_g = af;
        for(int i1 = 0; i1 < width*height; i1++)
        {
            float f1 = field_1158_g[i1];
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            }
            if(f1 < 0.0F)
            {
                f1 = 0.0F;
            }
            float f2 = f1 * f1;
            int l1 = (int)(rBase + f2 * rSpread);
            int j2 = (int)(gBase + f2 * gSpread);
            int k2 = (int)(bBase + f2 * bSpread);
            int l2 = (int)(aBase + f2 * aSpread);
            if(anaglyphEnabled)
            {
                int i3 = (l1 * 30 + j2 * 59 + k2 * 11) / 100;
                int j3 = (l1 * 30 + j2 * 70) / 100;
                int k3 = (l1 * 30 + k2 * 70) / 100;
                l1 = i3;
                j2 = j3;
                k2 = k3;
            }
            l1 = (int)((float)l1 * rTint);
            j2 = (int)((float)j2 * gTint);
            k2 = (int)((float)k2 * bTint);
            l2 = (int)((float)l2 * aTint);
            if(l1 < 0) l1 = 0;
            if(j2 < 0) j2 = 0;
            if(k2 < 0) k2 = 0;
            if(l2 < 0) l2 = 0;
            if(l1 > 255) l1 = 255;
            if(j2 > 255) j2 = 255;
            if(k2 > 255) k2 = 255;
            if(l2 > 255) l2 = 255;
            imageData[i1 * 4 + 0] = (byte)l1;
            imageData[i1 * 4 + 1] = (byte)j2;
            imageData[i1 * 4 + 2] = (byte)k2;
            imageData[i1 * 4 + 3] = (byte)l2;
        }

    }

    protected float field_1158_g[];
    protected float field_1157_h[];
    protected float field_1156_i[];
    protected float field_1155_j[];
    private int tickCounter;
    private float rTint;
    private float gTint;
    private float bTint;
    private float aTint;
    private float rBase;
    private float gBase;
    private float bBase;
    private float aBase;
    private float rSpread;
    private float gSpread;
    private float bSpread;
    private float aSpread;
    private int width;
    private int height;
}
