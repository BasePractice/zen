package ru.zen.practice.algorithms;

/** Формула Андрей Хлебников*/
public final class FlatTriangularMatrix extends AbstractMatrix2D {
    public FlatTriangularMatrix(long count) {
        super(count);
    }

    protected int index(long row, long col) {
        long emptyElements = ((row + 1) * (row + 1)) - countElements(row + 1);
        long nonEmptyElements = (count * (row + 1)) - emptyElements;
        long countRight = count - col;
        return (int) (nonEmptyElements - countRight);
    }
}
