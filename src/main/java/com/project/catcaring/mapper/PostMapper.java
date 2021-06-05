package com.project.catcaring.mapper;

import com.project.catcaring.domain.Address;
import com.project.catcaring.domain.Post;
import com.project.catcaring.domain.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
  void insertPost(Post newPost);
  Long findLastPostByUserId(Long userId);
  void insertLocation(Address postLocation);
  void insertTag(Tag postTag);
}
