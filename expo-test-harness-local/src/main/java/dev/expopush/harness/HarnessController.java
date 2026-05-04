package dev.expopush.harness;

import dev.expopush.api.AsyncNotificationService;
import dev.expopush.api.NotificationCommand;
import dev.expopush.api.NotificationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/harness")
@RequiredArgsConstructor
public class HarnessController {

    private final AsyncNotificationService notificationService;
    private final LoggingResultHandler resultHandler;

    @PostMapping("/send")
    public String send(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
        String corr = UUID.randomUUID().toString();
        notificationService.enqueue(new NotificationCommand(
            token, title, body, corr, Map.of(), LoggingResultHandler.HANDLER_ID
        ));
        return corr;
    }

    @GetMapping("/results")
    public List<NotificationResult> results() {
        return resultHandler.getResults();
    }
}
