package at.fhj.ima.project.gymieneutron.security

import at.fhj.ima.project.gymieneutron.entity.User
import at.fhj.ima.project.gymieneutron.entity.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class MyUserPrincipal(val user: User) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = HashSet<GrantedAuthority>()
        if (user.role == UserRole.ROLE_ADMIN) {
            authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))
        }
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        return authorities
    }

    override fun isEnabled(): Boolean {
        return true;
    }

    override fun getUsername(): String? {
        return user.username;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun getPassword(): String? {
        return user.password;
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

}
