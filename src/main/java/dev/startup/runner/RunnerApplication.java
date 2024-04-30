package dev.startup.runner;

import dev.startup.runner.run.Location;
import dev.startup.runner.run.Run;
import foo.bar.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerApplication {
    private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);

        var message = new WelcomeMessage();
        System.out.println(message.getWelcomeMessage());
        log.info("app starts successfully ");


    }
//    @Bean
//    CommandLineRunner runner(){
//        return args -> {
//            Run run = new Run(1,
//                    "First Run",
//                    LocalDateTime.now(),
//                    LocalDateTime.now().plusHours(1),
//                    5,
//                    Location.OUTDOOR);
//            log.info("Run : " + run);
//        };
//    }

}
