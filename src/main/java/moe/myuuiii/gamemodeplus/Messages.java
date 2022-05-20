package moe.myuuiii.gamemodeplus;

import org.checkerframework.checker.units.qual.Prefix;

import net.md_5.bungee.api.ChatColor;

public class Messages {
	public static final String Prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "Gamemode+" + ChatColor.GRAY + "]"
			+ " ";
	public static final String NotAPlayer = Prefix + "You can only execute this command as a player";
	public static final String NotAllowedToUsePlugin = Prefix + "You are not allowed to make use of this plugin";
	public static final String GamemodeNotRecognized = Prefix + "The gamemode you provided was not recognized";
	public static final String AlreadyInGamemode = Prefix + "You are already in that gamemode";
	public static final String PlayerNotFound = Prefix + "That player could not be found";
	public static final String NotAllowedToChangeForOthers = Prefix
			+ "You are not allowed to change the gamemode of other players";

	public static final String CurrentGamemodeIs = Prefix + "Your current gamemode is ";
	public static final String GamemodeChangedTo = Prefix + "Gamemode changed to ";
	public static final String NoPermissionToChangeTo = Prefix + "You are not allowed to change your gamemode to ";
	public static final String NoPermissionToChangeToForOther = Prefix
			+ "You are not allowed to change this person's gamemode to ";

	public static final String GamemodeCreative = ChatColor.GREEN + "Creative";
	public static final String GamemodeSurvival = ChatColor.RED + "Survival";
	public static final String GamemodeAdventure = ChatColor.GOLD + "Adventure";
	public static final String GamemodeSpectator = ChatColor.BLUE + "Spectator";
}
