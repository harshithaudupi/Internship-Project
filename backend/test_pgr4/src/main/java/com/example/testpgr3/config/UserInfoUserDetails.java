package com.example.testpgr3.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.testpgr3.entity.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User user) {
        name=user.getUserName();
        password=user.getPassword();
        authorities= Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserInfoUserDetails [name=" + name + ", password=" + password + ", authorities=" + authorities
				+ ", getAuthorities()=" + getAuthorities() + ", getPassword()=" + getPassword() + ", getUsername()="
				+ getUsername() + ", isAccountNonExpired()=" + isAccountNonExpired() + ", isAccountNonLocked()="
				+ isAccountNonLocked() + ", isCredentialsNonExpired()=" + isCredentialsNonExpired() + ", isEnabled()="
				+ isEnabled() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorities, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoUserDetails other = (UserInfoUserDetails) obj;
		return Objects.equals(authorities, other.authorities) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
}
