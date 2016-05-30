package amao.krzysek.skaddon.effects.mysql;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class SendQuery extends Effect {

    private Expression<?> query;

    @Override
    protected void execute(Event e) {
        MySQL mysql = new MySQL();
        mysql.query((String) query.getSingle(e));
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        query = expr[0];
        return true;
    }

}
