package camp.wip.line.bot.server.botserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
public class BotController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    public ResponseEntity<String> test(HttpServletRequest request,
                                       HttpServletResponse response) {
        Enumeration<String> attr = request.getParameterNames();

        while(attr.hasMoreElements()){
            String param = attr.nextElement();
            String ss = request.getParameter(param);
            logger.info(param+": "+ss);
        }
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
