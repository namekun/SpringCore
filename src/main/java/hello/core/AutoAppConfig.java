package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "hello\\.core\\.carTest\\..*"),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 기존에 만든 다른 config 클래스가 빈으로 등록되는 것을 막기 위해서 제외시킨다.
        })
public class AutoAppConfig {

}
