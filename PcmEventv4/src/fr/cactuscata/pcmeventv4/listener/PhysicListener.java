package fr.cactuscata.pcmeventv4.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import fr.cactuscata.pcmeventv4.command.notsimplecmd.physic.PhysicFile;

public class PhysicListener implements Listener {

	private final PhysicFile physicFile;
	
	public PhysicListener(PhysicFile physicFile) {
		this.physicFile = physicFile;
	}

	@EventHandler
	public final void usePhysic(final BlockPhysicsEvent event) {
		if (!this.physicFile.isPhysicEnable() && this.physicFile.getList().contains(event.getBlock().getType()))
			event.setCancelled(true);
	}
	
}
