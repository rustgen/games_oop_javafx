package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;


public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void findFigure()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C8);
        logic.add(black);
        Assert.assertThat(Cell.findBy(2, 0), is (black.position()));
    }

    @Test
    public void findFigureWays()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.D4);
        logic.add(black);
        logic.move(Cell.D4, Cell.F6);
        Cell[] result = new Cell[]{Cell.E5, Cell.F6};
        Assert.assertThat(result, is (black.way(Cell.F6)));
    }

    @Test
    public void figureCopy()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.D4);
        logic.add(black);
        black.way(Cell.F6);
        Figure[] figures = new Figure[] {black.copy(Cell.F6)};
        Assert.assertThat(figures, is (black.position()));
    }
}