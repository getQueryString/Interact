package Main;


import EntityInteract.InteractMain;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    public static String pre = "§7[§cServer§7]";

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aDas §3Interact-Plugin §awurde erfolgreich aktiviert!");
        Bukkit.getPluginManager().registerEvents(new InteractMain(), this);
        this.getCommand("invsee").setExecutor(new main());

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Interact-Plugin §4wurde erfolgreich deaktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

        if (label.equalsIgnoreCase("invsee")) {
            if (sender.hasPermission("sys.Invsee")) {

                if (args.length == 1) {
                    if (sender instanceof Player) {
                        String name = args[0];
                        if (Bukkit.getPlayer(name) == null) {
                            sender.sendMessage(main.pre + " §4Der Spieler ist nicht Online!");
                            return false;
                        }
                        Player target = Bukkit.getPlayer(name);
                        Player player = (Player) sender;
                        if (player == target) {
                            player.sendMessage(main.pre + " §4Du kannst hier§ber nicht in dein eigenes Inventar schauen!");
                            return false;
                        }
                        player.openInventory(target.getInventory());
                        target.sendMessage("§6" + player.getName() + " §abeobachtet nun dein Inventar!");
                        return true;
                    } else {
                        sender.sendMessage(main.pre + " §4Du musst ein Spieler sein!");
                    }
                } else {
                    sender.sendMessage(main.pre + " §4/invsee §c[§6Player§c]");
                }
            } else {
                sender.sendMessage(main.noperm);
            }
        }


        return false;
    }

}