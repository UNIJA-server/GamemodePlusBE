package moe.myuuiii.gamemodeplus;

import net.md_5.bungee.api.ChatColor;

public class Messages {
	public static final String Prefix = ChatColor.WHITE + "[" + ChatColor.WHITE + "Сервер" + ChatColor.WHITE + "]"
			+ " ";
	public static final String NotAPlayer = Prefix + "Вы павінны выконваць каманду як гулец.";
	public static final String NotAllowedToUsePlugin = Prefix + "Вы не маеце дазволу пераключаць рэжым гульні.";
	public static final String GamemodeNotRecognized = Prefix + "Няправільны рэжым гульні.";
	public static final String AlreadyInGamemode = Prefix + "Вы ўжо у гэтым рэжыме гульні.";
	public static final String PlayerNotFound = Prefix + "Гулец не знойдзены";
	public static final String NotAllowedToChangeForOthers = Prefix
			+ "Вы не маеце дазволу на пераключэнне рэдыму гульні для іншых гульцоў.";

	public static final String CurrentGamemodeIs = Prefix + "Вы зараз у рэжыме ";
	public static final String GamemodeChangedTo = Prefix + "Рэжым гульні зменены на ";
	public static final String NoPermissionToChangeTo = Prefix + "Вы не маеце дазволу пераключаць рэжым гульні на ";
	public static final String NoPermissionToChangeToForOther = Prefix
			+ "Вы не маеце дазволу на пераключенне рэжыму гульні. ";

	public static final String GamemodeCreative = ChatColor.GREEN + "Творчы";
	public static final String GamemodeSurvival = ChatColor.RED + "Выжыванне";
	public static final String GamemodeAdventure = ChatColor.GOLD + "Прыгоды";
	public static final String GamemodeSpectator = ChatColor.BLUE + "Назіральнік";
}
