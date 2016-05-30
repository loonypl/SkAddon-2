package amao.krzysek.skaddon.effects.player;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class TeleportToWorld extends Effect {

    private Expression<?> player;
    private Expression<?> world;
    private Expression<?> location;

    @Override
    protected void execute(Event e) {
        Player player = Bukkit.getPlayer((String) this.player.getSingle(e));
        if(player != null) {
            World world = Bukkit.getWorld((String) this.world.getSingle(e));
            if(world != null) {
                if((String) this.location.getSingle(e) != null) {
                    double x, y, z;
                    String[] split = ((String) this.location.getSingle(e)).split(", ");
                    x = Double.parseDouble(split[0]);
                    y = Double.parseDouble(split[1]);
                    z = Double.parseDouble(split[2]);
                    player.teleport(new Location(world, x, y ,z));
                } else {
                    player.teleport(new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ()));
                }
            }
        }
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}
