package stub.java.util.map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RequestMultiValueMap implements Map<String, String[]> {
    /* Used to define kind of stored values (HEADER, PARAM, MATRIX, PATH, COOKIE)*/
    public String sourcePrefix;
    
    public RequestMultiValueMap(String sourcePrefix) {
        this.sourcePrefix = sourcePrefix;
    }

    public int size() { throw new LinkageError(); }

    public boolean isEmpty() { throw new LinkageError(); }

    public boolean containsKey(Object key) { throw new LinkageError(); }

    public boolean containsValue(Object value) { throw new LinkageError(); }

    public String[] get(Object key) { throw new LinkageError(); }

    public String set(String key, Object value) { throw new LinkageError(); }

    @Nullable
    public String[] put(String key, String[] value) { throw new LinkageError(); }

    public String[] remove(Object key) { throw new LinkageError(); }

    public void putAll(@NotNull Map<? extends String, ? extends String[]> m) { throw new LinkageError(); }

    public void clear() { throw new LinkageError(); }

    @NotNull
    public Set<String> keySet() { throw new LinkageError(); }

    @NotNull
    public Collection<String[]> values() { throw new LinkageError(); }

    @NotNull
    public Set<Entry<String, String[]>> entrySet() { throw new LinkageError(); }
}
