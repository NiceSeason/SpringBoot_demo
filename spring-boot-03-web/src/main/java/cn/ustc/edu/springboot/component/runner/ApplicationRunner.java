package cn.ustc.edu.springboot.component.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run....");
        System.out.println("getSourceArgs:"+args.getSourceArgs());
        System.out.println("getNonOptionArgs"+args.getNonOptionArgs());
        System.out.println("getOptionNames"+args.getOptionNames());
    }
}
