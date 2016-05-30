package amao.krzysek.skaddon.conditions.file;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class FileExists extends Condition {

    private Expression<?> file;

    @Override
    public boolean check(Event e) {
        File file = new File((String) this.file.getSingle(e));
        if(file.isFile() && file.exists())
            return true;
        else return false;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        file = expr[0];
        return true;
    }
}
