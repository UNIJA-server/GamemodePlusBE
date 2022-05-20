package moe.myuuiii.gamemodeplus;

import org.bukkit.plugin.java.JavaPlugin;

public final class GamemodePlus extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());

        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());

        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
