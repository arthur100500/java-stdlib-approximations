package generated.org.springframework.security;

import generated.org.springframework.boot.SpringApplicationImpl;
import generated.org.springframework.boot.pinnedValues.PinnedValueSource;
import generated.org.springframework.boot.pinnedValues.PinnedValueStorage;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Approximate(SecurityExpressionRoot.class)
public class SecurityExpressionRootImpl {

    private Collection<? extends GrantedAuthority> getAuthoritySet() {
        return SecurityContextImplImpl.createSymbolicAuthorities();
    }

    private boolean hasAnyAuthorityName(String prefix, String... roles) {
        SpringApplicationImpl._println("Attempting to check authorities:");
        for (String neededRole : roles) {
            SpringApplicationImpl._println(neededRole);
        }

        Collection<? extends GrantedAuthority> roleSet = getAuthoritySet();
        for (String neededRole : roles) {
            if (roleSet.contains(new SimpleGrantedAuthority(neededRole))) {
                return true;
            }
        }

        return false;
    }
}
