package amao.krzysek.skaddon.effects.server;

import amao.krzysek.skaddon.SkAddon;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Shutdown extends Effect {

    private SkAddon skAddon;
    private Expression<?> time;

    @Override
    protected void execute(Event e) {
        skAddon = new SkAddon();
        int time = (int) this.time.getSingle(e);
        long timeLong = Long.parseLong(time + "") * 20L;
        BukkitTask task = new BukkitRunnable() {
            public void run() {
                Bukkit.getServer().shutdown();
            }
        }.runTaskLater(skAddon.getInstance(), timeLong);
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        time = expr[0];
        return true;
    }
}
