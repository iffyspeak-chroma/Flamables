package xyz.iffyspeak.flamables;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPotionSplash(PotionSplashEvent e)
    {
        // If the molotov wasn't thrown by a player, then we consider it wasted and do nothing with it.
        // Like a good little boy.
        if (!(e.getEntity().getShooter() instanceof Player)) return;


    }

}
