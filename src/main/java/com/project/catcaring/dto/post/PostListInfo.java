package com.project.catcaring.dto.post;

import java.time.LocalDateTime;
import lombok.Getter;
import org.apache.commons.text.StringEscapeUtils;

@Getter
public class PostListInfo {
    private Long id;
    private Long userId;
    private String title;
    private LocalDateTime createdAt;

    public String getTitle(String title) {
        System.out.println(StringEscapeUtils.escapeHtml4(title));
        return StringEscapeUtils.escapeHtml4(title);
    }
}
