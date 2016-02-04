package _3Friday;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by plamen on 2/4/16.
 */
public class Main {
    public static void main(String[] args) {
        List<Point> inPoints = Point.generatePoints();
        Map<Point, Point> outMap = new TreeMap<>();

        Thread t1 = new Thread(new PointRunnable(inPoints, 0,
                inPoints.size() / 2, outMap));
        Thread t2 = new Thread(new PointRunnable(inPoints, inPoints.size() / 2 + 1,
                inPoints.size() - 1, outMap));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Map.Entry e : outMap.entrySet()) {
            System.out.printf("%s <-> %s%n", e.getKey(), e.getValue());
        }
    }
}
