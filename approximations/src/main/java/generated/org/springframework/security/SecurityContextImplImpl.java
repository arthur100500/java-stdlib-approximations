package generated.org.springframework.security;

import generated.org.springframework.boot.SpringApplicationImpl;
import generated.org.springframework.boot.SymbolicValueFactory;
import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.usvm.api.Engine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.getPinnedValue;
import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.writePinnedValue;

@Approximate(SecurityContextImpl.class)
public class SecurityContextImplImpl {

    private static Authentication cachedAuthentication;
    private static Collection<GrantedAuthority> cachedAuthorities;

    public static Collection<GrantedAuthority> createSymbolicAuthorities() {
        if (cachedAuthorities != null)
            return cachedAuthorities;

        Collection<GrantedAuthority> authorities = getPinnedValue(PinnedValueSource.REQUEST_USER_AUTHORITIES, ArrayList.class);
        Engine.assume(authorities != null);
        Engine.assume(authorities.size() < 5);
        cachedAuthorities = authorities;
        return authorities;
    }

    private Authentication createSymbolicAuthentication() {
        String username = SymbolicValueFactory.createNonEmptySymbolicString(PinnedValueSource.REQUEST_USER_NAME, null);
        String password = SymbolicValueFactory.createNonEmptySymbolicString(PinnedValueSource.REQUEST_USER_PASSWORD, null);
        Collection<GrantedAuthority> authorities = createSymbolicAuthorities();
        UserDetails user = new User(username, password, Collections.emptyList());
        try {
            Field authoritiesField = User.class.getDeclaredField("authorities");
            authoritiesField.setAccessible(true);
            authoritiesField.set(user, authorities);
        } catch (Exception e) {
            SpringApplicationImpl._println("Warning! Error setting authorities!");
        }

        return new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities()
        );
    }

    public Authentication getAuthentication() {
        if (cachedAuthentication != null)
            return cachedAuthentication;

        Authentication result = createSymbolicAuthentication();
        cachedAuthentication = result;
        return result;
    }
}
