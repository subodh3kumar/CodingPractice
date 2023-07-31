package workshop.csv;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import workshop.util.JdbcUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSourceCsvWriter {

    private static final Logger log = LoggerFactory.getLogger(DataSourceCsvWriter.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Connection connection = JdbcUtil.getConnection();

        final String sql = "SELECT * FROM CUSTOMERS";
        List<String> dataList = new ArrayList<>();

        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet columnResultSet = databaseMetaData.getColumns(null, databaseMetaData.getUserName(), "CUSTOMERS", null);

            List<String> columns = new ArrayList<>();
            StringBuilder columnStringBuilder = new StringBuilder();

            while (columnResultSet.next()) {
                String columnName = columnResultSet.getString("COLUMN_NAME");
                String columnType = columnResultSet.getString("TYPE_NAME");
                columns.add(columnName + "|" + columnType);
                columnStringBuilder.append("\"").append(columnName).append("\"");
                columnStringBuilder.append(",");

            }
            String rowHeader = columnStringBuilder.substring(0, columnStringBuilder.length() - 1);
            log.info("Header: {}", rowHeader);
            dataList.add(rowHeader);

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StringBuilder rowStringBuilder = new StringBuilder();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                for (String column : columns) {

                    String[] columnNameType = column.split("\\|");
                    String columnName = columnNameType[0];
                    String columnType = columnNameType[1];

                    if (Objects.equals(columnType, "NUMBER")) {
                        int scale = resultSetMetaData.getScale(2);
                        columnType = "DOUBLE";
                        if (scale == 0) {
                            columnType = "INTEGER";
                        }
                    }

                    String value = switch (columnType) {
                        case "INTEGER" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getInt(columnName)), "");
                        case "DOUBLE" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getDouble(columnName)), "");
                        case "VARCHAR2" -> StringUtils.defaultIfBlank(resultSet.getString(columnName), "");
                        case "DATE" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getDate(columnName)), "");
                        default -> "";
                    };

                    rowStringBuilder.append("\"").append(value).append("\"");
                    rowStringBuilder.append(",");
                }
                String row = rowStringBuilder.substring(0, rowStringBuilder.length() - 1);
                dataList.add(row);
            }
            log.info("total lines: {}", dataList.size());

            Path path = Path.of("src/main/resources/output/data.csv");

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (String row : dataList) {
                    writer.write(row);
                    writer.write(System.lineSeparator());
                }
                writer.flush();
            }
        } catch (SQLException | IOException e) {
            log.error("ERROR:", e);
        }
        long endTime = System.currentTimeMillis();
        log.info("total time for execution: {}", (endTime - startTime) + " ms");
    }
}
