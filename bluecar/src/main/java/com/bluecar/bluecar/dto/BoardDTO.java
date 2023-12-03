package com.bluecar.bluecar.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class BoardDTO extends UploadFile{

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private String boardCreatedTime;
    private String date;
    private String category;
    private String state;
}
