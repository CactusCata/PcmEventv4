package fr.cactuscata.pcmeventv4;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cactuscata.pcmeventv4.command.notsimplecmd.physic.PhysicCmd;
import fr.cactuscata.pcmeventv4.command.notsimplecmd.physic.PhysicFile;
import fr.cactuscata.pcmeventv4.command.simplecmd.SpeedCmd;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.DelWarpCmd;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.SetWarpCmd;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.WarpCmd;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.WarpFile;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.WarpInfoCmd;
import fr.cactuscata.pcmeventv4.command.simplecmd.warp.WarpsCmd;
import fr.cactuscata.pcmeventv4.listener.PhysicListener;
import fr.cactuscata.pcmeventv4.utils.bukkit.Tps;

public final class PcmEventv4 extends JavaPlugin {

	private static Plugin plugin;

	private WarpFile warpFile;
	private PhysicFile physicFile;

	{
		plugin = this;
	}

	@Override
	public void onEnable() {

		this.warpFile = new WarpFile();
		this.physicFile = new PhysicFile();

		Bukkit.getScheduler().runTaskTimer(this, new Tps(), 0L, 1L);
		
		super.getServer().getPluginManager().registerEvents(new PhysicListener(this.physicFile), this);

		super.getCommand("speed").setExecutor(new SpeedCmd());
		super.getCommand("physic").setExecutor(new PhysicCmd(this.physicFile));
		super.getCommand("setwarp").setExecutor(new SetWarpCmd(this.warpFile));
		super.getCommand("delwarp").setExecutor(new DelWarpCmd(this.warpFile));
		super.getCommand("warp").setExecutor(new WarpCmd(this.warpFile));
		super.getCommand("warps").setExecutor(new WarpsCmd(this.warpFile));
		super.getCommand("warpinfo").setExecutor(new WarpInfoCmd(this.warpFile));

	}

	@Override
	public void onDisable() {
		this.warpFile.update();
		this.physicFile.update();
	}

	public static Plugin getPlugin() {
		return PcmEventv4.plugin;
	}

}
