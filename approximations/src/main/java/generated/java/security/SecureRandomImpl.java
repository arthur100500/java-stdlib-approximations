package generated.java.security;

import generated.java.util.RandomImpl;
import generated.runtime.LibSLGlobals;

import java.io.Serial;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

@SuppressWarnings("unused")
@Approximate(java.security.SecureRandom.class)
public class SecureRandomImpl extends RandomImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 4940670005562187L;

    private static final LibSLRuntime.Map<String, Object> defaultProvidersMap = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());

    static {
        LibSLRuntime.Map<String, Object> dpMap = defaultProvidersMap;
        Object o = LibSLGlobals.SOMETHING;
        dpMap.set("SUN", o);
        dpMap.set("SunRsaSign", o);
        dpMap.set("SunJSSE", o);
        dpMap.set("SunJCE", o);
        dpMap.set("Apple", o);
        dpMap.set("JdkLDAP", o);
        dpMap.set("SunJGSS", o);
        dpMap.set("SunSASL", o);
        dpMap.set("SunPCSC", o);
        dpMap.set("XMLDSig", o);
        dpMap.set("SunPKCS11", o);
        dpMap.set("SunEC", o);
        dpMap.set("SunMSCAPI", o);
        dpMap.set("OracleUcrypto", o);
        dpMap.set("JdkSASL", o);
    }

    public Provider provider;

    public String algorithm;

    public boolean defaultProvider;

    public SecureRandomImpl(Provider provider, String algorithm, boolean defaultProvider) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.defaultProvider = defaultProvider;
    }

    public SecureRandomImpl() {
        this(null, "SHA1PRNG", false);
    }

    protected SecureRandomImpl(SecureRandomSpi secureRandomSpi, Provider provider) {
        LibSLRuntime.error("Protected constructor call");
    }

    private SecureRandomImpl(SecureRandomSpi secureRandomSpi, Provider provider, String algorithm) {
        LibSLRuntime.error("Private constructor call");
    }

    public SecureRandomImpl(byte[] seed) {
        this();
    }

    private static boolean _isDefaultProvider(Provider curProvider) {
        if (curProvider == null)
            return false;

        String providerName = curProvider.getName();
        return defaultProvidersMap.hasKey(providerName);
    }

    @SuppressWarnings("ConstantValue")
    public static SecureRandomImpl getInstance(String _algorithm) throws NoSuchAlgorithmException {
        Provider resultProvider = Engine.makeSymbolic(Provider.class);
        String resultAlgorithm = Engine.makeSymbolic(String.class);
        if (resultAlgorithm == null)
            throw new NoSuchAlgorithmException();

        int resultAlgorithmLength = resultAlgorithm.length();
        Engine.assume(resultAlgorithmLength > 0);
        return new SecureRandomImpl(resultProvider, resultAlgorithm, _isDefaultProvider(resultProvider));
    }

    @SuppressWarnings("ConstantValue")
    public static SecureRandomImpl getInstance(String _algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null)
            throw new IllegalArgumentException();

        // TODO: use arguments '_algorithm' and 'provider'?
        Provider resultProvider = Engine.makeSymbolic(Provider.class);
        String resultAlgorithm = Engine.makeSymbolic(String.class);
        if (resultAlgorithm == null)
            throw new NoSuchAlgorithmException();

        int resultAlgorithmLength = resultAlgorithm.length();
        Engine.assume(resultAlgorithmLength > 0);
        return new SecureRandomImpl(resultProvider, resultAlgorithm, _isDefaultProvider(resultProvider));
    }

    @SuppressWarnings("ConstantValue")
    public static SecureRandomImpl getInstance(String _algorithm, String providerName) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (providerName == null || providerName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider resultProvider = Engine.makeSymbolic(Provider.class);
        String resultAlgorithm = Engine.makeSymbolic(String.class);
        if (resultProvider == null)
            throw new NoSuchProviderException();
        if (resultAlgorithm == null)
            throw new NoSuchAlgorithmException();
        int resultAlgorithmLength = resultAlgorithm.length();
        Engine.assume(resultAlgorithmLength > 0);
        return new SecureRandomImpl(resultProvider, resultAlgorithm, _isDefaultProvider(resultProvider));
    }

    @SuppressWarnings("ConstantValue")
    public static SecureRandomImpl getInstanceStrong() throws java.security.NoSuchAlgorithmException {
        String property = Security.getProperty("securerandom.strongAlgorithms");
        if (property == null)
            throw new NoSuchAlgorithmException();
        if (property.isEmpty())
            throw new NoSuchAlgorithmException();
        Provider resultProvider = Engine.makeSymbolic(Provider.class);
        String resultAlgorithm = Engine.makeSymbolic(String.class);
        if (resultAlgorithm == null)
            throw new NoSuchAlgorithmException();

        return new SecureRandomImpl(resultProvider, resultAlgorithm, _isDefaultProvider(resultProvider));
    }

    public static byte[] getSeed(int numBytes) {
        if (numBytes < 0)
            throw new IllegalArgumentException();

        return Engine.makeSymbolicByteArray(numBytes);
    }

    public DoubleStream doubles() {
        return super.doubles();
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return super.doubles(randomNumberOrigin, randomNumberBound);
    }

    public DoubleStream doubles(long streamSize) {
        return super.doubles(streamSize);
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return super.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public byte[] generateSeed(int numBytes) {
        if (numBytes < 0)
            throw new IllegalArgumentException();

        return Engine.makeSymbolicByteArray(numBytes);
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public IntStream ints() {
        return super.ints();
    }

    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return super.ints(randomNumberOrigin, randomNumberBound);
    }

    public IntStream ints(long streamSize) {
        return super.ints(streamSize);
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return super.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public LongStream longs() {
        return super.longs();
    }

    public LongStream longs(long streamSize) {
        return super.longs(streamSize);
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return super.longs(randomNumberOrigin, randomNumberBound);
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return super.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public boolean nextBoolean() {
        return super.nextBoolean();
    }

    public void nextBytes(byte[] bytes) {
        super.nextBytes(bytes);
    }

    public double nextDouble() {
        return super.nextDouble();
    }

    public float nextFloat() {
        return super.nextFloat();
    }

    public synchronized double nextGaussian() {
        return super.nextGaussian();
    }

    public int nextInt() {
        return super.nextInt();
    }

    public int nextInt(int bound) {
        return super.nextInt(bound);
    }

    public long nextLong() {
        return super.nextLong();
    }

    public synchronized void setSeed(byte[] seed) {
        if (seed == null && Engine.makeSymbolicBoolean())
            throw new NullPointerException();
    }

    public void setSeed(long seed) {
        super.setSeed(seed);
    }
}
