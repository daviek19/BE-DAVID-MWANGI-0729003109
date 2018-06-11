package com.cellulant.interview;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import static com.cellulant.interview.akka.SpringExtension.SPRING_EXTENSION_PROVIDER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterviewApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

    @Autowired
    private ActorSystem system;

    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }

    /**
     * This is the entry point of the application It will send all processing to
     * an Akka actor {@link ProcessSupervisor()} for concurrency
     *
     * @return
     * @throws Exception
     */
    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            ActorRef supervisorActor = system.actorOf(SPRING_EXTENSION_PROVIDER.get(system)
                    .props("ProcessSupervisor"), "process_supervisor");

            supervisorActor.tell("start-execution", ActorRef.noSender());
        };
    }
}
