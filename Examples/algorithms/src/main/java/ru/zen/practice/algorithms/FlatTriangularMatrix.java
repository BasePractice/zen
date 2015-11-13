package ru.zen.practice.algorithms;

public final class FlatTriangularMatrix {
    private final int count;
    private final Number[] data;

    public FlatTriangularMatrix(int count) {
        this.count = count;
        this.data = new Number[(int) countElements(count)];
    }

    public void put(long row, long col, Number number) {
        if (row <= col)
            data[index(row, col)] = number;
    }

    public Number get(long row, long col) {
        if (row > col)
            return 0;
        return data[index(row, col)];
    }

    private int index(long row, long col) {
        long emptyElements = ((row + 1) * (row + 1)) - countElements(row + 1);
        long nonEmptyElements = (count * (row + 1)) - emptyElements;
        long countRight = count - col;
        return (int) (nonEmptyElements - countRight);
    }

    private static long countElements(long n) {
        return ((n * (n - 1)) / 2) + n;
    }
}
