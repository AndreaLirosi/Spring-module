package com.example.UploadEDownload;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path root = Paths.get("C:\\Users\\liros\\OneDrive\\Desktop\\SoundBar");// questo indicizza il file nella directory in cui verrà salvato

    public String storeFile(MultipartFile file) {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
            return file.getOriginalFilename(); //mi torna il nome del file
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il caricamento del file: " + e.getMessage());
        }
    }

    public Resource loadFile(String fileName) {
        try {
            Path file = root.resolve(fileName);
            return new FileSystemResource(file);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante il caricamento del file: " + e.getMessage());
        }
    }
}
