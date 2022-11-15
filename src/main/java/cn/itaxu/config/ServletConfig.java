package cn.itaxu.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Description: cn.itaxu.config
 * @author: Axu
 * @date:2022/11/13 21:59
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 加载spring配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 加载springMVC配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 设置哪些方法归属springMVC处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 处理POST请求中文乱码问题
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8");
        return new Filter[]{filter};
    }

}
