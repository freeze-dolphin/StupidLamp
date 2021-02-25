package io.freeze_dolphin.stupid_lamp;

import java.util.ArrayList;

public class Point24Calculator {

    private final ArrayList<Integer> list;
    private final int point;

    private String rt = "";

    public Point24Calculator(ArrayList<Integer> l, int pt) {
        list = l;
        point = pt;
    }

    public String calc() {
        process(new ArrayList<>());
        while (rt.equals(rt)) {
            return rt;
        }
        return null;
    }

    private static String p(int a) {
        return (a < 0 ? ("(" + a + ")") : String.valueOf(a));
    }

    private void process(ArrayList<String> str) {
        int length = list.size();
        if (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int b = list.remove(j);
                    int a = list.remove(i);
                    list.add(0, a + b);
                    str.add(a + " + " + p(b) + " = " + (a + b));
                    process(str);
                    list.remove(0);
                    list.add(i, a);
                    list.add(j, b);
                    str.remove(str.size() - 1);

                    b = list.remove(j);
                    a = list.remove(i);
                    list.add(0, a - b);
                    str.add(a + " - " + p(b) + " = " + (a - b));
                    process(str);
                    list.remove(0);
                    list.add(i, a);
                    list.add(j, b);
                    str.remove(str.size() - 1);

                    b = list.remove(j);
                    a = list.remove(i);
                    list.add(0, b - a);
                    str.add(b + " - " + p(a) + " = " + (b - a));
                    process(str);
                    list.remove(0);
                    list.add(i, a);
                    list.add(j, b);
                    str.remove(str.size() - 1);

                    b = list.remove(j);
                    a = list.remove(i);
                    list.add(0, a * b);
                    str.add(a + " * " + p(b) + " = " + (a * b));
                    process(str);
                    list.remove(0);
                    list.add(i, a);
                    list.add(j, b);
                    str.remove(str.size() - 1);

                    b = list.remove(j);
                    a = list.remove(i);
                    if (b != 0) {
                        list.add(0, a / b);
                        str.add(a + " / " + p(b) + " = " + (a / b));
                        process(str);
                        list.remove(0);
                        list.add(i, a);
                        list.add(j, b);
                        str.remove(str.size() - 1);
                    } else {
                        list.add(i, a);
                        list.add(j, b);
                    }

                    b = list.remove(j);
                    a = list.remove(i);
                    if (a != 0) {
                        list.add(0, b / a);
                        str.add(b + " / " + p(a) + " = " + (b / a));
                        process(str);
                        list.remove(0);
                        list.add(i, a);
                        list.add(j, b);
                        str.remove(str.size() - 1);
                    } else {
                        list.add(i, a);
                        list.add(j, b);
                    }
                }
            }
        } else {
            if (str.get(str.size() - 1).endsWith(" = " + point)) {
                for (int i = 0; i < str.size(); i++) {
                    rt = rt + str.get(i) + (i == str.size() - 1 ? "" : "\t");
                }
                rt = rt + "\n";
            }
        }
    }

}
