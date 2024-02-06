package com.fastcampus.board.dto;

import java.time.LocalDateTime;

public record ArticleCommentDto
        ( LocalDateTime createdAt,
            String createBy,
            String content,
          LocalDateTime modifiedAt,
          String modifiedBy
          ) {
    public static ArticleCommentDto of(LocalDateTime createdAt,
                                       String createBy,
                                       String content,
                                       LocalDateTime modifiedAt,
                                       String modifiedBy
                                 )
    {
        return new ArticleCommentDto(createdAt,createBy,content,modifiedAt,modifiedBy);
    }

}
