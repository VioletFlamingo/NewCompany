package lab05.utils;

import java.io.Serializable;

/**
 * Created by Paulina on 19.04.2014.
 */
public interface Predicate<T> extends Serializable {
    boolean apply(T element);
}
