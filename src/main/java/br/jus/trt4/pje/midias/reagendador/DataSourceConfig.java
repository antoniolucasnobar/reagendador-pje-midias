package br.jus.trt4.pje.midias.reagendador;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
//    spring.datasource.url=jdbc:mysql://pje04-midias-db.trt4.gov.br/hml
//    spring.datasource.username=spe
//    spring.datasource.password=mbeBhSsdE2.
//            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//    spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect


//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://pje04-midias-db.trt4.gov.br/hml");
//        dataSourceBuilder.username("spe");
//        dataSourceBuilder.password("mbeBhSsdE2.");
//        return dataSourceBuilder.build();
//    }
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(Properties.getUrlDB());
        dataSourceBuilder.username(Properties.getUserDB());
        dataSourceBuilder.password(Properties.getPassDB());
        return dataSourceBuilder.build();
    }
}