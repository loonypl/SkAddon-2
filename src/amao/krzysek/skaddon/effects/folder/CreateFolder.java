package amao.krzysek.skaddon.effects.folder;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class CreateFolder extends Effect {

    private Expression<?> name;

    @Override
    protected void execute(Event e) {
        File f = new File((String) name.getSingle(e));
        if(f.isDirectory() && !f.exists())
            f.mkdirs();
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        name = expr[0];
        return true;
    }

}
