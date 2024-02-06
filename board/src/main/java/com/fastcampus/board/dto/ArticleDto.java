package com.fastcampus.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto
        ( LocalDateTime createdAt,
            String createBy,
            String content,
            String title,
            String hashtag
          ) {
    public static ArticleDto of(LocalDateTime createdAt,
                                String createBy,
                                String content,
                                String title,
                                String hashtag
                                 )
    {
        return new ArticleDto(createdAt,createBy,content,title,hashtag);
    }

}
