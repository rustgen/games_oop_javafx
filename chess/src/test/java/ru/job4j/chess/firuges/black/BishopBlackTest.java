package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack black = new BishopBlack(Cell.G8);
        Assert.assertThat(black.position(), is(Cell.G8));
    }

    @Test
    public void copy() {
        BishopBlack black = new BishopBlack(Cell.G8);
        black.copy(Cell.B8);
        Assert.assertThat(black.copy(Cell.B8).position(), is(Cell.B8));
    }

    @Test
    public void moveG5() {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] result = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(result, is(black.way(Cell.G5)));
    }

    @Test
    public void checkDiagonal() {
        BishopBlack black = new BishopBlack(Cell.C1);
        black.way(Cell.G5);
        Assert.assertTrue(black.isDiagonal(Cell.C1, Cell.G5));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() {
        BishopBlack black = new BishopBlack(Cell.C1);
        black.way(Cell.G4);
        black.isDiagonal(Cell.C1, Cell.G4);
    }
}