package com.project.catcaring.domain;

import com.project.catcaring.dto.user.request.UserChangeRequest;
import com.project.catcaring.dto.user.request.UserInfoRequest;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 회원 (entity)
 */
@Getter
@Builder
@RequiredArgsConstructor
@Entity(name = "User")
public class User {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private final String username;

    private final String password;

    private final String email;

    private final String fullName;

    private final Location location;

    private final MemberShip memberShipStatus;

    private final String accessToken;

    private final String userIntro;

    private final Status userStatus;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    /**
     * 회원 생성
     *
     * @param userInfoRequest
     * @return
     */
    public static User generate(UserInfoRequest userInfoRequest) {

        return User.builder().username(userInfoRequest.getUsername())
            .password(PASSWORD_ENCODER.encode(userInfoRequest.getPassword()))
            .fullName(userInfoRequest.getFullName())
            .email(userInfoRequest.getEmail())
            .location(userInfoRequest.getLocation())
            .memberShipStatus(MemberShip.DEFAULT_MEMBER)
            .userStatus(Status.MEMBER)
            .build();
    }

    /**
     * 회원 정보 수정
     *
     * @param userChangeRequest
     * @param userId
     * @return
     */
    public static User modify(UserChangeRequest userChangeRequest, Long userId) {

        return User.builder()
            .id(userId)
            .password(PASSWORD_ENCODER.encode(userChangeRequest.getPassword()))
            .fullName(userChangeRequest.getFullName())
            .location(userChangeRequest.getLocation()).build();
    }

    /**
     * 회원 등급 (Enum)
     */
    public enum MemberShip {

        ADMIN,
        LEADER_MEM,
        BOARD_MEM,
        ACTIVE_MEM,
        SOCIETY_MEM,
        DEFAULT_MEMBER,
        ALL,
        DELETED
    }

    /**
     * 회원 상태 (Enum)
     */
    public enum Status {

        MEMBER, ADMIN, DELETED
    }

    /**
     * 자치구 (Enum)
     */
    public enum Location {

        DOBONG, DONGDAEMUN, DONGJAK,
        EUNPYEONG,
        GANGBUK, GANGDONG, GANGNAM, GANGSEO, GEUMCHEON, GURO, GWANAK, GWANGJIN,
        JONGNO, JUNG, JUNGNANG,
        MAPO,
        NOWON,
        SEOCHO, SEODAEMUN, SEONGBUK, SEONGDONG, SONGPA,
        YANGCHEON, YEONGDEUNGPO, YONGSAN
    }
}
