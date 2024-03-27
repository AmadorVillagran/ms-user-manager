package com.amaris.usermanager.infrastructure.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

 public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        // Obtén los detalles del usuario autenticado, si es necesario
         UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        String acc = ((DefaultOAuth2AccessToken) accessToken).getValue();
        // Agrega información adicional al token de acceso
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("custom_info", "additional_info_value");

        // Agrega la información adicional al token de acceso
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        // Devuelve el token de acceso modificado
        return accessToken;
    }
}

