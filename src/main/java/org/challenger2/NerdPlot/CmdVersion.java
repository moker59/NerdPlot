package org.challenger2.NerdPlot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class CmdVersion implements NerdPlotCommand {

	private final NerdPlotPlugin plugin;
	private static final String name = "version";
	private static final String permission = "nerdplot.version";

	public CmdVersion(NerdPlotPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission(permission)) {
			plugin.printUsage(sender);
			return;
		}
		
		PluginDescriptionFile desc = plugin.getDescription();
		sender.sendMessage(String.format("%sAuthor: %s%s%s, Version: %s%s",
				ChatColor.GREEN,
				ChatColor.AQUA,
				desc.getAuthors(),
				ChatColor.GREEN,
				ChatColor.AQUA,
				desc.getVersion()
				));
		return;
	}
	
	
	@Override
	public String getName() {
		return name;
	}
	

	@Override
	public void printUsage(CommandSender sender) {
		if(sender.hasPermission(permission)) {
			sender.sendMessage(ChatColor.GREEN + "/" + plugin.getName() + " " + name);
		}
	}

}
