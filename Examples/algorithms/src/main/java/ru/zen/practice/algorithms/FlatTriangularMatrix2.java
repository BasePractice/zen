package ru.zen.practice.algorithms;

/**
 * Формула Иван Оперчук
 */
public final class FlatTriangularMatrix2 extends AbstractMatrix2D {
    public FlatTriangularMatrix2(long count) {
        super(count);
    }

    @Override
    protected int index(long row, long col) {
        long p = (Math.abs(row - 2) + row - 2) / 2 * (1 + row - 2) / 2;
        return (int) ((col - row) + (row * count) - p);
    }
}
