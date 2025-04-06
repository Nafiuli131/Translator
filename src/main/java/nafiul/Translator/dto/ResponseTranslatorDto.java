package nafiul.Translator.dto;

import lombok.*;

public class ResponseTranslatorDto {
    private String translatorText;

    public String getTranslatorText() {
        return translatorText;
    }

    public void setTranslatorText(String translatorText) {
        this.translatorText = translatorText;
    }
}
