package me.av306.rickrollplugin.listener;


import me.av306.rickrollplugin.Main;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeathEventListener implements Listener
{
	public static short deathSound = 0;

	public static boolean isEnabled = true;

	@EventHandler
	public void onPlayerDeathEvent( PlayerDeathEvent event ) {
		Player playerWhoDied = event.getEntity();

		if ( playerWhoDied.getName().equals( "Blender_08" )  && isEnabled ) {
			// I died
			Main.LOGGER.info( "Whoops! Blender died!" );

			playSoundOnDeath( deathSound );
		}
	}


	private void playSoundOnDeath( short deathSound ) {
		for ( Player players : Main.psmp.getWorld( "world" ).getPlayers() ) {
			switch ( deathSound ) {
				case 0:
					players.playSound(players.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.MASTER, 1000.0f, 1.0f); // play sound on die
					break;

				case 1:
					players.playSound(players.getLocation(), Sound.MUSIC_DISC_WAIT, SoundCategory.MASTER, 1000.0f, 1.0f);
					break;

				case 2:
					players.playSound(players.getLocation(), Sound.MUSIC_MENU, SoundCategory.MASTER, 1000.0f, 1.0f);
					break;

				default:
					players.playSound(players.getLocation(), Sound.ENTITY_GENERIC_DEATH, SoundCategory.MASTER, 1000.0f, 1.0f);
			}
		}
	}
}