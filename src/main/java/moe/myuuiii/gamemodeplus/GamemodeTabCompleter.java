package moe.myuuiii.gamemodeplus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class GamemodeTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		ArrayList<String> results = new ArrayList<>();
		if (args.length == 1) {
			results.add("Creative");
			results.add("Survival");
			results.add("Adventure");
			results.add("Spectator");
		} else if (args.length == 2) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				results.add(player.getName());
			}
		}
		return results;
	}

}
