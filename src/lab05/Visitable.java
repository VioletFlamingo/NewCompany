package lab05;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface Visitable extends Serializable{
    void accept(Visitor visitor);
}
