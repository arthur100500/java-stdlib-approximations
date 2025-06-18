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
import org.springframework.security.core.userdetails.UserDetails;
import org.usvm.api.Engine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static generated.org.springframework.boot.pinnedValues.PinnedValueStorage.writePinnedValue;

@Approximate(SecurityContextImpl.class)
public class SecurityContextImplImpl {

    private static Authentication cachedAuthentication = null;

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

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Engine.assume(authorities.size() < 5);
    }

    private static Authentication createAuthenticationToken(UserDetails user) {
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
            SpringApplicationImpl._println("Warning! Error setting authorities! " + e.getMessage());
        }
        return result;
    }

    private static Authentication getSymbolicAuthentication() {
        Class<? extends UserDetails> userClass = _getUserClass();
        UserDetails user = Engine.makeNullableSymbolicSubtype(userClass);
        assumeUserInvariants(user, userClass);
        writePinnedValue(PinnedValueSource.REQUEST_USER, user);

        return createAuthenticationToken(user);
    }

    public Authentication getAuthentication() {
        if (cachedAuthentication != null)
            return cachedAuthentication;

        Authentication result = getSymbolicAuthentication();
        cachedAuthentication = result;
        return result;
    }
}
