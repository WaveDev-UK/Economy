package me.dan.economy.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.dan.pluginapi.configuration.Configuration;

@AllArgsConstructor
@Getter
public enum Config implements Configuration {

    SQL_USERNAME("sql.username", "root"),
    SQL_PASSWORD("sql.password", ""),
    SQL_HOST("sql.host", "localhost"),
    SQL_PORT("sql.port", 3306),
    SQL_DATABASE("sql.database", "database");


    private final String path;

    @Setter
    private Object value;


}
