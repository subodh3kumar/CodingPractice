package workshop.runner;

import io.cucumber.core.cli.Main;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLoadProcessRunner {

    public static void main(String[] args) {
        log.info("main() method called");
        String[] arguments = {
                "--glue", "workshop/stepDefinitions", "src/main/resources/features/FileLoadProcess.feature",
                "--plugin", "html:/Development/Files/Output/Cucumber/file-load-process-report.html"
        };
        Main.run(arguments);
    }
}
