package pl.wolny.junglenokaut.cmds;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pl.wolny.junglenokaut.JungleNokaut;

public class AkceptujSmierc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Nice try :)");
            return false;
        }
        Player executor = (Player) sender;
        PersistentDataContainer data = executor.getPersistentDataContainer();
        if(data.get(new NamespacedKey(JungleNokaut.getMain(), "NokStatus"), PersistentDataType.INTEGER) == 0){
            executor.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cŻycie jest piekne, dlaczego chcesz popełnić samobójstwo?"));
            return false;
        }
        executor.setHealth(0);
        executor.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aHara-kiri popełnione. Miłego dnia."));
        return true;
    }
}
