package me.dan.economy.manager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import me.dan.economy.Economy;
import me.dan.pluginapi.sql.SQLClient;
import me.dan.pluginapi.sql.SQLData;
import me.dan.pluginapi.sql.SQLRequirement;
import me.dan.pluginapi.sql.SQLRow;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

@Getter
public class EconomyUser {

    @Setter
    private double balance = 0;

    private final UUID uuid;

    public EconomyUser(UUID uuid, double balance) {
        this.uuid = uuid;
        this.balance = balance;
    }


    public void save() {
        Bukkit.getScheduler().runTaskAsynchronously(Economy.getInstance(), () -> {
            SQLClient sqlClient = Economy.getInstance().getSqlClient();
            sqlClient.update("user_balances", new SQLData[]{new SQLData("balance", getBalance())}, new SQLRequirement[]{new SQLRequirement("id", uuid.toString())});
        });
    }

    public void insert(){
        Bukkit.getScheduler().runTaskAsynchronously(Economy.getInstance(), () -> {
            SQLClient sqlClient = Economy.getInstance().getSqlClient();

        });
    }

}
