package moe.myuuiii.gamemodeplus;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender && args.length == 2) {
			changeGamemode(sender, args);
			return false;
		}

		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.NotAPlayer);
			return false;
		}

		Player player = (Player) sender;

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
			changeGamemode(sender, args);
			return false;
		}

		return false;
	}

	private void changeGamemode(CommandSender sender, String[] args) {
		Player targetPlayer;
		if (!sender.hasPermission(Permissions.GamemodeForOthers)) {
			sender.sendMessage(Messages.NotAllowedToChangeForOthers);
			return;
		}

		GameMode selectedGamemode = GetGamemodeFromString(args[0].toLowerCase());
		if (selectedGamemode == null) {
			sender.sendMessage(Messages.GamemodeNotRecognized);
			return;
		}

		targetPlayer = Bukkit.getPlayer(args[1]);

		if (targetPlayer == null) {
			sender.sendMessage(Messages.PlayerNotFound);
			return;
		}

		if (IsAllowedToChangeTo(sender, selectedGamemode)) {
			sender.sendMessage(Messages.Prefix + "You changed " + ChatColor.YELLOW + targetPlayer.getName()
					+ ChatColor.RESET + "'s gamemode to "
					+ GetGamemodeString(selectedGamemode));
			targetPlayer.sendMessage(Messages.Prefix + ChatColor.YELLOW + sender.getName() + ChatColor.RESET
					+ " changed your gamemode to "
					+ GetGamemodeString(selectedGamemode));
			targetPlayer.setGameMode(selectedGamemode);
        } else {
			sender.sendMessage(Messages.NoPermissionToChangeToForOther + GetGamemodeString(selectedGamemode));
        }
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

	public boolean IsAllowedToChangeTo(CommandSender commandSender, GameMode gamemode) {
        switch (gamemode) {
			case CREATIVE:
				return commandSender.hasPermission(Permissions.SetToCreative);
			case SURVIVAL:
				return commandSender.hasPermission(Permissions.SetToSurvival);
			case ADVENTURE:
				return commandSender.hasPermission(Permissions.SetToAdventure);
			case SPECTATOR:
				return commandSender.hasPermission(Permissions.SetToSpectator);
			default:
				return false;
		}
	}

}
