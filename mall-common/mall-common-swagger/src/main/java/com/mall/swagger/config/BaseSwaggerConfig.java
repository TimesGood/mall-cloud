package com.mall.swagger.config;

import com.mall.swagger.config.properties.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Swagger配置类
 * 默认访问地址
 * http://localhost:8080/swagger-ui/index.html
 */
@Configuration
@EnableOpenApi
public class BaseSwaggerConfig {
    /**
     * 生成Api文档界面的配置
     * 默认配置，一些描述信息将根据启动模块中的swaggerProperties中获取
     * 如果需要拓展多分组Api，请重写该方法，并且Bean与分组名都必须与其他模块不同
     * 如果还想保留该默认规则，请调用createDocker构造其他Api分组
     * @return
     */
    @ConditionalOnMissingBean(Docket.class)
    public Docket defaultApi(){
        SwaggerProperties build = SwaggerProperties.builder()
                .groupName("defaultApi")
                .applicationName("后台管理系统")
                .version("1.0")
                .description("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .build();
        return createDocket(build);
    }

    public Docket createDocket(SwaggerProperties swaggerProperties) {
        return new Docket(DocumentationType.OAS_30)//Swagger样式类型
                .groupName(swaggerProperties.getGroupName())
                //是否开启swagger，留给配置文件判定
//                .enable(enable)
                //页面详细
                .apiInfo(apiInfo(swaggerProperties))
                //选择哪些接口作为doc发布
                .select()
                //为指定包下controller生成API文档
//                .apis(RequestHandlerSelectors.basePackage("com.example.mall_study.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //扫描路径，对所有目录扫描
                .paths(PathSelectors.any())
                .build()
                //支持的通讯协议
                .protocols(new LinkedHashSet<>(Arrays.asList("https", "http")))
                //授权信息设置，必要的header token等认证信息
                .securitySchemes(securitySchemes())
                //授权信息应用的接口路径
                .securityContexts(securityContexts());
    }

    /**
     * 写入Api描述信息
     */
    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getApplicationName())
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl("服务条款：xxx")
                .contact(new Contact("张文科","https://github.com/TimesGood/mall_study","2907520924@qq.com"))
                .version(swaggerProperties.getVersion())
                .build();
    }

    /**
     * 设置授权信息
     * 设置请求头，当一个请求发出时，需要在请求头写携带Authorization这个来确认可以访问
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        //name：jwt参数名，也是储存token的key，keyname:与name保持一致，passAs存放位置
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     * 设置需要token信息认证的路径
     * @return
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder().
                        securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("/brand/.*"))
                        .build());

    }


    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        SecurityReference.SecurityReferenceBuilder builder = new SecurityReference.SecurityReferenceBuilder();
        builder.reference("Authorization")
                .scopes(new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")});

        result.add(builder.build());
        return result;
    }

    @Bean("generateBeanPostProcessor")
    public BeanPostProcessor generateBeanPostProcessor(){
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null)
                        .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    assert field != null;
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
//    @Bean
//    public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier,
//                                                                         ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier,
//                                                                         EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
//                                                                         WebEndpointProperties webEndpointProperties, Environment environment) {
//        List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
//        Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
//        allEndpoints.addAll(webEndpoints);
//        allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
//        allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
//        String basePath = webEndpointProperties.getBasePath();
//        EndpointMapping endpointMapping = new EndpointMapping(basePath);
//        boolean shouldRegisterLinksMapping =
//                webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath)
//                        || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
//        return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes,
//                corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath),
//                shouldRegisterLinksMapping, null);
//    }
}
