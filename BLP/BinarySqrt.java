package BLP;

public class BinarySqrt {


    private static final double DELTA =  0.00001;

    double sqrt(double n) {
        double low = 1;
        double high = n;
        double middle = 0;

        while((high - low) > DELTA) {
            middle = low + (high - low) / 2;
            double v = middle * middle;
            if(v - n > DELTA) {
                high = middle;
            }
        else {
                low = middle;
            }
        }
        return middle;
    }
}
