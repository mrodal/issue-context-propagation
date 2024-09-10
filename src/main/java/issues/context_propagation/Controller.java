package issues.context_propagation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController

public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public void test() {
        log.info("log 1 {}", MDC.getCopyOfContextMap().toString());

        var sink = Sinks.one();

        sink.asMono().flatMap(s->{
            log.info("log 2 {}", MDC.getCopyOfContextMap().toString());
            return Mono.empty();
        }).subscribe();

        sink.emitValue("", Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
