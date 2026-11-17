package com.rahul.adapirahul.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageStorageService {

    private static final String UPLOAD_DIR = "uploads";
    private static final String BASE_URL = "https://adapirahul.onrender.com";

    public String saveBase64Image(Long userId, String base64Input) throws IOException {
        String extension = "jpg";
        String pureBase64 = base64Input.trim();

        // Strip "data:image/...;base64," header if sent by client
        if (pureBase64.startsWith("data:")) {
            int commaIndex = pureBase64.indexOf(",");
            if (commaIndex != -1) {
                String header = pureBase64.substring(5, commaIndex);
                if (header.contains("image/png")) {
                    extension = "png";
                } else if (header.contains("image/webp")) {
                    extension = "webp";
                }
                pureBase64 = pureBase64.substring(commaIndex + 1);
            }
        }

        // Decode Base64 to image bytes
        byte[] imageBytes = Base64.getDecoder().decode(pureBase64);

        // Create uploads directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save file with unique name
        String fileName = "user_" + userId + "_" + UUID.randomUUID().toString().substring(0, 8) + "." + extension;
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, imageBytes);

        // Return full URL using your Render base URL
        return BASE_URL + "/uploads/" + fileName;
    }
}