package tvless;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

public abstract class DatabaseConfig {
    @Bean
    public abstract DataSource dataSource();

    protected void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(8);
        dataSource.setMinIdle(8);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
    }
}

@Configuration
@Profile(TvlessProfiles.STANDALONE)
class StandaloneDatabaseConfig extends DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:tvless;MODE=PostgreSQL");
        dataSource.setUsername("tv");
        dataSource.setPassword("");
        dataSource.setValidationQuery("SELECT 1");
        configureDataSource(dataSource);

        return dataSource;
    }
}
