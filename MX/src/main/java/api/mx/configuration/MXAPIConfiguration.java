package api.mx.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MXAPIServiceConfiguration.class)
public class MXAPIConfiguration {
}
