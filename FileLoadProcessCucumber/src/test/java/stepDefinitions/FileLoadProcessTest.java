package stepDefinitions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
public class FileLoadProcessTest {

    private Path directory;
    private List<Path> files;

    @Given("browse the file {string}")
    public void browseFile(String location) {
        log.info("browseFile() method called");
        log.info("location: {}", location);

        this.directory = Paths.get(location);
        if (Files.exists(this.directory)) {
            log.info("directory exists");
        } else {
            log.error("directory does not exist");
            System.exit(0);
        }
    }

    @When("load the file")
    public void loadFile() {
        log.info("loadFile() method called");
        try {
            this.files = Files.list(directory).filter(Files::isRegularFile).collect(Collectors.toList());
            log.info("number of file available: {}", this.files.size());
        } catch (IOException e) {
            log.error("ERROR: ", e);
        }
    }

    @Then("get the file name")
    public void displayFileName() {
        log.info("displayFileName() method called");
        List<String> fileNames = this.files.stream().map(file -> file.getFileName().toString()).collect(Collectors.toList());
        fileNames.forEach(log::info);
    }

    @Then("verify file is empty or not")
    public void verifyEmpty() {
        log.info("verifyEmpty() method called");
        this.files = this.files.stream().filter(this::isFileNotEmpty).collect(Collectors.toList());
    }

    @Then("get the file information")
    public void getFileInformation() {
        log.info("getFileInformation() method called");
        this.files.forEach(this::getFileInformation);
    }

    private boolean isFileNotEmpty(Path path) {
        String fileName = path.getFileName().toString();
        if (path.toFile().length() == 0) {
            log.info(fileName + " is empty");
            return false;
        } else {
            log.info(fileName + " is not empty");
            return true;
        }
    }

    private void getFileInformation(Path path) {
        String fileName = path.getFileName().toString();
        log.info("retrieving information for file: {}", fileName);
        if (fileName.endsWith(".txt")) {
            getTextFileInfo(path);
        } else if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            getExcelFileInfo(path);
        } else if (fileName.endsWith(".csv")) {
            getCsvFileInfo(path);
        }
    }

    private void getCsvFileInfo(Path path) {
        try {
            CSVReader reader = new CSVReader(new FileReader(path.toAbsolutePath().toString()));
            String[] headers = reader.readNext();
            log.info("header names: {}", Arrays.toString(headers));
            long count = Files.lines(path).count();
            log.info("total lines available: {}", count);
        } catch (IOException | CsvValidationException e) {
            log.error("ERROR: ", e);
        }
    }

    private void getExcelFileInfo(Path path) {
        try (Workbook workbook = WorkbookFactory.create(Files.newInputStream(path))) {
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, String> columns = getColumnWithIndex(sheet);
            log.info("total columns available: {}", columns.size());
            log.info(String.format("%-10s%-40s", "index", "column name"));
            log.info(String.format("%-10s%-40s", "-----", "---------------------"));
            columns.forEach((k, v) -> log.info(String.format("%-10d%-40s", k, v)));
        } catch (IOException e) {
            log.error("ERROR: ", e);
        }
    }

    private Map<Integer, String> getColumnWithIndex(Sheet sheet) {
        Map<Integer, String> columns = new TreeMap<>();
        Row row = sheet.getRow(0);
        int firstCellIndex = row.getFirstCellNum();
        int lastCellIndex = row.getLastCellNum();
        for (int i = firstCellIndex; i < lastCellIndex; i++) {
            Cell cell = row.getCell(i);
            columns.put(cell.getColumnIndex(), cell.getStringCellValue());
        }
        return columns;
    }

    private void getTextFileInfo(Path path) {
        File file = path.toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String firstLine = reader.readLine();
            String[] header = firstLine.split(",");
            log.info("header names: {}", Arrays.toString(header));
            long count = Files.lines(path).count();
            log.info("total lines available: {}", count);
        } catch (IOException e) {
            log.error("ERROR: ", e);
        }
    }
}
