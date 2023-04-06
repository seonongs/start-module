package seon.startmodule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDTO {

    public Long seq;
    public String type;
    public String title;
    public String content;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;

}
