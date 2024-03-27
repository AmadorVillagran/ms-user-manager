package com.amaris.usermanager.infrastructure.configuration;

import com.amaris.usermanager.infrastructure.repository.jpa.UserRepository;
import com.amaris.usermanager.infrastructure.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired private UserRepository repository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity usEntity = repository.findByEmail(username);
        usEntity.setLastLogin(new Date());
        repository.save(usEntity);

        if(usEntity == null){
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+usEntity.getProfile().getName());
        authorities.add(authority);

        return new User(usEntity.getName(),
                usEntity.getPassword(),
                usEntity.getStatus().contains("ACTIVE"),
                true,
                true,
                true,
                authorities);
    }
}
