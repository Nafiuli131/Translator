package nafiul.Translator.dto;

public class TranslatorDto {

    private String givenText;
    private String sourceLanguage;
    private String targetLanguage;
    private String format = "text";

    public String getGivenText() {
        return givenText;
    }

    public void setGivenText(String givenText) {
        this.givenText = givenText;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
