package ar.edu.itba.ss.g7.engine.io;

import ar.edu.itba.ss.g7.engine.simulation.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * The {@link Logger} object.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(FileDataSaver.class);

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
        try {
            doSave(createFile(filePath), simulationStates);
        } catch (IOException e) {
            LOGGER.warn("Could not save {} file", filePath);
        }
        LOGGER.info("File {} saved successfully", filePath);
    }

    /**
     * Performs the operation of saving data.
     *
     * @param file             The {@link File} to which data will be writed into.
     * @param simulationStates The simulation results to be saved.
     * @throws IOException In case any I/O error occurs while performing the operation.
     */
    abstract void doSave(File file, Queue<S> simulationStates) throws IOException;

    /**
     * Creates a {@link File} in the given {@code path}.
     *
     * @param path The path where the {@link File} will be created.
     * @return The created {@link File}.
     * @throws IOException If any I/O error occurs while creating the {@link File}.
     */
    private static File createFile(String path) throws IOException {
        final File file = new File(path);
        final File parent = file.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            LOGGER.error("Could not create directories.");
            throw new IOException();
        }
        if (!file.exists() && !file.createNewFile()) {
            LOGGER.error("Could not create file.");
            throw new IOException();
        }
        return file;
    }
}
