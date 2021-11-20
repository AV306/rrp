package me.av306.rickrollplugin.commands;

import me.av306.rickrollplugin.Main;
import me.av306.rickrollplugin.listener.PlayerDeathEventListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSetDeathSound implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args ) {
        if ( args.length != 1 ) return false;

        PlayerDeathEventListener.deathSound = Short.parseShort( args[0] );

        if ( sender instanceof Player ) Main.log( (Player)sender, "Death sound: " + PlayerDeathEventListener.deathSound );
        else Main.LOGGER.info( "Death sound: " + PlayerDeathEventListener.deathSound );

        return true;
    }
}
