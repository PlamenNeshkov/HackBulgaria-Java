package _3Friday;

import java.util.*;

/**
 * Created by plamen on 2/4/16.
 */
public class Point implements Comparable<Point> {
    private int mX;
    private int mY;

    public Point(int x, int y) {
        mX = x;
        mY = y;
    }

    public Point() {
        this(0, 0);
    }

    public static List<Point> generatePoints() {
        List<Point> points = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 100_000; i++) {
            int x = rand.nextInt(10000) + 1;
            int y = rand.nextInt(10000) + 1;
            points.add(new Point(x, y));
        }

        return points;
    }

    public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
        Map<Point, Point> outMap = new TreeMap<>();
        doCalculations(generatedPoints, 0, generatedPoints.size() - 1, outMap);
        return outMap;
    }

    protected static void doCalculations(List<Point> inPoints, int indexFrom,
                                       int indexTo, Map<Point, Point> outMap) {
        for (int i = indexFrom; i <= indexTo; i++) {
            Point p1 = inPoints.get(i);
            double minDistanceSq = Integer.MAX_VALUE;
            Point closest = null;

            for (Point p2 : inPoints) {
                if (p1 == p2) {
                    continue;
                }

                double distanceSq = Math.pow(p2.getX() - p1.getX(), 2)
                        + Math.pow(p2.getY() - p1.getY(), 2);

                if (distanceSq < minDistanceSq) {
                    closest = p2;
                    minDistanceSq = distanceSq;
                }
            }

            outMap.put(p1, closest);
        }
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.getX() == other.getX()) {
            if (this.getY() == other.getY()) {
                return 0;
            } else if (this.getY() < other.getY()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.getX() < other.getX()) {
            return -1;
        } else {
            return 1;
        }
     }

    @Override
    public String toString() {
        return String.format("Point{%5d,%5d}", mX, mY);
    }
}
