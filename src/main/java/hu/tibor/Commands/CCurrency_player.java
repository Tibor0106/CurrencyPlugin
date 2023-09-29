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

            //player is validated here
            double playerBalance = CurrencyPlugin.getMysqlDataHandler().getBalance(args[1]);
            if(playerBalance != -1){
                sender.sendMessage(Utils.CHAT_PREFIX+" §e"+args[1]+"'s balance: "+playerBalance+" § §b"+Utils.CurrencyName);
            } else {
                sender.sendMessage(Utils.CHAT_PREFIX+" §cPlayer does not exits!");
            }
        } else if(args[0].equalsIgnoreCase("setcurrency")){
            if(args.length != 3){
                sender.sendMessage(Utils.CHAT_PREFIX+" §cMissing args...");
                return false;
            }
            double amount = 0;

            if(!CurrencyPlugin.getMysqlDataHandler().playerExits(args[1])){
                sender.sendMessage(Utils.CHAT_PREFIX+" §cPlayer does not exits!");
                return true;
            }
            try{
                amount = Double.parseDouble(args[2]);
            }catch (NumberFormatException err){
                sender.sendMessage(Utils.CHAT_PREFIX+" §cAmount is not a number!");
                return  true;
            }
            if(amount < 0){
                sender.sendMessage(Utils.CHAT_PREFIX+" §cAmount cannot be lower than zero");
                return false;
            }
            if( CurrencyPlugin.getMysqlDataHandler().DepositPlayer(args[1], amount)){
                sender.sendMessage(Utils.CHAT_PREFIX+" §aSuccess!");
            } else {
                sender.sendMessage(Utils.CHAT_PREFIX+" §c Error while set currency!");
            }


        }
        return false;
    }
}