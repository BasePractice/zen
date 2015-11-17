package ru.zen.practice.algorithms;

abstract class AbstractMatrix2D {
    protected final long count;
    private final Number[] data;

    public AbstractMatrix2D(long count) {
        this.count = count;
        this.data = new Number[(int) countElements(count)];
    }

    public final void put(long row, long col, Number number) {
        if (row <= col) {
            int index = index(row, col);
            if (index != number.intValue()) {
                System.out.println("Real: " + number.intValue() + ", Calculate: " + index + ", j = " + row + ", i = " + col);
            }
            data[index] = number;
        }
    }

    public final Number get(int row, int col) {
        if (row > col)
            return 0;
        return data[index(row, col)];
    }

    protected abstract int index(long row, long col);

    protected static long countElements(long n) {
        return ((n * (n - 1)) / 2) + n;
    }
}
