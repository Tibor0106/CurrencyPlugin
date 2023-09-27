package hu.tibor.Commands;

import hu.tibor.CurrencyPlugin;
import hu.tibor.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCurrency_player implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args[0].equalsIgnoreCase("balance")){
            if(args.length != 2){
                sender.sendMessage(Utils.CHAT_PREFIX+" §cMissing args...");
                return false;
            }
            //testing player is online
            Player target;
            try{
                target = Bukkit.getPlayer(args[1]);
                //require for test player is online
                target.getInventory();
            }catch (Exception err){
                err.printStackTrace();
                sender.sendMessage(Utils.CHAT_PREFIX+" §cPlayer not found!");
                return false;
            }
            //player is validated here
            sender.sendMessage(Utils.CHAT_PREFIX+" §e"+args[1]+"'s balance § §b"+Utils.CurrencyName);

        }
        return false;
    }
}