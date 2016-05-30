package amao.krzysek.skaddon;

import amao.krzysek.skaddon.register.Register;
import ch.njol.skript.Skript;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SkAddon extends JavaPlugin {

    private SkAddon instance;
    private Register register;

    @Override
    public void onEnable() {
        if(Bukkit.getServer().getPluginManager().getPlugin("Skript") == null)
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        else {
            Skript.registerAddon(this);
            Bukkit.getServer().getLogger().info("Addon - SkAddon - for Skript has been injected !");
            register = new Register();
            register.register(register.getEffects());
            register.register(register.getExpressions());
            register.register(register.getConditions());
            register.register(register.getEvents());
        }
    }

    @Override
    public void onDisable() {}

    public SkAddon() {}

    public SkAddon getInstance() {
        if(instance != null)
            return instance;
        else {
            instance = new SkAddon();
            return instance;
        }
    }

}
