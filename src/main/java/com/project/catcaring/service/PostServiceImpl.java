package com.project.catcaring.service;

import com.project.catcaring.domain.Location;
import com.project.catcaring.domain.Post;
import com.project.catcaring.domain.Post.PostStatus;
import com.project.catcaring.domain.Tag;
import com.project.catcaring.domain.user.Authority;
import com.project.catcaring.dto.post.PostInfoRequest;
import com.project.catcaring.mapper.PostMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

  private final PostMapper postMapper;

  @Override
  public void uploadPost(PostInfoRequest postInfoRequest, Long userId) {
    postMapper.insertPost(Post.generate(postInfoRequest, userId));
    Long postId = postMapper.findLastPostByUserId(userId);

    Location postLocation = buildLocationInfo(postInfoRequest, postId);
    postMapper.insertLocation(postLocation);

    if(postInfoRequest.getTagNames() != null) {
      for(String tagName : postInfoRequest.getTagNames()) {
        Tag postTag = Tag.builder().postId(postId).tagName(tagName).build();
        postMapper.insertTag(postTag);
      }
    }

  }

  private Location buildLocationInfo(PostInfoRequest postInfoRequest, Long postId) {
    Authority authority = postInfoRequest.getLocationAuthorityCode();

    if(authority == null) {
      authority = Authority.ACTIVE_MEM;
    }

    return Location.builder().postId(postId).location(postInfoRequest.getLocation())
            .locationDetail(postInfoRequest.getLocationDetail())
            .authorityCode(authority).build();
  }
}
