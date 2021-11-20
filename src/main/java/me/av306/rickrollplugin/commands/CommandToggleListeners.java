package me.av306.rickrollplugin.commands;

import me.av306.rickrollplugin.Main;
import me.av306.rickrollplugin.listener.PlayerDeathEventListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandToggleListeners implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args ) {
        if ( args.length != 1 ) return false;

        switch ( args[0] ) {
            case "death":
                PlayerDeathEventListener.isEnabled = !PlayerDeathEventListener.isEnabled;

                if ( sender instanceof Player ) Main.log( (Player)sender, "PlayerDeathEventListener: " + PlayerDeathEventListener.isEnabled );
                else Main.LOGGER.info( "PlayerDeathEventListener: " + PlayerDeathEventListener.isEnabled );
                break;

            default:
                return false;
        }

        return true;
    }
}
