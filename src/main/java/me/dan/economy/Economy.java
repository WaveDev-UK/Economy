package me.dan.economy;

import lombok.Getter;
import me.dan.economy.configuration.Config;
import me.dan.economy.manager.EconomyManager;
import me.dan.pluginapi.plugin.CustomPlugin;
import me.dan.pluginapi.sql.SQLClient;
import me.dan.pluginapi.sql.SQLColumn;
import me.dan.pluginapi.sql.SQLType;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Economy extends CustomPlugin {

    private SQLClient sqlClient;
    private EconomyManager economyManager;

    @Getter
    private static Economy instance;

    @Override
    public void enable() {
        instance = this;
        this.sqlClient = new SQLClient(this, Config.SQL_HOST.getString(), Config.SQL_PORT.getInt(), Config.SQL_DATABASE.getString(), Config.SQL_USERNAME.getString(), Config.SQL_PASSWORD.getString());
        this.economyManager = new EconomyManager();
        createTable();
    }

    @Override
    public void disable() {
        // Plugin shutdown logic
    }

    private void createTable(){
        this.sqlClient.createTable("user_balances", new SQLColumn("id", SQLType.TEXT), new SQLColumn("balance", SQLType.DOUBLE_PRECISION));
    }

}
