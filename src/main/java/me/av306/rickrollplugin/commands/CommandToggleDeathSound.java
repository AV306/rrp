package me.av306.rickrollplugin.commands;

import me.av306.rickrollplugin.listener.PlayerDeathEventListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandToggleDeathSound implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args ) {
        short currentDeathSound = PlayerDeathEventListener.deathSound;

        switch ( currentDeathSound ) {
            case 0:
                currentDeathSound = 1;
                break;

            case 1:
                currentDeathSound = 2;
                break;

            case 2:
                currentDeathSound = 0;
                break;
        }

        sender.sendMessage( "Current death sound: " + currentDeathSound );

        PlayerDeathEventListener.deathSound = currentDeathSound;

        return true;
    }
}
