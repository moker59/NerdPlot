package org.challenger2.NerdPlot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CmdCleanup extends NerdPlotCommand {

	private final String permission = "nerdplot.cleanup";

	public CmdCleanup(NerdPlotPlugin plugin) {
		super(plugin, "cleanup");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if (!sender.hasPermission(permission)) {
			plugin.printUsage(sender);
			return;
		}

		if (args.length != 0) {
			printUsage(sender);
			return;
		}
		
		plugin.cleanupDatabase(sender);
		plugin.saveMyConfig();
		sender.sendMessage(ChatColor.GREEN + "Cleanup Complete.");		
	}

	@Override
	public void printUsage(CommandSender sender) {
		if(sender.hasPermission(permission)) {
			sender.sendMessage(ChatColor.GREEN + "/" + plugin.getName() + " " + this.name);
		}
	}
}
