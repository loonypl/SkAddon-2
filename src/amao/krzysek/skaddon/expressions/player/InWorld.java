package amao.krzysek.skaddon.expressions.player;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class InWorld extends SimpleExpression<String> {

    private Expression<?> check;

    @Override
    protected String[] get(Event e) {
        String check = (String) this.check.getSingle(e);
        StringBuilder sb = new StringBuilder();
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            if(player.getWorld().getName().equalsIgnoreCase(check)) {
                sb.append(player.getName());
            }
        }
        return new String[] {sb.toString()};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        check = expr[0];
        return true;
    }

}
