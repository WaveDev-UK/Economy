package me.dan.economy.manager;

import me.dan.economy.Economy;
import me.dan.pluginapi.manager.Manager;
import me.dan.pluginapi.sql.SQLClient;
import me.dan.pluginapi.sql.SQLRow;

import java.util.List;
import java.util.UUID;

public class EconomyManager extends Manager<UUID, EconomyUser> {

    public void init() {
        SQLClient sqlClient = Economy.getInstance().getSqlClient();
        List<SQLRow> sqlRowList = sqlClient.fetchDataMultiple("user_balances", new String[]{"*"});
        for (SQLRow sqlRow : sqlRowList) {
            UUID uuid = UUID.fromString((String) sqlRow.getData().get("id"));
            double balance = (Double) sqlRow.getData().get("balance");
            insert(uuid, new EconomyUser(uuid, balance));
        }
    }

    public void createAccount(UUID uuid, double balance) {
        if (super.get(uuid) != null) {
            return;
        }

        EconomyUser economyUser = new EconomyUser(uuid, 0);



        insert(uuid, economyUser);


    }


}
