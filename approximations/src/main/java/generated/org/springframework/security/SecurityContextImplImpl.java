package generated.org.springframework.security;

import generated.org.springframework.boot.SpringApplicationImpl;
import generated.org.springframework.boot.SymbolicValueFactory;
import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.authentication.AbstractAuthenticationToken;
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
    private static ArrayList<GrantedAuthority> cachedAuthorities;

    public static Collection<GrantedAuthority> getSymbolicAuthorities() {
        // Create symbolic user is a must
        if (cachedAuthentication == null || cachedAuthorities == null)
            getSymbolicAuthentication();

        return cachedAuthorities;
    }

    private static Collection<GrantedAuthority> createSymbolicAuthorities() {
        if (cachedAuthorities != null)
            return cachedAuthorities;

        ArrayList<GrantedAuthority> authorities = getPinnedValue(PinnedValueSource.REQUEST_USER_AUTHORITIES, ArrayList.class);
        Engine.assume(authorities != null);
        Engine.assume(authorities.size() < 3);
        cachedAuthorities = authorities;
        return authorities;
    }

    private static Authentication getSymbolicAuthentication() {
        UserDetails user = Engine.makeNullableSymbolicSubtype(UserDetails.class);
        Engine.assume(user != null);
        Engine.assumeSoft(Engine.forceStringEquals(user.getUsername(), "Test user"));
        Engine.assumeSoft(Engine.forceStringEquals(user.getPassword(), "Test password"));
        Collection<GrantedAuthority> symbolicAuthorities = createSymbolicAuthorities();
        Engine.assume(user.getAuthorities() == symbolicAuthorities);
        writePinnedValue(PinnedValueSource.REQUEST_USER, user);
        Authentication result = new UsernamePasswordAuthenticationToken(
                user,
                null,
                Collections.emptyList()
        );
        try {
            Field authoritiesField = AbstractAuthenticationToken.class.getDeclaredField("authorities");
            authoritiesField.setAccessible(true);
            authoritiesField.set(result, symbolicAuthorities);
        } catch (Exception e) {
            SpringApplicationImpl._println("Warning! Error setting field authorities! " + e.getMessage());
        }
        return result;
    }

    public Authentication getAuthentication() {
        if (cachedAuthentication != null)
            return cachedAuthentication;

        Authentication result = getSymbolicAuthentication();
        cachedAuthentication = result;
        return result;
    }
}
