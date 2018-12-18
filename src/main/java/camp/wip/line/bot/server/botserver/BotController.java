package camp.wip.line.bot.server.botserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/")
    public ResponseEntity<String> test(@RequestBody String request) {
        logger.info(request);
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
