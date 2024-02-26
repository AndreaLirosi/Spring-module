package com.example.UploadEDownload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload") //questo genera il file che verrà salvato tramite il metodo storeFile dando la risposta ok e il nome del file
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file);
        return ResponseEntity.ok().body("File caricato correttamente: " + fileName);
    }

    @GetMapping("/download/{fileName}") // ricordarsi di scambiare i caratteri speciali con il %
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Resource file = fileService.loadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
