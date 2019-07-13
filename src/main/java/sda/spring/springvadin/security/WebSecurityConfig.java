package sda.spring.springvadin.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/cat").authenticated()
                .antMatchers("/hello").permitAll()
                .and()
                .csrf().disable();
        //zeby nie blokował dostępu pomiędzy aplikacjami,
        //w normalnej apce to trzeba by obwarunkować kogo wpuszcza
    }
}
