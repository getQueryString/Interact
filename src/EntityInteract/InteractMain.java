package EntityInteract;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

public class InteractMain implements Listener {

    public static Plugin plugin;

    public void Events(Plugin plugin) {
        InteractMain.plugin = plugin;
    }


    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = (Entity) event.getRightClicked();

        //Name
        entity.setCustomName("§c§lEntity");
        entity.setCustomNameVisible(true);

        //Event Canceln
        event.setCancelled(true);

        //Entity Removen
        entity.remove();
    }

}