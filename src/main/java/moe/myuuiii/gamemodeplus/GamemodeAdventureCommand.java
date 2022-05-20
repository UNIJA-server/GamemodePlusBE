package moe.myuuiii.gamemodeplus;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class GamemodeAdventureCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.NotAPlayer);
			return false;
		}

		Player player = (Player) sender;

		if (!player.hasPermission(Permissions.UsePlugin)) {
			player.sendMessage(Messages.NotAllowedToUsePlugin);
			return false;
		}

		if (!player.hasPermission(Permissions.SetToAdventure)) {
			player.sendMessage(Messages.NoPermissionToChangeTo + Messages.GamemodeAdventure);
			return false;
		}

		player.setGameMode(GameMode.ADVENTURE);
		player.sendMessage(Messages.GamemodeChangedTo + Messages.GamemodeAdventure);

		return false;
	}
}
