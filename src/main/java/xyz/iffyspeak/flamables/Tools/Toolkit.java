package xyz.iffyspeak.flamables.Tools;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class Toolkit {

    public static class WorldTools
    {
        public static int getSurfaceBlock(World search, int x, int z, int ystart)
        {
            int surface = ystart;

            for (int i = ystart; i < search.getMaxHeight() - 1; i++)
            {
                Location searchloc = new Location(search, x, surface, z);
                if (search.getBlockAt(x, i, z).getBlockData().getMaterial().equals(Material.AIR))
                {
                    break;
                } else
                {
                    surface = i;
                }
            }

            return surface;
        }
    }

}
