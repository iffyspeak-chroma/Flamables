package xyz.iffyspeak.flamables.Tools;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.CraftingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import xyz.iffyspeak.flamables.Flamables;
import xyz.iffyspeak.flamables.Interfaces.ICustomItem;

import java.util.Arrays;

public class Globals {
    public static class Item {

        public static class Molotov implements ICustomItem
        {
            @Override
            public NamespacedKey getKey() {
                return new NamespacedKey(Flamables.getPlugin(Flamables.class), "molotov_key");
            }

            @Override
            public ItemStack getItem() {
                ItemStack molotov = new ItemStack(Material.SPLASH_POTION);
                PotionMeta meta = (PotionMeta) molotov.getItemMeta();
                meta.setColor(Color.fromRGB(255,161,61));
                meta.displayName(MiniMessage.miniMessage().deserialize("<color:#ffa13d><b>Molotov Cocktail</b></color>"));
                meta.lore(Arrays.asList(
                        MiniMessage.miniMessage().deserialize("<color:#ff0000><b>USE WILL DISQUALIFY ALL LIFE REFUNDS</b></color>"),
                        Component.text(""),
                        MiniMessage.miniMessage().deserialize("<color:#ff00e6>Burn it to the ground</color>"),
                        MiniMessage.miniMessage().deserialize("<color:#ff00e6>Who deserves this anyways?</color>"),
                        MiniMessage.miniMessage().deserialize("<color:#ff00e6>You're a monster.</color>")
                ));

                PersistentDataContainer pdc = meta.getPersistentDataContainer();
                pdc.set(new NamespacedKey("flammables", "is_normal_molotov"), PersistentDataType.BOOLEAN, true);

                molotov.setItemMeta(meta);

                return molotov;
            }

            @Override
            public CraftingRecipe getRecipe() {
                // TODO: Make a fucking recipe. I'm lazy and want to work on other things. This is not it.
                return null;
            }
        }

        public static class ExplosiveMolotov implements ICustomItem
        {
            @Override
            public NamespacedKey getKey() {
                return new NamespacedKey(Flamables.getPlugin(Flamables.class), "explosive_molotov_key");
            }

            @Override
            public ItemStack getItem() {
                ItemStack molotov = new ItemStack(Material.SPLASH_POTION);
                PotionMeta meta = (PotionMeta) molotov.getItemMeta();
                meta.setColor(Color.fromRGB(255,66,28));
                meta.displayName(MiniMessage.miniMessage().deserialize("<color:#ff0040><b>Explosive Molotov Cocktail</b></color>"));
                meta.lore(Arrays.asList(
                        MiniMessage.miniMessage().deserialize("<color:#ff0000><b>USE WILL DISQUALIFY ALL LIFE REFUNDS</b></color>"),
                        Component.text(""),
                        MiniMessage.miniMessage().deserialize("<color:#ff00e6>Oh, wow. So you've <i>really</i> had enough.</color>"),
                        MiniMessage.miniMessage().deserialize("<color:#ff00e6>Wonder what they did to set you off.</color>")
                ));

                PersistentDataContainer pdc = meta.getPersistentDataContainer();
                pdc.set(new NamespacedKey("flammables", "is_explosive_molotov"), PersistentDataType.BOOLEAN, true);

                molotov.setItemMeta(meta);

                return molotov;
            }

            @Override
            public CraftingRecipe getRecipe() {
                // TODO: Make a fucking recipe. I'm lazy and want to work on other things. This is not it.
                return null;
            }
        }
    }
}
