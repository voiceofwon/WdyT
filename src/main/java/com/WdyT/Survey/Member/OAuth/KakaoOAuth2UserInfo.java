package com.WdyT.Survey.Member.OAuth;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo{
    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getNickname() {
        return null;
    }

    @Override
    public String getImageUrl() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
