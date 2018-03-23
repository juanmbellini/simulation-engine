package ar.edu.itba.ss.g7.engine.io;

import ar.edu.itba.ss.g7.engine.simulation.State;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Queue;

/**
 * An extension of {@link FileDataSaver} that saves the simulation results in a text file.
 *
 * @param <S> A concrete subtype of {@link State}.
 */
public abstract class TextFileSaver<S extends State> extends FileDataSaver<S> {

    /**
     * Constructor.
     *
     * @param filePath The path in which the file will be saved.
     */
    protected TextFileSaver(String filePath) {
        super(filePath);
    }

    @Override
    void doSave(File file, Queue<S> simulationStates) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            doSave(writer, simulationStates);
        }
    }

    /**
     * Performs the operation of saving data.
     *
     * @param writer           The {@link FileWriter} used to write a file.
     * @param simulationStates The simulation results to be saved.
     * @throws IOException In case any I/O error occurs while performing the operation.
     */
    abstract void doSave(Writer writer, Queue<S> simulationStates) throws IOException;
}
