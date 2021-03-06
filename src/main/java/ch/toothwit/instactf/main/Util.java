package ch.toothwit.instactf.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Util {
	public static void SendToBungeeServer(final String server, final Player player) { 
		new BukkitRunnable() { 
			
			public void run() {
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(b);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF(server);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                if (b != null) {
                    player.sendPluginMessage(Instactf.get(), "BungeeCord", b.toByteArray());
                }
            }
        }.runTaskLater(Instactf.get(), 20L); 
	} 
	
	public static Block CreateFlag(Location location, Team team){ 
		Block block = location.getBlock(); 
		block.setType(Material.STANDING_BANNER); 
		Banner banner = (Banner)block.getState(); 
		banner.setBaseColor(Team.FlagColors[team.Identifier]); 
		return block; 
	}
}
