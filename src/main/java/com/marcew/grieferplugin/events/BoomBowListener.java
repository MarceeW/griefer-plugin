package com.marcew.grieferplugin.events;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BoomBowListener implements Listener {

    private static final String BOOM_BOW_NAME = "Boom";

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player player) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.getType() == Material.BOW && item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();
                    if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(BOOM_BOW_NAME)) {
                        entity.getWorld().createExplosion(entity.getLocation(), 4.0F, false, false);
                        entity.getWorld().spawnParticle(Particle.EXPLOSION_EMITTER, entity.getLocation(), 10);
                        entity.getWorld().spawnParticle(Particle.FLAME, entity.getLocation(), 30, 0.5, 0.5, 0.5);
                        entity.getWorld().spawnParticle(Particle.EXPLOSION_EMITTER, entity.getLocation(), 20, 0.5, 0.5, 0.5);

                        entity.remove();
                    }
                }
            }
        }
    }
}
