package moe.myuuiii.gamemodeplus;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.NotAPlayer);
			return false;
		}

		Player player = (Player) sender;
		Player targetPlayer = null;

		if (!player.hasPermission(Permissions.UsePlugin)) {
			player.sendMessage(Messages.NotAllowedToUsePlugin);
			return false;
		}

		if (args.length == 2) {
			if (Bukkit.getPlayer(args[1]).getName().equals(player.getName())) {
				args = new String[] { args[0] };
			}
		}

		// Querying gamemode
		if (args.length == 0) {
			String message = Messages.CurrentGamemodeIs;
			message += GetGamemodeString(player.getGameMode());
			player.sendMessage(message);
			return false;

		} else if (args.length == 1) {
			GameMode selectedGamemode = GetGamemodeFromString(args[0].toLowerCase());

			if (selectedGamemode == null) {
				player.sendMessage(Messages.GamemodeNotRecognized);
				return false;
			}

			if (selectedGamemode.equals(player.getGameMode())) {
				player.sendMessage(Messages.AlreadyInGamemode);
				return false;
			}

			if (IsAllowedToChangeTo(player, selectedGamemode)) {
				player.sendMessage(Messages.GamemodeChangedTo + GetGamemodeString(selectedGamemode));
				player.setGameMode(selectedGamemode);
				return false;
			} else {
				player.sendMessage(Messages.NoPermissionToChangeTo + GetGamemodeString(selectedGamemode));
				return false;
			}

		} else if (args.length == 2) {

			if (!player.hasPermission(Permissions.GamemodeForOthers)) {
				player.sendMessage(Messages.NotAllowedToChangeForOthers);
				return false;
			}

			GameMode selectedGamemode = GetGamemodeFromString(args[0].toLowerCase());
			if (selectedGamemode.equals(null)) {
				player.sendMessage(Messages.GamemodeNotRecognized);
				return false;
			}

			targetPlayer = Bukkit.getPlayer(args[1]);

			if (targetPlayer.equals(null)) {
				player.sendMessage(Messages.PlayerNotFound);
				return false;
			}

			if (IsAllowedToChangeTo(player, selectedGamemode)) {
				player.sendMessage(Messages.Prefix + "You changed " + ChatColor.YELLOW + targetPlayer.getName()
						+ ChatColor.RESET + "'s gamemode to "
						+ GetGamemodeString(selectedGamemode));
				targetPlayer.sendMessage(Messages.Prefix + ChatColor.YELLOW + player.getName() + ChatColor.RESET
						+ " changed your gamemode to "
						+ GetGamemodeString(selectedGamemode));
				targetPlayer.setGameMode(selectedGamemode);
				return false;
			} else {
				player.sendMessage(Messages.NoPermissionToChangeToForOther + GetGamemodeString(selectedGamemode));
				return false;
			}
		}

		return false;
	}

	public GameMode GetGamemodeFromString(String input) {
		switch (input) {
			case "creative":
			case "1":
			case "c":
				return GameMode.CREATIVE;
			case "survival":
			case "0":
			case "s":
				return GameMode.SURVIVAL;
			case "adventure":
			case "2":
			case "a":
				return GameMode.ADVENTURE;
			case "spectator":
			case "3":
			case "sp":
				return GameMode.SPECTATOR;
			default:
				return null;
		}
	}

	public String GetGamemodeString(GameMode gamemode) {
		switch (gamemode) {
			case CREATIVE:
				return Messages.GamemodeCreative;
			case SURVIVAL:
				return Messages.GamemodeSurvival;
			case ADVENTURE:
				return Messages.GamemodeAdventure;
			case SPECTATOR:
				return Messages.GamemodeSpectator;
			default:
				return "";
		}
	}

	public boolean IsAllowedToChangeTo(Player player, GameMode gamemode) {
		String permission = "";
		switch (gamemode) {
			case CREATIVE:
				return player.hasPermission(Permissions.SetToCreative);
			case SURVIVAL:
				return player.hasPermission(Permissions.SetToSurvival);
			case ADVENTURE:
				return player.hasPermission(Permissions.SetToAdventure);
			case SPECTATOR:
				return player.hasPermission(Permissions.SetToSpectator);
			default:
				return false;
		}
	}

}
