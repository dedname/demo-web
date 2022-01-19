package com.demo.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.util.ResultsUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

//Class for pretty Selenide actions in allure report
public class SelenideListener implements LogEventListener {

    private final List<EventFormatter> formatters = getDefaultFormatters();

    private final AllureLifecycle lifecycle = Allure.getLifecycle();

    @Override
    public void afterEvent(LogEvent event) {
        getFormatter(event).ifPresent(formatter -> {
            String title = formatter.format(event);
            String stepUUID = UUID.randomUUID().toString();
            lifecycle.startStep(stepUUID, new StepResult().setName(title).setStatus(Status.PASSED));
            if (event.getStatus().equals(LogEvent.EventStatus.FAIL)) {
                lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
                lifecycle.updateStep(stepUUID, stepResult -> {
                    StatusDetails details = ResultsUtils.getStatusDetails(event.getError())
                            .orElse(new StatusDetails());
                    stepResult.setStatus(ResultsUtils.getStatus(event.getError()).orElse(Status.BROKEN));
                    stepResult.setStatusDetails(details);
                });
            }
            lifecycle.stopStep(stepUUID);
        });
    }

    private Optional<EventFormatter> getFormatter(LogEvent event) {
        return formatters.stream()
                .filter(f -> f.match(event))
                .findFirst();
    }

    private List<EventFormatter> getDefaultFormatters() {
        List<EventFormatter> formatters = new ArrayList<>();
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) click\\(\\)"),
                "Click on element ${element}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) text\\(\\)"),
                "Get element text ${element}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) should have\\((?<condition>.*)\\)"),
                "Check element ${element} has ${condition}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) should have\\((?<condition>((.*\n)+(.*)))\\)"),
                "Check element ${element} has ${condition}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) set value\\((?<value>.*)\\)"),
                "Set value [${value}] in element ${element}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) click \\(()\\)"),
                "Click on element ${element}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) clear\\(\\)"),
                "Clear element ${element}"
        ));
        formatters.add(new EventFormatter(
                Pattern.compile("\\$\\((?<element>.*)\\) hover\\(\\)"),
                "Focus mouse on element ${element}"
        ));
        return formatters;
    }

    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void beforeEvent(LogEvent currentLog) {

    }

    protected class EventFormatter {

        private final Pattern pattern;

        private final String replacement;

        EventFormatter(Pattern pattern, String replacement) {
            this.replacement = replacement;
            this.pattern = pattern;
        }

        boolean match(LogEvent event) {
            return pattern.matcher(event.toString()).find();
        }

        public String format(LogEvent event) {
            return pattern.matcher(event.toString()).replaceAll(replacement);
        }
    }


}
