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
        Assert.assertThat(black.position(), is (Cell.G8));
    }

    @Test
    public void copy() {
        BishopBlack black = new BishopBlack(Cell.G8);
        black.copy(Cell.B8);
        Assert.assertThat(black.copy(Cell.B8).position(), is (Cell.B8));
    }
}