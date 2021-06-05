package com.project.catcaring.dto.post;

import com.project.catcaring.domain.Address;
import com.project.catcaring.domain.Authority;
import com.project.catcaring.domain.Address;
import com.project.catcaring.domain.User.Location;
import java.util.List;
import lombok.Getter;
import reactor.util.annotation.Nullable;

@Getter
public class PostInfoRequest {
  private String title;
  private String content;
  @Nullable
  private Authority postAuthorityCode;
  @Nullable
  private List<String> tagNames;
  private Location location;
  @Nullable
  private String locationDetail;
  @Nullable
  private Authority locationAuthorityCode;
}
