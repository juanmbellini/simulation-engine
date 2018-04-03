package ar.edu.itba.ss.g7.engine.io;

import ar.edu.itba.ss.g7.engine.simulation.State;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Queue;

/**
 * An extension of {@link TextFileSaver} that saves the simulation results in an Ovito file.
 *
 * @param <S> A concrete subtype of {@link State}.
 */
public abstract class OvitoFileSaver<S extends State> extends TextFileSaver<S> {

    /**
     * Constructor.
     *
     * @param filePath The path in which the file will be saved.
     */
    protected OvitoFileSaver(String filePath) {
        super(filePath);
    }

    @Override
    void doSave(Writer writer, Queue<S> simulationStates) throws IOException {
        int frame = 0;
        while (!simulationStates.isEmpty()) {
            saveState(writer, simulationStates.poll(), frame);
            frame++;
        }
    }

    /**
     * Saves the given {@code state}, appending it to the given {@code writer}.
     *
     * @param state  The state to be saved.
     * @param writer The {@link FileWriter} in which the {@code state} will be saved into..
     */
    /* package */
    abstract void saveState(Writer writer, S state, int frame) throws IOException;
}
