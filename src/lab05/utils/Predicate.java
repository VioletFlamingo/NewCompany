package lab05.utils;

import java.io.Serializable;

/**
 * Created by Paulina on 19.04.2014.
 */

/**
 * ??????
 * @param <T>
 */
public interface Predicate<T> extends Serializable {
    /**
     * Check condition on given element.
     * @param element object on which condition is about to be checked
     * @return statement whether given element satisfied the condition
     */
    boolean apply(T element);
}
