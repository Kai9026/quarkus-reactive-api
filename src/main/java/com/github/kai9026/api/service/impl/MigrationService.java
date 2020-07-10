package com.github.kai9026.api.service.impl;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class MigrationService {
    
    @Inject
    Flyway flyway; 

    public void checkMigration() {
        log.info(flyway.info().current().getVersion().toString());
        log.info(Arrays.toString(flyway.info().all()));
    }
}