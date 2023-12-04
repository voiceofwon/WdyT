package com.WdyT.Survey.Member.OAuth;


import com.WdyT.Survey.Member.Member;
import com.WdyT.Survey.Member.Role;
import com.WdyT.Survey.Member.SocialType;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class OAuthAttributes {

    private String nameAttributeKey;
    private OAuth2UserInfo oAuth2UserInfo;

    @Builder
    public OAuthAttributes(String nameAttributeKey, OAuth2UserInfo oAuth2UserInfo){
        this.nameAttributeKey = nameAttributeKey;
        this.oAuth2UserInfo = oAuth2UserInfo;
    }

    public static OAuthAttributes of(SocialType socialType,
                                     String userNameAttributeName, Map<String, Object> attributes){

        /*if(socialType == SocialType.NAVER){
            return ofNaver(userNameAttributeName, attributes);
        }
        if(socialType == SocialType.KAKAO){
            return ofKakao(userNameAttributeName, attributes);

        }

        return ofGoogle(userNameAttributeName, attributes);*/

        if(socialType == SocialType.NAVER){
            return ofNaver(userNameAttributeName, attributes);
        }

        return ofKakao(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofKakao(String userNameAttributeName,Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .oAuth2UserInfo(new KakaoOAuth2UserInfo(attributes))
                .build();
    }

    /*public static OAuthAttributes ofGoogle(String userNameAttributeName,Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .build()
    }*/

    public static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .oAuth2UserInfo(new NaverOAuth2UserInfo(attributes))
                .build();
    }

    public Member toEntity(SocialType socialType, OAuth2UserInfo oAuth2UserInfo){
        return Member.builder()
                .socialId(oAuth2UserInfo.getId())
                .socialType(socialType)
                .email(UUID.randomUUID() + "@socialUser.com")
                .nickname(oAuth2UserInfo.getNickname())
                .role(Role.GUEST)
                .imageUrl(oAuth2UserInfo.getImageUrl())
                .build();
    }


}
