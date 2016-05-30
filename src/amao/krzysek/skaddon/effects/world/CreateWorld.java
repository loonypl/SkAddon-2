package amao.krzysek.skaddon.effects.world;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.event.Event;

public class CreateWorld extends Effect {

    private Expression<?> name;
    private Expression<?> worldType;

    @Override
    protected void execute(Event e) {
        String name = (String) this.name.getSingle(e);
        if((String) this.worldType.getSingle(e) != null) {
            String worldType = (String) this.worldType.getSingle(e);
            WorldType wt;
            if(worldType.equalsIgnoreCase("normal")) wt = WorldType.NORMAL;
            else if(worldType.equalsIgnoreCase("flat")) wt = WorldType.FLAT;
            else if(worldType.equalsIgnoreCase("amplified")) wt = WorldType.AMPLIFIED;
            else if(worldType.equalsIgnoreCase("large_biomes")) wt = WorldType.LARGE_BIOMES;
            else if(worldType.equalsIgnoreCase("version_1_1")) wt = WorldType.VERSION_1_1;
            else wt = WorldType.NORMAL;
            Bukkit.getServer().createWorld(new WorldCreator(name).type(wt));
        } else {
            Bukkit.getServer().createWorld(new WorldCreator(name));
        }
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        name = expr[0];
        worldType = expr[1];
        return true;
    }

}
