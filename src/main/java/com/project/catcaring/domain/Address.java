package com.project.catcaring.domain;

import com.project.catcaring.domain.User.Location;
import lombok.Builder;

@Builder
public class Address {

  private final Long id;
  private final Long postId;
  private final Location location;
  private final String locationDetail;
  private final Authority authorityCode;
}
