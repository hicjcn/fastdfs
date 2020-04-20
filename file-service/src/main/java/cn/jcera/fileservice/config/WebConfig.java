package cn.jcera.fileservice.config;

import cn.jcera.fileservice.core.version.VersionHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /*增加ajax跨域访问支持*/
    @Override
    protected void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedMethods("get","post")
                .allowedOrigins("*")
                .allowedHeaders("*");
//         super.addCorsMappings(registry);
    }

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     * 需要重新指定静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /*设置默认首页*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addRedirectViewController("/","/swagger-ui.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new VersionHandlerMapping("v");
        handlerMapping.setOrder(0);

        AntPathMatcher pathMatcher = new AntPathMatcher();
        pathMatcher.setCaseSensitive(false);
        handlerMapping.setPathMatcher(pathMatcher);
        return handlerMapping;
    }

}
