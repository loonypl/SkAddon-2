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
import ch.njol.skript.Skript;

public class Register {

    public Register() {}

    public enum RegisterType {
        EFFECTS, EXPRESSIONS, CONDITIONS, EVENTS
    }

    public void register(RegisterType what) {
        if(what == RegisterType.EFFECTS) { // 22
            Skript.registerEffect(CreateFile.class, new String[] {"(cf|create file)[ with path] %string%"});
            Skript.registerEffect(CreateFolder.class, new String[] {"(cfl|create folder)[ with path] %string%"});
            Skript.registerEffect(DeleteFile.class, new String[] {"(df|delete file)[ with path] %string%"});
            Skript.registerEffect(DeleteFolder.class, new String[] {"(dfl|delete folder)[ with path] %string%"});
            Skript.registerEffect(Shutdown.class, new String[] {"shutdown[ server] after %number% seconds"});
            Skript.registerEffect(TeleportToWorld.class, new String[] {"(tp|teleport|transport) %player% to world %string%[ and location-in %string%]"});
            Skript.registerEffect(OpenAnvil.class, new String[] {"(open|show) anvil (to|for) %player%"});
            Skript.registerEffect(OpenBeacon.class, new String[] {"(open|show) beacon (to|for) %player%"});
            Skript.registerEffect(OpenBench.class, new String[] {"(open|show) (craftingtable|bench|crafting|workbench) (to|for) %player%"});
            Skript.registerEffect(OpenBrewing.class, new String[] {"(open|show) (brewing|brewing stand) (to|for) %player%"});
            Skript.registerEffect(OpenChest.class, new String[] {"(open|show) chest (to|for) %player%"});
            Skript.registerEffect(OpenCreative.class, new String[] {"(open|show) creative (to|for) %player%"});
            Skript.registerEffect(OpenDispenser.class, new String[] {"(open|show) dispenser (to|for) %player%"});
            Skript.registerEffect(OpenDropper.class, new String[] {"(open|show) dropper (to|for) %player%"});
            Skript.registerEffect(OpenEnchant.class, new String[] {"(open|show) (enchant|enchanting table) (to|for) %player%"});
            Skript.registerEffect(OpenEnderchest.class, new String[] {"(open|show) enderchest (to|for) %player%"});
            Skript.registerEffect(OpenFurnace.class, new String[] {"(open|show) furnace (to|for) %player%"});
            Skript.registerEffect(CreateWorld.class, new String[] {"(create|make)[ new] world named %string%[ {WorldType=%string%}]"});
            Skript.registerEffect(OpenConnection.class, new String[] {"open mysql (conn|connection) %string% %string% %string% %string% %string%"});
            Skript.registerEffect(CloseConnection.class, new String[] {"(close|disconnect) mysql[ (conn|connection)]"});
            Skript.registerEffect(SendQuery.class, new String[] {"(send|execute) mysql query %string%"});
            Skript.registerEffect(SendUpdate.class, new String[] {"(send|execute) mysql update %string%"});
        }
        else if(what == RegisterType.EXPRESSIONS) {

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
