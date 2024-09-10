package issues.context_propagation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class IssueContextPropagationApplication {

    public static void main(String[] args) {
        Hooks.enableAutomaticContextPropagation(); // TODO comment this line and restart the application
        SpringApplication.run(IssueContextPropagationApplication.class, args);
    }

}
