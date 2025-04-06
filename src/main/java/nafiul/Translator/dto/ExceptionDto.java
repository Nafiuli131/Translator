package nafiul.Translator.dto;

import lombok.*;

public class ExceptionDto {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
