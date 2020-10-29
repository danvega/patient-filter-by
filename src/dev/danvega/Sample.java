package dev.danvega;

public class Sample {

    private Time time;
    private double value;

    public Sample(Time time, double value) {
        this.time = time;
        this.value = value;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "time=" + time +
                ", value=" + value +
                '}';
    }
}
