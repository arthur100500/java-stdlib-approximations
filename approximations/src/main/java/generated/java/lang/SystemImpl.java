package generated.java.lang;

import generated.libsl.utils.SymbolicInputStreamImpl;
import generated.runtime.LibSLGlobals;
import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SecurityException;
import java.lang.String;
import java.lang.UnsatisfiedLinkError;
import java.util.Properties;
import jdk.internal.misc.VM;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings({"unused", "removal"})
@Approximate(java.lang.System.class)
public final class SystemImpl {
    private static final LibSLRuntime.Map<String, String> propsMap = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());

    private static volatile SecurityManager security = null;

    private static Properties props = null;

    @SuppressWarnings("FieldMayBeFinal")
    private static Console console = null;

    public static InputStream in = null;

    public static PrintStream out = null;

    public static PrintStream err = null;

    private static final long NANOTIME_BEGINNING_OF_TIME = 1000L;

    private static final long NANOTIME_WARP_MAX = 1000L;

    private static final LibSLRuntime.Map<Object, Integer> identityHashCodeMap = new LibSLRuntime.Map<>(new LibSLRuntime.IdentityMapContainer<>());

    static {
        initPhase1();
        initPhase2();
        initPhase3();
    }

    private SystemImpl() { }

    private static void _initProperties() {
        LibSLRuntime.Map<String, String> pm = propsMap;
        int javaVersion = 8;
        String userName = "Admin";
        pm.set("file.encoding", "Cp1251");
        pm.set("sun.io.unicode.encoding", "UnicodeLittle");
        pm.set("sun.jnu.encoding", "Cp1251");
        pm.set("sun.stderr.encoding", "cp866");
        pm.set("sun.stdout.encoding", "cp866");
        String[] versionStrings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
        String versionString = versionStrings[javaVersion];
        pm.set("java.specification.name", "Java Platform API Specification");
        pm.set("java.specification.vendor", "Oracle Corporation");
        pm.set("java.specification.version", versionString);
        pm.set("java.vm.info", "mixed mode");
        pm.set("java.vm.name", "OpenJDK 64-Bit Server VM");
        pm.set("java.vm.specification.name", "Java Virtual Machine Specification");
        pm.set("java.vm.specification.vendor", "Oracle Corporation");
        pm.set("java.vm.specification.version", versionString);
        pm.set("java.vm.vendor", "Eclipse Adoptium");
        pm.set("java.vm.version", versionString.concat(".0.362+9"));
        pm.set("java.library.path", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot\\bin;C:\\Windows\\Sun\\Java\\bin;C:\\Windows\\system32;.");
        pm.set("java.home", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot");
        pm.set("sun.boot.library.path", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot\\bin");
        pm.set("java.io.tmpdir", "T:\\Temp\\");
        pm.set("java.class.path", ".");
        if (LibSLGlobals.SYSTEM_IS_WINDOWS) {
            pm.set("file.separator", "\\");
            pm.set("line.separator", "\r\n");
            pm.set("path.separator", ";");
        } else {
            pm.set("file.separator", "/");
            pm.set("line.separator", "\n");
            pm.set("path.separator", ":");
        }
        pm.set("user.country", "RU");
        pm.set("user.country.format", "US");
        pm.set("user.language", "ru");
        String[] bytecodeVersions = { "?", "?", "?", "?", "?", "49.0", "50.0", "51.0", "52.0", "53.0", "54.0", "55.0", "?", "?", "?", "?" };
        pm.set("java.class.version", bytecodeVersions[javaVersion]);
        pm.set("os.arch", "amd64");
        pm.set("os.name", "Windows 10");
        pm.set("os.version", "10.0");
        pm.set("sun.arch.data.model", "64");
        pm.set("sun.cpu.endian", "little");
        pm.set("sun.cpu.isalist", "amd64");
        pm.set("sun.desktop", "windows");
        pm.set("user.dir", "D:\\Company\\Prod\\Service");
        pm.set("user.home", "C:\\Users\\".concat(userName));
        pm.set("user.name", userName);
        pm.set("user.script", "");
        pm.set("user.timezone", "");
        pm.set("user.variant", "");
        pm.set("sun.java.command", "org.example.MainClass");
        pm.set("awt.toolkit", "sun.awt.windows.WToolkit");
        pm.set("java.awt.graphicsenv", "sun.awt.Win32GraphicsEnvironment");
        pm.set("java.awt.printerjob", "sun.awt.windows.WPrinterJob");
        pm.set("sun.java.launcher", "SUN_STANDARD");
        pm.set("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers");
        pm.set("sun.nio.MaxDirectMemorySize", "-1");
        pm.set("sun.os.patch.level", "");
        pm.set("java.vm.compressedOopsMode", "Zero based");
        pm.set("jdk.boot.class.path.append", "");
        pm.set("jdk.debug", "release");
        props = null;
    }

    @SuppressWarnings("DataFlowIssue")
    private static void initPhase1() {
        _initProperties();
        in = new SymbolicInputStreamImpl(1000, false, -1, null, false, 0, -1, 0);
        out = (PrintStream) (Object) new System_PrintStreamImpl(false, false);
        err = (PrintStream) (Object) new System_PrintStreamImpl(false, false);
        VM.initLevel(1);
    }

    @SuppressWarnings("UnusedReturnValue")
    private static int initPhase2() {
        VM.initLevel(2);
        return 0;
    }

    private static void initPhase3() {
        security = null;
        VM.initLevel(3);
        VM.initLevel(4);
    }

    private static void _checkKey(String key) {
        if (key == null)
            throw new NullPointerException("key can't be null");
        if (key.isEmpty())
            throw new NullPointerException("key can't be empty");
    }

    public static String clearProperty(String key) {
        _checkKey(key);
        SecurityManager sm = security;
        if (sm != null)
            sm.checkPermission(new java.util.PropertyPermission(key, "write"));
        LibSLRuntime.Map<String, String> pm = propsMap;
        if (!pm.hasKey(key))
            return null;

        String result = pm.get(key);
        pm.remove(key);
        return result;
    }

    public static Console console() {
        return console;
    }

    public static void exit(int status) {
        LibSLRuntime.error("Unexpected shutdown");
    }

    public static void gc() { }

    public static Properties getProperties() {
        SecurityManager sm = security;
        if (sm != null)
            sm.checkPropertiesAccess();
        return props;
    }

    public static String getProperty(String key) {
        _checkKey(key);
        SecurityManager sm = security;
        if (sm != null)
            sm.checkPropertyAccess(key);
        LibSLRuntime.Map<String, String> pm = propsMap;
        if (!pm.hasKey(key))
            return null;

        return pm.get(key);
    }

    public static String getProperty(String key, String def) {
        _checkKey(key);
        SecurityManager sm = security;
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }
        LibSLRuntime.Map<String, String> pm = propsMap;
        if (pm.hasKey(key))
            return pm.get(key);

        return def;
    }

    public static SecurityManager getSecurityManager() {
        return security;
    }

    @SuppressWarnings({"ConstantValue", "DataFlowIssue"})
    public static String getenv(String name) {
        SecurityManager sm = security;
        if (sm != null)
            sm.checkPermission(new RuntimePermission("getenv.".concat(name)));
        String result = Engine.makeSymbolic(String.class);
        Engine.assume(result != null);
        int len = result.length();
        Engine.assume(len >= 0);
        Engine.assume(len < 250);
        return result;
    }

    @SuppressWarnings("DataFlowIssue")
    public static int identityHashCode(Object x) {
        if (x == null)
            return 0;

        if (identityHashCodeMap.hasKey(x)) {
            Integer value = identityHashCodeMap.get(x);
            Engine.assume(value != null);
            return value;
        }

        int result = identityHashCodeMap.size();
        identityHashCodeMap.set(x, result);
        return result;
    }

    public static String lineSeparator() {
        return propsMap.get("line.separator");
    }

    @SuppressWarnings({"DuplicateCondition", "ConstantValue"})
    public static void load(String filename) {
        if (filename == null)
            throw new NullPointerException();
        if (Engine.makeSymbolicBoolean())
            throw new SecurityException("<message>");
        if (Engine.makeSymbolicBoolean())
            throw new UnsatisfiedLinkError("<message>");
    }

    @SuppressWarnings({"DuplicateCondition", "ConstantValue"})
    public static void loadLibrary(String libName) {
        if (libName == null)
            throw new NullPointerException();
        if (Engine.makeSymbolicBoolean()) {
            throw new SecurityException("<message>");
        }
        if (Engine.makeSymbolicBoolean()) {
            throw new UnsatisfiedLinkError("<message>");
        }
    }

    public static String mapLibraryName(String libName) {
        if (libName == null)
            throw new NullPointerException();

        int len = libName.length();
        if (len > 240)
            throw new IllegalArgumentException("name too long");

        if (LibSLGlobals.SYSTEM_IS_WINDOWS)
            return libName.concat(".dll");

        if (LibSLGlobals.SYSTEM_IS_MAC)
            return "lib".concat(libName).concat(".dylib");

        return "lib".concat(libName).concat(".so");
    }

    public static void runFinalization() { }

    public static void setErr(PrintStream stream) {
        if (security != null)
            security.checkPermission(new RuntimePermission("setIO"));
        err = stream;
    }

    public static void setIn(InputStream stream) {
        if (security != null)
            security.checkPermission(new RuntimePermission("setIO"));
        in = stream;
    }

    public static void setOut(PrintStream stream) {
        if (security != null)
            security.checkPermission(new RuntimePermission("setIO"));
        out = stream;
    }

    public static void setProperties(Properties p) {
        if (security != null)
            security.checkPropertiesAccess();
        props = p;
    }

    public static String setProperty(String key, String value) {
        if (key == null)
            throw new NullPointerException("key can't be null");
        if (key.isEmpty())
            throw new NullPointerException("key can't be empty");
        if (security != null)
            security.checkPermission(new java.util.PropertyPermission(key, "write"));
        LibSLRuntime.Map<String, String> pm = propsMap;
        String result;
        if (pm.hasKey(key)) {
            result = pm.get(key);
        } else {
            result = null;
        }
        pm.set(key, value);
        return result;
    }

    public static void setSecurityManager(SecurityManager s) {
        if (security != null)
            security.checkPermission(new RuntimePermission("setSecurityManager"));
        security = s;
    }
}
