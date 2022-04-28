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

    @Test (expected = FigureNotFoundException.class)
    public void findFigure()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.C8);
        logic.add(black);
        Cell.findBy(4, 0);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void findFigureWays()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.D4);
        logic.add(black);
        black.way(Cell.F7);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void figureCopy()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.D4);
        logic.add(black);
        black.way(Cell.F8);
        black.copy(Cell.F6);
    }
}