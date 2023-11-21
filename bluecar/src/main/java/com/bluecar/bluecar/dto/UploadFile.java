package com.bluecar.bluecar.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
    public class UploadFile {

        private Long id;

        private String fileName;                //예류.jpg

        private String saveFileName;            //uuid예류.jpg

        private String filePath;                // D:/image/uuid예류.jpg

        private String contentType;             // image/jpeg

        private long size;                      // 4476873 (byte)

        private LocalDateTime registerDate;     // 2020-02-07 12:27:37.857
    }



