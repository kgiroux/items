package com.giroux.kevin.dofustuff.object.starter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"com.giroux.kevin.dofustuff.object"})
@EntityScan({"com.giroux.kevin.dofustuff.object"})
@EnableTransactionManagement
public class DbConfiguration {

}
