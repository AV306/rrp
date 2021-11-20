package me.av306.rickrollplugin;


import me.av306.rickrollplugin.commands.CommandSetDeathSound;
import me.av306.rickrollplugin.commands.CommandToggleListeners;
import me.av306.rickrollplugin.listener.*;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Main extends JavaPlugin
{
	public static Server psmp;
	public static PluginManager pluginManager;
	public static final Logger LOGGER = Bukkit.getLogger();
	
	@Override
	public void onEnable() {
    	psmp = this.getServer();
    	pluginManager = psmp.getPluginManager();

		LOGGER.info( "Initialising! Here we go!" );
    	LOGGER.info( "Server: " + psmp.getName() );
    	LOGGER.info( "Plugins: " + pluginManager.getPlugins() );
    
		pluginManager.registerEvents( new PlayerDeathEventListener(), this );
		LOGGER.info( "Registered PlayerDeathEvent listener!" );

		this.getCommand( "togglelistener" ).setExecutor( new CommandToggleListeners() );
		this.getCommand( "setdeathsound" ).setExecutor( new CommandSetDeathSound() );
		LOGGER.info( "Registered commands!" );
	}


	public static void log( Player[] targets, String msg ) {
		LOGGER.info( msg );

		try {
			for (Player target : targets) {
				target.sendMessage(msg);
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void log( Player target, String msg ) {
		LOGGER.info( msg );

		try {
			target.sendMessage( msg );
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
}