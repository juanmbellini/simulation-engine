package ar.edu.itba.ss.g7.engine.io;

import ar.edu.itba.ss.g7.engine.simulation.State;

import java.io.File;
import java.io.IOException;
import java.util.Queue;

/**
 * Abstract implementation of {@link DataSaver}, using files to output data.
 *
 * @param <S> A concrete subtype of {@link State}.
 */
public abstract class FileDataSaver<S extends State> implements DataSaver<S> {

    /**
     * The path to the file where to save.
     */
    private final String filePath;

    /**
     * Constructor.
     *
     * @param filePath The path in which the file will be saved.
     */
    protected FileDataSaver(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Queue<S> simulationStates) {
        FileHelper.save(filePath, path -> doSave(FileHelper.createFile(path), simulationStates));
    }

    /**
     * Performs the operation of saving data.
     *
     * @param file             The {@link File} to which data will be writed into.
     * @param simulationStates The simulation results to be saved.
     * @throws IOException In case any I/O error occurs while performing the operation.
     */
    abstract void doSave(File file, Queue<S> simulationStates) throws IOException;
}
