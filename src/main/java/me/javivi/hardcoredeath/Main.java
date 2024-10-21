package me.javivi.hardcoredeath;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() { this.getServer().getPluginManager().registerEvents(new Muerte(), this);
        // Mensaje de habilitar plugin
        System.out.println("Plugin HardcoreDeath habilitado - Javivi ^^");
    }
    @Override
    public void onDisable() {
        // Mensaje deshabilitar plugin
        System.out.println("Plugin HardcoreDeath deshabilitado - Javivi ^^");
    }
}
