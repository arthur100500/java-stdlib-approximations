package generated.java.lang;

import java.io.FileDescriptor;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SecurityException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.net.InetAddress;
import java.security.Permission;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@SuppressWarnings({"removal", "unused"})
@Approximate(java.lang.SecurityManager.class)
public class SecurityManagerImpl {

    static {
        Engine.assume(true);
    }

    public SecurityManagerImpl() {
        _do_checkPermission(new RuntimePermission("createSecurityManager"));
    }

    private void _do_checkPermission(Permission perm) {
        if (Engine.makeSymbolicBoolean())
            throw new java.security.AccessControlException("access denied ", perm);
    }

    private void _do_checkPermission() {
        _do_checkPermission(null);
    }

    public void checkAccept(String host, int port) {
        if (host == null)
            throw new NullPointerException();
        if (Engine.makeSymbolicBoolean())
            throw new IllegalArgumentException();
        _do_checkPermission();
    }

    public void checkAccess(Thread t) {
        if (t == null)
            throw new NullPointerException("thread can't be null");
        _do_checkPermission();
    }

    public void checkAccess(ThreadGroup g) {
        if (g == null)
            throw new NullPointerException("thread group can't be null");
        _do_checkPermission();
    }

    public void checkConnect(String host, int port) {
        if (host == null)
            throw new NullPointerException("host can't be null");
        if (Engine.makeSymbolicBoolean())
            throw new IllegalArgumentException();
        _do_checkPermission();
    }

    public void checkConnect(String host, int port, Object context) {
        if (host == null)
            throw new NullPointerException("host can't be null");
        if (Engine.makeSymbolicBoolean())
            throw new IllegalArgumentException();
        _do_checkPermission();
    }

    public void checkCreateClassLoader() {
        _do_checkPermission();
    }

    public void checkDelete(String file) {
        if (file == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkExec(String cmd) {
        if (cmd == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkExit(int status) {
        _do_checkPermission();
    }

    public void checkLink(String lib) {
        if (lib == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkListen(int port) {
        _do_checkPermission();
    }

    public void checkMulticast(InetAddress maddr) {
        if (maddr == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkMulticast(InetAddress maddr, byte ttl) {
        if (maddr == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkPackageAccess(String pkg) {
        if (pkg == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkPackageDefinition(String pkg) {
        if (pkg == null)
            throw new NullPointerException();
        _do_checkPermission();
    }

    public void checkPermission(Permission perm) {
        if (perm == null)
            throw new NullPointerException();
        _do_checkPermission(perm);
    }

    public void checkPermission(Permission perm, Object context) {
        if (context instanceof java.security.AccessControlContext) {
            if (perm == null)
                throw new NullPointerException();
            _do_checkPermission(perm);
        } else {
            throw new SecurityException();
        }
    }

    public void checkPrintJobAccess() {
        _do_checkPermission();
    }

    public void checkPropertiesAccess() {
        _do_checkPermission();
    }

    public void checkPropertyAccess(String key) {
        _do_checkPermission();
    }

    public void checkRead(FileDescriptor fd) {
        _do_checkPermission();
    }

    public void checkRead(String file) {
        _do_checkPermission();
    }

    public void checkRead(String file, Object context) {
        _do_checkPermission();
    }

    public void checkSecurityAccess(String _target) {
        if (_target == null)
            throw new NullPointerException();
        if (_target.isEmpty())
            throw new IllegalArgumentException();
        _do_checkPermission();
    }

    public void checkSetFactory() {
        _do_checkPermission();
    }

    public void checkWrite(FileDescriptor fd) {
        _do_checkPermission();
    }

    public void checkWrite(String file) {
        _do_checkPermission();
    }

    @SuppressWarnings("ConstantValue")
    public Object getSecurityContext() {
        Object result = Engine.makeSymbolic(java.security.AccessControlContext.class);
        Engine.assume(result != null);
        return result;
    }
}
