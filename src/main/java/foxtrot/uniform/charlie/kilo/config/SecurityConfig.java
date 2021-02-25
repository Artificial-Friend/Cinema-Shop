package foxtrot.uniform.charlie.kilo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.POST,"/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/ships/*").hasAuthority("USER")
                .antMatchers(HttpMethod.GET, "/orders").hasAuthority("USER")
                .antMatchers(HttpMethod.POST, "/orders/complete").hasAuthority("USER")
                .antMatchers(HttpMethod.POST, "/shopping-carts/flights").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
