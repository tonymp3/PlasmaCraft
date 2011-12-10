


import org.lwjgl.opengl.GL11;

public class SMRenderCausticBoat extends Render
{

    public SMRenderCausticBoat()
    {
        shadowSize = 0.5F;
        modelBoat = new ModelBoat();
    }

    public void renderBoat(SMEntityCausticBoat boat, double d, double d1, double d2,
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        float f2 = (float)boat.getTimeSinceHit() - f1;
        float f3 = (float)boat.getDamageTaken() - f1;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f2 > 0.0F)
        {
            GL11.glRotatef(((MathHelper.sin(f2) * f2 * f3) / 10F) * (float)boat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }
        loadTexture("/terrain.png");
        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        loadTexture("/item/boat_caustic.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        modelBoat.render(boat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2,
            float f, float f1)
    {
        renderBoat((SMEntityCausticBoat)entity, d, d1, d2, f, f1);
    }

    protected ModelBase modelBoat;
}
