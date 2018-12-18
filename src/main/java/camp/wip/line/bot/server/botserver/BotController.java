package camp.wip.line.bot.server.botserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class BotController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    public ResponseEntity<String> test(@RequestBody(required = false) Map<String, Object> body, HttpServletRequest request,
                                       HttpServletResponse response) {
        Enumeration<String> attr = request.getParameterNames();

        logger.info(body.values().toString());
        while(attr.hasMoreElements()){
            String param = attr.nextElement();
            String ss = request.getParameter(param);
            logger.info(param+": "+ss);
        }


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer s1dD+yfsd5oNC3jqqY6+SN50nWwbNFFOh1qiN6cCrCYfY4b5qpO8BdJNSHZ9nTxcxsopSytkx9OKsnjT5kPq/fPIBL3TYt6vPMNwG6pZRE5CttgajVjXBlik6D6niNQLyCyx1zpK+IDeHjS41kYkVAdB04t89/1O/w1cDnyilFU=");

        String url = "https://api.line.me/v2/bot/message/reply";
//        Map<String, Object> events = (Map)body.get("events");
        String replyToken = body.get("replyToken").toString();
        logger.info("replying to: "+replyToken);
        HttpEntity<String> entity = new HttpEntity<String>("{\"replyToken\":\""+replyToken+"\",\"messages\":[{\"type\":\"text\",\"text\":\"helloooo\"}]}", headers);

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
