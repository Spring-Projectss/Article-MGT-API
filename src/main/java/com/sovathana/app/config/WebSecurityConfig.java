package com.sovathana.app.config;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sovathana.app.auth.SimpleUrlAuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private SimpleUrlAuthSuccessHandler successHandler = new SimpleUrlAuthSuccessHandler();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic();
		http.authorizeRequests()
			.antMatchers("/swagger-ui.html", "/api/**")
			.hasAnyRole("DEVELOPER")
			.and().formLogin()
			.successHandler(successHandler)
            //.loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .deleteCookies("JESSIONID")
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("dev").password("admin").roles("DEVELOPER");
        auth.inMemoryAuthentication()
        	.withUser("DEVCAMBODIA").password("DEVCAMBODIA!@#$%^&*").roles("DEVELOPER");
        
    }
	
	public static void main(String[] args) {
		String username = "DEVCAMBODIA";
		String password = "DEVCAMBODIA!@#$%^&*";
		// Basic REVWQ0FNQk9ESUE6REVWQ0FNQk9ESUEhQCMkJV4mKg==
		String apiKey = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
		System.out.println(apiKey);
	}
}
