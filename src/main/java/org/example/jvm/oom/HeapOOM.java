package org.example.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvle
 * @date 2021-07-06 10:14
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
