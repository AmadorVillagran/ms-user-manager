package com.amaris.usermanager.infrastructure.configuration;

import java.util.HashMap;
import java.util.Map;

import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
    @Autowired private UserRepository repository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity usEntity = repository.findByName(userDetails.getUsername());
        Map<String, Object> info = new HashMap<>();
        info.put("profile", usEntity.getProfile().getName());
        info.put("lastLogin", usEntity.getLastLogin());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
