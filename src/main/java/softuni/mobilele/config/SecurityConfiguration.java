package softuni.mobilele.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import softuni.mobilele.model.enums.UserRoleEnum;
import softuni.mobilele.repository.UserRepository;
import softuni.mobilele.service.impl.MobileleUserDetailsService;

import static softuni.mobilele.config.constants.SecurityConstants.*;

@Configuration
public class SecurityConfiguration {


    private final String rememberMeKey;

    public SecurityConfiguration(@Value("${mobilele.remember.me.key}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      return   httpSecurity.authorizeHttpRequests(
                // Define which URLs are visible by which Users
                authorizeRequests -> authorizeRequests
                        // All static resources are available for anyone.
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        //Allow anyone to see the home,login and registration pages.
                        .requestMatchers(HOME_PAGE, LOGIN_PAGE, REGISTER_PAGE, LOGIN_ERROR_PAGE).permitAll()
                        .requestMatchers(ALL_OFFERS_PAGE).permitAll()
                        .requestMatchers(ADD_BRAND_PAGE).hasRole(UserRoleEnum.ADMIN.name())
                        //All any requests are authenticated.
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            // redirect here when we access something which is not allowed.
                            // also this is the page where we perform login.
                            .loginPage(LOGIN_PAGE)
                            // The names of the input fields (in our case in auth-login.html)
                            .usernameParameter(EMAIL)
                            .passwordParameter(PASSWORD)
                            .defaultSuccessUrl(HOME_PAGE)
                            .failureUrl(LOGIN_ERROR_PAGE);
                }
        ).logout(
                logout -> {
                    // the URL where we should POST something in order to perform the logout
                    logout.logoutUrl(LOGOUT)
                            //Where to go when logged out.
                            .logoutSuccessUrl(HOME_PAGE)
                            // delete the HTTP session
                            .invalidateHttpSession(true);
                }
        ).rememberMe(
                      rememberMe -> {
                          rememberMe.key(rememberMeKey)
                                  .rememberMeParameter(REMEMBER_ME)
                                  .rememberMeCookieName(REMEMBER_ME);
                      }
              )

              .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        //This service translates the mobilele users and roles
        // to representation which spring security understands.
        return new MobileleUserDetailsService(userRepository);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }


}
