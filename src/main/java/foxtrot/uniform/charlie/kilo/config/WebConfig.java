package foxtrot.uniform.charlie.kilo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"foxtrot.uniform.charlie.kilo.controller",
        "foxtrot.uniform.charlie.kilo.exception"})
public class WebConfig {
}
