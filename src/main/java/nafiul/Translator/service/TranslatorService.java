package nafiul.Translator.service;

import nafiul.Translator.dto.ExceptionDto;
import nafiul.Translator.dto.TranslatorDto;
import nafiul.Translator.entity.TestTable;
import nafiul.Translator.repository.TestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslatorService {

    @Autowired
    private TestTableRepository testTableRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "https://libretranslate.com/translate";

    public ResponseEntity<?> getTranslator(TranslatorDto translatorDto) {
        try {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("q", translatorDto.getGivenText());
            requestBody.put("source", translatorDto.getSourceLanguage());
            requestBody.put("target", translatorDto.getTargetLanguage());
            requestBody.put("format", "text");
            requestBody.put("alternatives", 3);
//            requestBody.put("api_key", "");

            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Build the request
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

            // Send the POST request
            ResponseEntity<String> response = restTemplate.postForEntity(URL, requestEntity, String.class);
            return response;
        } catch (Exception ex) {
            String message = ex.getMessage();
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setText(message);
            return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> addTestData(String text) {
        try {
            TestTable testTable = new TestTable();
            testTable.setText(text);
            testTableRepository.save(testTable);
            return new ResponseEntity<>(testTable, HttpStatus.OK);
        }catch (Exception ex){
            String message = ex.getMessage();
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setText(message);
            return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        }
    }
}
