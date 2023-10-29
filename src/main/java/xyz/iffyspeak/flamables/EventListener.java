package xyz.iffyspeak.flamables;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.persistence.PersistentDataType;
import xyz.iffyspeak.flamables.Tools.Globals;
import xyz.iffyspeak.flamables.Tools.Toolkit;

public class EventListener implements Listener {

    @EventHandler
    public void onPotionSplash(PotionSplashEvent e)
    {
        // If the molotov wasn't thrown by a player, then we consider it wasted and do nothing with it.
        // Like a good little boy.
        if (!(e.getEntity().getShooter() instanceof Player)) return;

        if (e.getPotion().getItem().getItemMeta().getPersistentDataContainer().has(new NamespacedKey("flammables", "is_normal_molotov"), PersistentDataType.BOOLEAN))
        {
            // If it's a normal molotov, code here
            //Bukkit.getLogger().severe("Normal molotov");
            Toolkit.WorldTools.combustSetFire(6, e.getEntity().getWorld(), e.getPotion().getLocation().getBlockX(), e.getPotion().getLocation().getBlockY(), e.getPotion().getLocation().getBlockZ());
        }

        if (e.getPotion().getItem().getItemMeta().getPersistentDataContainer().has(new NamespacedKey("flammables", "is_explosive_molotov"), PersistentDataType.BOOLEAN))
        {
            // If it's an explosive molotov, code here
            //Bukkit.getLogger().severe("Explosive molotov");
            Toolkit.WorldTools.combustSetFire(12, e.getEntity().getWorld(), e.getPotion().getLocation().getBlockX(), e.getPotion().getLocation().getBlockY(), e.getPotion().getLocation().getBlockZ());
        }
    }

}
