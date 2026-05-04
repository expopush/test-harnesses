package dev.expopush.harness;

import dev.expopush.api.NotificationResult;
import dev.expopush.api.NotificationResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class LoggingResultHandler implements NotificationResultHandler {

    public static final String HANDLER_ID = "loggingResultHandler";
    private final List<NotificationResult> results = Collections.synchronizedList(new ArrayList<>());

    @Override
    public String handlerId() {
        return HANDLER_ID;
    }

    @Override
    public void handleResult(NotificationResult result) {
        log.info("Outcome received: correlationId={}, outcome={}, error={}", 
            result.correlationId(), result.outcome(), result.errorDetail());
        results.add(result);
    }

    public List<NotificationResult> getResults() {
        return new ArrayList<>(results);
    }

    public void clear() {
        results.clear();
    }
}
