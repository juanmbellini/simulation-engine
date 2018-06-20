package ar.edu.itba.ss.g7.engine.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Class implementing several helper methods to be used for file operation.
 */
public class FileHelper {

    /**
     * The {@link Logger} object.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(FileHelper.class);

    /**
     * Creates a {@link File} in the given {@code path}.
     *
     * @param path The path where the {@link File} will be created.
     * @return The created {@link File}.
     * @throws IOException If any I/O error occurs while creating the {@link File}.
     */
    public static File createFile(String path) throws IOException {
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

    /**
     * Performs a save operation according the given {@link SaveOperation},
     * wrapping the resolution of an {@link IOException}.
     *
     * @param filePath      The path to the file.
     * @param saveOperation The {@link SaveOperation}.
     */
    public static void save(final String filePath, final SaveOperation saveOperation) {
        try {
            saveOperation.save(filePath);
        } catch (IOException e) {
            LOGGER.warn("Could not save {} file", filePath);
        }
        LOGGER.info("File {} saved successfully", filePath);
    }

    /**
     * A {@link FunctionalInterface} used to abstract the operation of saving a file,
     * containing a method that can throw an {@link IOException}.
     */
    @FunctionalInterface
    public interface SaveOperation {

        /**
         * Performs the save operation.
         *
         * @param filePath The path to the file to be saved.
         * @throws IOException In case any IO error occurs.
         */
        void save(final String filePath) throws IOException;
    }
}
