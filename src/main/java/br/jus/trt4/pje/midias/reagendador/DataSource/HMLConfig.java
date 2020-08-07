package br.jus.trt4.pje.midias.reagendador.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static br.jus.trt4.pje.midias.reagendador.Properties.ENTITY_PACKAGES;

/**
 * Configuration for the {@link hml} slice of the system. A dedicated {@link DataSource},
 * {@link JpaTransactionManager} and {@link EntityManagerFactory}. Note that there could of course be some deduplication
 * with {@link example.springdata.jpa.multipleds.order.OrderConfig}. I just decided to keep it to focus on the
 * sepeartion of the two. Also, some overlaps might not even occur in real world scenarios (whether to create DDl or the
 * like).
 *
 * @author Oliver Gierke
 */
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "hmlEntityManagerFactory", transactionManagerRef =
//        "hmlTransactionManager")
public class HMLConfig {

    @Bean
    PlatformTransactionManager hmlTransactionManager() {
        return new JpaTransactionManager(hmlEntityManagerFactory().getObject());
    }

//    @Bean
//    EntityManagerFactory entityManagerFactory() {
//        EnMF
//        return (EntityManagerFactory) hmlEntityManagerFactory();
//    }

    @Bean
    LocalContainerEntityManagerFactoryBean hmlEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(hmlDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(ENTITY_PACKAGES);

        return factoryBean;
    }

    @Bean
    DataSource hmlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://pje04-midias-db.trt4.gov.br/hml");
        dataSourceBuilder.username("spe");
        dataSourceBuilder.password("mbeBhSsdE2.");
        return dataSourceBuilder.build();

        //        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .setName("hmls")
//                .build();
    }
}
