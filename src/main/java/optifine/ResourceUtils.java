package optifine;

import net.minecraft.client.resources.AbstractResourcePack;

import java.io.File;

public class ResourceUtils
{
    private static final ReflectorClass ForgeAbstractResourcePack = new ReflectorClass(AbstractResourcePack.class);
    private static final ReflectorField ForgeAbstractResourcePack_resourcePackFile = new ReflectorField(ForgeAbstractResourcePack, "resourcePackFile");
    private static boolean directAccessValid = true;

    public static File getResourcePackFile(AbstractResourcePack arp)
    {
        if (directAccessValid)
        {
            try
            {
                return arp.resourcePackFile;
            }
            catch (IllegalAccessError var2)
            {
                directAccessValid = false;

                if (!ForgeAbstractResourcePack_resourcePackFile.exists())
                {
                    throw var2;
                }
            }
        }

        return (File)Reflector.getFieldValue(arp, ForgeAbstractResourcePack_resourcePackFile);
    }
}
