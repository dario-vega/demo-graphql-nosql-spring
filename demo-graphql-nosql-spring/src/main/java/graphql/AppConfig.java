package graphql;

import oracle.nosql.driver.NoSQLHandleConfig;
import oracle.nosql.driver.Region;
import oracle.nosql.driver.iam.SignatureProvider;
import com.oracle.nosql.spring.data.config.AbstractNosqlConfiguration;
import com.oracle.nosql.spring.data.config.NosqlDbConfig;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oracle.nosql.driver.kv.StoreAccessTokenProvider;
import org.springframework.beans.factory.annotation.Value;

    @Configuration
    @EnableNosqlRepositories
    public class AppConfig extends AbstractNosqlConfiguration {  
        @Value("${nosql.nosqlendpoint}")
        private String NOSQL_ENDPOINT;

        @Bean
        public NosqlDbConfig nosqlDbConfig() 
            throws java.io.IOException {              
            System.out.println (NOSQL_ENDPOINT);
            return new NosqlDbConfig(OCI_REGION,  new StoreAccessTokenProvider());
        }
    }
