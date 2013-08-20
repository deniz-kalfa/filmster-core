package filmster.config

import de.neuland.jade4j.JadeConfiguration
import de.neuland.jade4j.spring.template.SpringTemplateLoader
import de.neuland.jade4j.spring.view.JadeViewResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
@ComponentScan(basePackages = 'filmster')
@EnableWebMvc
@ImportResource("classpath:applicationContext.xml")
public class AppConfig extends WebMvcConfigurationSupport {

  @Bean
  public SpringTemplateLoader templateLoader() {
    return new SpringTemplateLoader(basePath: "/WEB-INF/views/")
  }

  @Bean
  public JadeConfiguration configuration() {
    return new JadeConfiguration(prettyPrint: false, caching: false, templateLoader: templateLoader())
  }

  @Bean
  public JadeViewResolver viewResolver() {
   return new JadeViewResolver(configuration: configuration(), renderExceptions: true)
  }
}
