package nafiul.Translator.controller;

import nafiul.Translator.dto.TranslatorDto;
import nafiul.Translator.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {

    @Autowired
    private TranslatorService translatorService;

    @PostMapping("/getTranslator")
    public ResponseEntity<?> getTranslator(@RequestBody TranslatorDto translatorDto) {
        return translatorService.getTranslator(translatorDto);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testApi(){
        return new ResponseEntity<>("Application is deployed", HttpStatus.OK);
    }
}
