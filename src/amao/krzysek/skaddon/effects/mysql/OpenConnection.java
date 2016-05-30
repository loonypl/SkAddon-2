package amao.krzysek.skaddon.effects.mysql;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class OpenConnection extends Effect {

    private Expression<?> host, port, database, user, password;

    @Override
    protected void execute(Event e) {
        MySQL mysql = new MySQL();
        mysql.openConnection((String) host.getSingle(e), (String) port.getSingle(e), (String) database.getSingle(e), (String) user.getSingle(e), (String) password.getSingle(e));
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        host = expr[0];
        port = expr[1];
        database = expr[2];
        user = expr[3];
        password = expr[4];
        return true;
    }

}
