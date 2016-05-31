package amao.krzysek.skaddon.register;

import amao.krzysek.skaddon.conditions.file.FileExists;
import amao.krzysek.skaddon.conditions.folder.FolderExists;
import amao.krzysek.skaddon.conditions.player.IsInWorld;
import amao.krzysek.skaddon.effects.file.CreateFile;
import amao.krzysek.skaddon.effects.file.DeleteFile;
import amao.krzysek.skaddon.effects.folder.CreateFolder;
import amao.krzysek.skaddon.effects.folder.DeleteFolder;
import amao.krzysek.skaddon.effects.mysql.CloseConnection;
import amao.krzysek.skaddon.effects.mysql.OpenConnection;
import amao.krzysek.skaddon.effects.mysql.SendQuery;
import amao.krzysek.skaddon.effects.mysql.SendUpdate;
import amao.krzysek.skaddon.effects.player.*;
import amao.krzysek.skaddon.effects.server.Shutdown;
import amao.krzysek.skaddon.effects.world.CreateWorld;
import amao.krzysek.skaddon.expressions.player.InWorld;
import amao.krzysek.skaddon.expressions.player.Ping;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;

public class Register {

    public Register() {}

    public enum RegisterType {
        EFFECTS, EXPRESSIONS, CONDITIONS, EVENTS
    }

    public void register(RegisterType what) {
        if(what == RegisterType.EFFECTS) { // 22
            Skript.registerEffect(CreateFile.class, "(cf|create file)[ with path] %string%");
            Skript.registerEffect(CreateFolder.class, "(cfl|create folder)[ with path] %string%");
            Skript.registerEffect(DeleteFile.class, "(df|delete file)[ with path] %string%");
            Skript.registerEffect(DeleteFolder.class, "(dfl|delete folder)[ with path] %string%");
            Skript.registerEffect(Shutdown.class, "shutdown[ server] after %number% seconds");
            Skript.registerEffect(TeleportToWorld.class, "(tp|teleport|transport) %player% to world %string%[ and location-in %string%]");
            Skript.registerEffect(OpenAnvil.class, "(open|show) anvil (to|for) %player%");
            Skript.registerEffect(OpenBeacon.class, "(open|show) beacon (to|for) %player%");
            Skript.registerEffect(OpenBench.class, "(open|show) (craftingtable|bench|crafting|workbench) (to|for) %player%");
            Skript.registerEffect(OpenBrewing.class, "(open|show) (brewing|brewing stand) (to|for) %player%");
            Skript.registerEffect(OpenChest.class, "(open|show) chest (to|for) %player%");
            Skript.registerEffect(OpenCreative.class, "(open|show) creative (to|for) %player%");
            Skript.registerEffect(OpenDispenser.class, "(open|show) dispenser (to|for) %player%");
            Skript.registerEffect(OpenDropper.class, "(open|show) dropper (to|for) %player%");
            Skript.registerEffect(OpenEnchant.class, "(open|show) (enchant|enchanting table) (to|for) %player%");
            Skript.registerEffect(OpenEnderchest.class, "(open|show) enderchest (to|for) %player%");
            Skript.registerEffect(OpenFurnace.class, "(open|show) furnace (to|for) %player%");
            Skript.registerEffect(CreateWorld.class, "(create|make)[ new] world named %string%[ {WorldType=%string%}]");
            Skript.registerEffect(OpenConnection.class, "open mysql (conn|connection) %string% %string% %string% %string% %string%");
            Skript.registerEffect(CloseConnection.class, "(close|disconnect) mysql[ (conn|connection)]");
            Skript.registerEffect(SendQuery.class, "(send|execute) mysql query %string%");
            Skript.registerEffect(SendUpdate.class, "(send|execute) mysql update %string%");
        }
        else if(what == RegisterType.EXPRESSIONS) {
            Skript.registerExpression(InWorld.class, String.class, ExpressionType.SIMPLE, "[all ]player (in|at|on) world %string%");
            Skript.registerExpression(Ping.class, Integer.class, ExpressionType.SIMPLE, "(ping of %player%|%player%'[s] ping)");
        }
        else if(what == RegisterType.CONDITIONS) {
            Skript.registerCondition(FileExists.class, "file %string% exists");
            Skript.registerCondition(FolderExists.class, "folder %string% exists");
            Skript.registerCondition(IsInWorld.class, "%player% is (in|at|on) world %string%");
        }
        else if(what == RegisterType.EVENTS) {

        }
    }

    public RegisterType getExpressions() { return RegisterType.EXPRESSIONS; }
    public RegisterType getEffects() { return RegisterType.EFFECTS; }
    public RegisterType getConditions() { return RegisterType.CONDITIONS; }
    public RegisterType getEvents() { return RegisterType.EVENTS; }

}
