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

    @SuppressWarnings("unchecked")
    private Collection<GrantedAuthority> getAuthoritySet() {
        return (Collection<GrantedAuthority>) new SecurityContextImplImpl().getAuthentication().getAuthorities();
    }

    private boolean hasAnyAuthorityName(String prefix, String... roles) {
        SpringApplicationImpl._println("Attempting to check authorities:");
        for (String neededRole : roles) {
            SpringApplicationImpl._println(neededRole);
        }

        Collection<GrantedAuthority> roleSet = getAuthoritySet();
        for (String neededRole : roles) {
            for (GrantedAuthority authority : roleSet) {
                Engine.assume(authority != null);
                Engine.assume(authority.getAuthority() != null);
                if (Engine.forceStringEquals(authority.getAuthority(), roleWithPrefix(prefix, neededRole))) {
                    return true;
                }
            }
        }
        Engine.assume(false);
        return false;
    }

    private String roleWithPrefix(String prefix, String role) {
        if (prefix == null) return role;
        return prefix + role;
    }
}
