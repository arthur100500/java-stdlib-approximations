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
import stub.java.lang.SystemHelpers;

@SuppressWarnings({"unused", "removal"})
@Approximate(java.lang.System.class)
public final class SystemImpl {

    private static Properties props;

    private static volatile SecurityManager security = null;

    @SuppressWarnings("FieldMayBeFinal")
    private static Console cons = null;

    public static InputStream in = null;

    public static PrintStream out = null;

    public static PrintStream err = null;

    static {
        initPhase1();
        initPhase2();
        initPhase3();
    }

    private SystemImpl() { }

    private static void _initProperty(LibSLRuntime.Map<String, String> pm, Properties properties, String key, String value) {
        pm.set(key, value);
        switch (key) {
            // Do not add private system properties to the Properties
            case "sun.nio.MaxDirectMemorySize":
            case "sun.nio.PageAlignDirectMemory":
                // used by java.lang.Integer.IntegerCache
            case "java.lang.Integer.IntegerCache.high":
                // used by sun.launcher.LauncherHelper
            case "sun.java.launcher.diag":
                // used by jdk.internal.loader.ClassLoaders
            case "jdk.boot.class.path.append":
                break;
            default:
                properties.put(key, value);
        }
    }

    private static void _initProperties() {
        props = new Properties();
        int javaVersion = 8;
        String userName = "Admin";
        props.setProperty("file.encoding", "Cp1251");
        props.setProperty("sun.io.unicode.encoding", "UnicodeLittle");
        props.setProperty("sun.jnu.encoding", "Cp1251");
        props.setProperty("sun.stderr.encoding", "cp866");
        props.setProperty("sun.stdout.encoding", "cp866");
        String[] versionStrings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
        String versionString = versionStrings[javaVersion];
        props.setProperty("java.specification.name", "Java Platform API Specification");
        props.setProperty("java.specification.vendor", "Oracle Corporation");
        props.setProperty("java.specification.version", versionString);
        props.setProperty("java.vm.info", "mixed mode");
        props.setProperty("java.vm.name", "OpenJDK 64-Bit Server VM");
        props.setProperty("java.vm.specification.name", "Java Virtual Machine Specification");
        props.setProperty("java.vm.specification.vendor", "Oracle Corporation");
        props.setProperty("java.vm.specification.version", versionString);
        props.setProperty("java.vm.vendor", "Eclipse Adoptium");
        props.setProperty("java.vm.version", versionString.concat(".0.362+9"));
        props.setProperty("java.library.path", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot\\bin;C:\\Windows\\Sun\\Java\\bin;C:\\Windows\\system32;.");
        props.setProperty("java.home", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot");
        props.setProperty("sun.boot.library.path", "C:\\Program Files\\Eclipse Adoptium\\jdk-8.0.362.9-hotspot\\bin");
        props.setProperty("java.io.tmpdir", "T:\\Temp\\");
        props.setProperty("java.class.path", ".");
        if (LibSLGlobals.SYSTEM_IS_WINDOWS) {
            props.setProperty( "file.separator", "\\");
            props.setProperty("line.separator", "\r\n");
            props.setProperty( "path.separator", ";");
        } else {
            props.setProperty("file.separator", "/");
            props.setProperty("line.separator", "\n");
            props.setProperty("path.separator", ":");
        }
        props.setProperty("user.country", "RU");
        props.setProperty("user.country.format", "US");
        props.setProperty("user.language", "ru");
        String[] bytecodeVersions = { "?", "?", "?", "?", "?", "49.0", "50.0", "51.0", "52.0", "53.0", "54.0", "55.0", "?", "?", "?", "?" };
        props.setProperty("java.class.version", bytecodeVersions[javaVersion]);
        props.setProperty("os.arch", "amd64");
        props.setProperty("os.name", "Windows 10");
        props.setProperty("os.version", "10.0");
        props.setProperty("sun.arch.data.model", "64");
        props.setProperty("sun.cpu.endian", "little");
        props.setProperty("sun.cpu.isalist", "amd64");
        props.setProperty("sun.desktop", "windows");
        props.setProperty("user.dir", "D:\\Company\\Prod\\Service");
        props.setProperty("user.home", "C:\\Users\\".concat(userName));
        props.setProperty("user.name", userName);
        props.setProperty("user.script", "");
        props.setProperty("user.timezone", "");
        props.setProperty("user.variant", "");
        props.setProperty("sun.java.command", "org.example.MainClass");
        props.setProperty("awt.toolkit", "sun.awt.windows.WToolkit");
        props.setProperty("java.awt.graphicsenv", "sun.awt.Win32GraphicsEnvironment");
        props.setProperty("java.awt.printerjob", "sun.awt.windows.WPrinterJob");
        props.setProperty("sun.java.launcher", "SUN_STANDARD");
        props.setProperty("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers");
        props.setProperty("sun.nio.MaxDirectMemorySize", "-1");
        props.setProperty("sun.os.patch.level", "");
        props.setProperty("java.vm.compressedOopsMode", "Zero based");
        props.setProperty("jdk.boot.class.path.append", "");
        props.setProperty("jdk.debug", "release");
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
        if (!props.containsKey(key))
            return null;

        String result = props.getProperty(key);
        props.remove(key);
        return result;
    }

    public static Console console() {
        return cons;
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
        return props.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        _checkKey(key);
        SecurityManager sm = security;
        if (sm != null) {
            sm.checkPropertyAccess(key);
        }
        if (props.containsKey(key))
            return props.getProperty(key);

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

        if (SystemHelpersImpl.identityHashCodeMap.hasKey(x)) {
            Integer value = SystemHelpersImpl.identityHashCodeMap.get(x);
            Engine.assume(value != null);
            return value;
        }

        int result = SystemHelpersImpl.identityHashCodeMap.size();
        SystemHelpersImpl.identityHashCodeMap.set(x, result);
        return result;
    }

    public static String lineSeparator() {
        return props.getProperty("line.separator");
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
        return (String)props.setProperty(key, value);
    }

    public static void setSecurityManager(SecurityManager s) {
        if (security != null)
            security.checkPermission(new RuntimePermission("setSecurityManager"));
        security = s;
    }
}
