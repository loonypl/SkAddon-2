package amao.krzysek.skaddon.effects.player;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;

public class OpenDispenser extends Effect {

    private Expression<?> player;

    @Override
    protected void execute(Event e) {
        Player player = (Player) this.player.getSingle(e);
        player.openInventory(Bukkit.getServer().createInventory(null, InventoryType.DISPENSER));
    }

    @Override
    public String toString(Event e, boolean debug) {
        return getClass().getName();
    }

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = expr[0];
        return true;
    }

}
