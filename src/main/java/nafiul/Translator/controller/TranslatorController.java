package nafiul.Translator.controller;

import nafiul.Translator.dto.TranslatorDto;
import nafiul.Translator.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {

    @Autowired
    private TranslatorService translatorService;

    @PostMapping("/getTranslator")
    public ResponseEntity<?> getTranslator(@RequestBody TranslatorDto translatorDto) {
        return translatorService.getTranslator(translatorDto);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testApi() {
        return new ResponseEntity<>("Application is deployed", HttpStatus.OK);
    }

    @PostMapping("/addTestData/{text}")
    public ResponseEntity<?> addTestData(@PathVariable String text) {
        return new ResponseEntity<>(translatorService.addTestData(text), HttpStatus.OK);
    }

    @PostMapping("/addName/{name}")
    public ResponseEntity<?> addNameData(@PathVariable String name) {
        return new ResponseEntity<>(translatorService.addNameData(name), HttpStatus.OK);
    }

    @GetMapping("/checkTestData/{id}")
    public String checkTestData(@PathVariable Long id) {
        return translatorService.checkTestData(id);
    }

    @GetMapping("/checkNameData/{id}")
    public String checkNameData(@PathVariable Long id) {
        return translatorService.checkNameData(id);
    }
}
