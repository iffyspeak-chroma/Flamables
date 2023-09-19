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

        public static void combustSetFire(int flameRadius, World world, int x, int landy, int z)
        {
            // There's a lot of precision that'll be cut out because of minecraft blocks :\
            // but thank you to Kathir for helping me remember pre-cal.
            // https://stackoverflow.com/questions/9007977/draw-circle-using-pixels-applied-in-an-image-with-for-loop
            double pi = 3.14159265;
            double i, angle, x1, y1;

            for (i = 0; i < 360; i += 0.1)
            {
                angle = i;
                x1 = flameRadius * Math.cos(angle * pi / 180);
                y1 = flameRadius * Math.sin(angle * pi / 180);

                Location loc = new Location(
                        world,
                        x + x1,
                        getSurfaceBlock(
                                world,
                                (int) (x + x1),
                                (int) (z + y1),
                                landy),
                        z + y1
                        );

                world.getBlockAt(loc).setType(Material.FIRE);
            }
        }
    }

}
