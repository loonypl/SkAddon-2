package amao.krzysek.skaddon.conditions.folder;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;

public class FolderExists extends Condition {

    private Expression<?> folder;

    @Override
    public boolean check(Event e) {
        File folder = new File((String) this.folder.getSingle(e));
        if(folder.isDirectory() && folder.exists())
            return true;
        else return false;
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
