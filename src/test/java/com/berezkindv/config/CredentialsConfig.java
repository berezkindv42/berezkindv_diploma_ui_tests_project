package com.berezkindv.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties"
})
public interface CredentialsConfig extends Config {

    @Key("user.email")
    String userEmail();

    @Key("user.password")
    String userPassword();

    @Key("to.email")
    String toEmail();
}

