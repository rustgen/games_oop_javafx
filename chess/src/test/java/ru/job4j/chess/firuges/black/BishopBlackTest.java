package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack black = new BishopBlack(Cell.G8);
        Cell cell = Cell.findBy(6, 0);
        black.position();
        Assert.assertThat(black.position(), is (cell));
    }

    @Test
    public void copy() {
        BishopBlack black = new BishopBlack(Cell.G8);
        black.copy(Cell.B8);
        Cell cell = Cell.findBy(1, 0);
        Assert.assertThat(black.copy(Cell.B8).position(), is (cell));
    }
}