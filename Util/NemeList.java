package Util;

import java.util.ArrayList;

public class NemeList<T> extends ArrayList<T> {

    public T getLast(){
        int idxLast = this.size() - 1;
        return this.get(idxLast);
    }
}
