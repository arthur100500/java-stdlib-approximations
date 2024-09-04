package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Approximate(org.springframework.data.domain.PageImpl.class)
public class PageImplImpl<T> {

    private final ArrayList<T> content;

    private final long total;

    private final Pageable pageable;

    public PageImplImpl(List<T> content, Pageable pageable, long total) {
        this.pageable = pageable;
        this.content = new ArrayList<>(content);
        this.total = pageable.toOptional().filter(it -> !content.isEmpty())
                .filter(it -> it.getOffset() + it.getPageSize() > total)
                .map(it -> it.getOffset() + content.size())
                .orElse(total);
    }

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    public int getSize() {
        return pageable.isPaged() ? pageable.getPageSize() : content.size();
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public int getNumber() {
        return pageable.isPaged() ? pageable.getPageNumber() : 0;
    }

    public boolean hasPrevious() {
        return getNumber() > 0;
    }

    public boolean isFirst() {
        return !hasPrevious();
    }

    public boolean isLast() {
        return !hasNext();
    }

    public boolean hasNext() {
        return getNumber() + 1 < getTotalPages();
    }

    public Pageable nextPageable() {
        return hasNext() ? pageable.next() : Pageable.unpaged();
    }

    public Pageable previousPageable() {
        return hasPrevious() ? pageable.previousOrFirst() : Pageable.unpaged();
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

    public List<T> getContent() {
        return content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public Sort getSort() {
        return pageable.getSort();
    }

    public Iterator<T> iterator() {
        return content.iterator();
    }
}
