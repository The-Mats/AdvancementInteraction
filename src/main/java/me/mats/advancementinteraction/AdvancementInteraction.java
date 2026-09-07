package me.mats.advancementinteraction;


import me.mats.advancementinteraction.testing.testCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class AdvancementInteraction extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.GREEN+"AdvancementInteraction API loaded");
        Objects.requireNonNull(getCommand("adv_test")).setExecutor(new testCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AdvancementInteraction getInstance() {
        return getPlugin(AdvancementInteraction.class);
    }

}
