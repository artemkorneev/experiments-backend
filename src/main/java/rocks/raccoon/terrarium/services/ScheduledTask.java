package rocks.raccoon.terrarium.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rocks.raccoon.terrarium.model.Greeting;

@Component
public class ScheduledTask {

    @Autowired
    private SimpMessagingTemplate template;

    private CompilerService compilerService = new CompilerService();

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    @SendTo("/topic/greetings")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        var text = new Greeting("The time is now " + dateFormat.format(new Date()));
        var codeResult =  new Greeting( compilerService.foo() );
        log.info("Code result:", codeResult);
        template.convertAndSend("/topic/greetings", text);
        template.convertAndSend("/topic/greetings", codeResult);
    }
}