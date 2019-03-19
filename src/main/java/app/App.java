package app;/**
 * Create by hongcq on 2019/3/19
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:05
 *@ClassName App
 */
//扫描包
@ComponentScan(basePackages = {"controller", "service"})
//扫描dao层
@MapperScan(basePackages = {"dao"})
@SpringBootApplication
@Configuration
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
