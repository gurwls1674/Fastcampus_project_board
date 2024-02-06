package com.fastcampus.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleUpdateDto
        (
            String content,
            String title,
            String hashtag
          ) {
    public static ArticleUpdateDto of(
                                      String content,
                                      String title,
                                      String hashtag)
    {
        return new ArticleUpdateDto( content,title,hashtag);
    }

}
