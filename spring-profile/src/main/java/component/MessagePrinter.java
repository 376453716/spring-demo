package component;

import com.xh.service.MessageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Xiong Hao
 */
@Component
public class MessagePrinter {

    private static final Log log = LogFactory.getLog(MessagePrinter.class);

    @Autowired
    private MessageService messageService;

    public void printMessage() {
        System.out.println(messageService.message());
        log.info("log===>" + messageService.message());
    }

}
