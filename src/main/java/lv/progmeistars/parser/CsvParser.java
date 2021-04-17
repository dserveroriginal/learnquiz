package lv.progmeistars.parser;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<CommonTypeData> parseFile(File file) {
        try {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            List<String[]> lines = readAll(fileReader);

            var list = new ArrayList<CommonTypeData>();
            for (String[] line : lines) {
                CommonTypeData data = map(line);
                list.add(data);
            }

            return list;
        } catch (IOException e) {
            throw new RuntimeException("Could not read or parse file", e);
        }
    }

    private List<String[]> readAll(Reader reader) throws IOException {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    private CommonTypeData map(String[] line) {
        String firstVariable = line[0];
        String secondVariable = line[1];
        String thirdVariable = line[2];

        var to = new CommonTypeData();

        to.setFirstVariable(firstVariable);
        to.setSecondVariable(secondVariable);
        to.setThirdVariable(thirdVariable);

        return to;
    }

}
