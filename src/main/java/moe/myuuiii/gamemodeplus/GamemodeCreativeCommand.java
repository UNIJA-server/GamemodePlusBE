package moe.myuuiii.gamemodeplus;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCreativeCommand implements CommandExecutor {

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

		if (!player.hasPermission(Permissions.SetToCreative)) {
			player.sendMessage(Messages.NoPermissionToChangeTo + Messages.GamemodeCreative);
			return false;
		}

		player.setGameMode(GameMode.CREATIVE);
		player.sendMessage(Messages.GamemodeChangedTo + Messages.GamemodeCreative);

		return false;
	}

}
