package amao.krzysek.skaddon.conditions.player;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class IsInWorld extends Condition {

    private Expression<?> player, check;

    @Override
    public boolean check(Event e) {
        Player player = (Player) this.player.getSingle(e);
        String check = (String) this.check.getSingle(e);
        if(player.getWorld().getName() != check)
            return false;
        else return true;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        check = expr[1];
        return true;
    }

}
