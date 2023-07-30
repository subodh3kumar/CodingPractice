package workshop.csv;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import workshop.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvWriter {

    private static final Logger log = LoggerFactory.getLogger(CsvWriter.class);

    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();

        final String sql = "SELECT * FROM EMP";
        StringBuilder dataStringBuilder = new StringBuilder();

        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet columnResultSet = databaseMetaData.getColumns(null, databaseMetaData.getUserName(), "EMP", null);

            List<String> columns = new ArrayList<>();
            StringBuilder columnStringBuilder = new StringBuilder();

            while (columnResultSet.next()) {
                String columnName = columnResultSet.getString("COLUMN_NAME");
                String columnType = columnResultSet.getString("TYPE_NAME");
                String dataType = columnResultSet.getString("DATA_TYPE");
                log.info("column name: {}, column type: {}. data type: {}", columnType, columnType, dataType);
                columns.add(columnName + "|" + columnType);
                columnStringBuilder.append(columnName);
                columnStringBuilder.append(",");

            }
            String rowHeader = columnStringBuilder.substring(0, columnStringBuilder.length() - 1);
            dataStringBuilder.append(rowHeader);
            dataStringBuilder.append(System.lineSeparator());
            columns.forEach(log::info);

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
                        int precision = resultSetMetaData.getPrecision(2);
                        int scale = resultSetMetaData.getScale(2);
                        columnType = "DOUBLE";
                        if (scale == 0) {
                            columnType = "INTEGER";
                        }
                        log.info("column precision: {}", precision);
                        log.info("column scale: {}", scale);
                    }

                    String value = switch (columnType) {
                        case "INTEGER" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getInt(columnName)), "");
                        case "DOUBLE" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getDouble(columnName)), "");
                        case "VARCHAR2" -> StringUtils.defaultIfBlank(resultSet.getString(columnName), "");
                        case "DATE" -> StringUtils.defaultIfBlank(String.valueOf(resultSet.getDate(columnName)), "");
                        default -> "";
                    };

                    rowStringBuilder.append(value);
                    rowStringBuilder.append(",");
                }
                String row = rowStringBuilder.substring(0, rowStringBuilder.length() - 1);
                dataStringBuilder.append(row);
                dataStringBuilder.append(System.lineSeparator());
            }
            log.info(dataStringBuilder.toString());

        } catch (SQLException e) {
            log.error("ERROR:", e);
        }


    }
}
