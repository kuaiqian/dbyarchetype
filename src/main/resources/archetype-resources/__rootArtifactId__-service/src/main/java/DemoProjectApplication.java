#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.util.ErrorUtil;
import com.duobaoyu.middleware.common.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = RedisTemplateConfiguration.class, MessageConfiguration.class, JacksonConfiguration.class)
@ControllerAdvice
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@EnableMultiTenantApplication
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    /**
     * 全局异常处理
     *
     * @param ex
     *            Exception
     * @return R
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> defaultExceptionHandler(Exception ex) {
        return ErrorUtil.handException(ex);
    }
}
