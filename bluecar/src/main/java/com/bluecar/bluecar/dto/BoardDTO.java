package com.bluecar.bluecar.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class BoardDTO{

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedTime;
}