package _3Friday;

import java.util.List;
import java.util.Map;

/**
 * Created by plamen on 2/4/16.
 */
public class PointRunnable implements Runnable {

    List<Point> mInPoints;
    int mIndexFrom;
    int mIndexTo;
    Map<Point, Point> mOutMap;

    public PointRunnable(List<Point> inPoints, int indexFrom,
                         int indexTo, Map<Point, Point> outMap) {
        super();

        mInPoints = inPoints;
        mIndexFrom = indexFrom;
        mIndexTo = indexTo;
        mOutMap = outMap;
    }

    @Override
    public void run() {
        Point.doCalculations(mInPoints, mIndexFrom, mIndexTo, mOutMap);
    }
}
