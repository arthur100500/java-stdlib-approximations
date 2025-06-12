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

    private static Authentication cachedAuthentication = null;
    private static ArrayList<GrantedAuthority> cachedAuthorities = null;

//    public static Collection<GrantedAuthority> getSymbolicAuthorities() {
//        // Create symbolic user is a must
//        if (cachedAuthentication == null || cachedAuthorities == null)
//            getSymbolicAuthentication();
//
//        return cachedAuthorities;
//    }

    private static Collection<GrantedAuthority> createSymbolicAuthorities() {
        if (cachedAuthorities != null)
            return cachedAuthorities;

        SpringApplicationImpl._println("Creating symbolic authorities");
        ArrayList<GrantedAuthority> authorities = getPinnedValue(PinnedValueSource.REQUEST_USER_AUTHORITIES, ArrayList.class);
        Engine.assume(authorities != null);
        Engine.assume(authorities.size() < 3);
        cachedAuthorities = authorities;
        return authorities;
    }

    private static Class<? extends UserDetails> _getUserClass() {
        throw new IllegalStateException("This method must be approximated!");
    }

    private static void assumeUserInvariants(UserDetails user, Class<?> userClass) {
        Engine.assume(user != null);

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (Collection.class == field.getType()) {
                    SpringApplicationImpl._println(String.format(
                            "user.%s is rewritten to new ArrayList",
                            field.getName()
                    ));
                    Object arrayList = SymbolicValueFactory.createSymbolic(ArrayList.class, false);
                    Engine.assume(((ArrayList)arrayList).size() < 4);
                    field.set(user, arrayList);
                }
            } catch (IllegalAccessException e) {
                SpringApplicationImpl._println("Warning! Error assuming field data: " + e.getMessage());
            }
        }

        Engine.assumeSoft(Engine.forceStringEquals(user.getUsername(), "Test user"));
        Engine.assumeSoft(Engine.forceStringEquals(user.getPassword(), "Test password"));
        // Collection<GrantedAuthority> symbolicAuthorities = createSymbolicAuthorities();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Engine.assume(authorities.size() < 5);
    }

    private static Authentication getSymbolicAuthentication() {
        Class<? extends UserDetails> userClass = _getUserClass();
        UserDetails user = Engine.makeNullableSymbolicSubtype(userClass);
        assumeUserInvariants(user, userClass);
        writePinnedValue(PinnedValueSource.REQUEST_USER, user);
        Authentication result = new UsernamePasswordAuthenticationToken(
                user,
                null,
                Collections.emptyList()
        );
        try {
            Field authoritiesField = AbstractAuthenticationToken.class.getDeclaredField("authorities");
            authoritiesField.setAccessible(true);
            authoritiesField.set(result, user.getAuthorities());
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
