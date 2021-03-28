package lv.progmeistars.parser;

import lombok.Data;

@Data
public class WordTranslationTypeData {

    private String sourceLanguage;
    private String translationLanguage;
    private String wordType;
}
