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

    public List<WordTranslationTypeData> parseWordFile(File file) {
        try {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            List<String[]> lines = readAll(fileReader);

            var list = new ArrayList<WordTranslationTypeData>();
            for (String[] line : lines) {
                WordTranslationTypeData data = wordMap(line);
                list.add(data);
            }

            return list;
        } catch (IOException e) {
            throw new RuntimeException("Could not read or parse file", e);
        }
    }
    public List<ScoreTypeData> parseScoreFile(File file) {
        try {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            List<String[]> lines = readAll(fileReader);

            var list = new ArrayList<ScoreTypeData>();
            for (String[] line : lines) {
                ScoreTypeData data = scoreMap(line);
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

    private WordTranslationTypeData wordMap(String[] line) {
        String source = line[0];
        String translated = line[1];
        String type = line[2];

        var to = new WordTranslationTypeData();

        to.setSourceLanguage(source);
        to.setTranslationLanguage(translated);
        to.setWordType(type);

        return to;
    }
    private ScoreTypeData scoreMap(String[] line) {
        String name = line[0];
        String score = line[1];
        String tryCount = line[2];

        var to = new ScoreTypeData();

        to.setName(name);
        to.setScore(score);
        to.setTryCount(tryCount);

        return to;
    }
}
