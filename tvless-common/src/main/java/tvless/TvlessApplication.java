package tvless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;

public class TvlessApplication extends SpringApplication {
    private static final Log logger = LogFactory.getLog(TvlessApplication.class);

    public TvlessApplication(Class<?> configClass) {
        super(configClass);
    }

    @Override
    protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {
        super.configureProfiles(environment, args);

        logger.info("Activating standalone profile");
        environment.addActiveProfile(TvlessProfiles.STANDALONE);
    }
}
