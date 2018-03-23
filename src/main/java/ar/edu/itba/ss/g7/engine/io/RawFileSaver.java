package ar.edu.itba.ss.g7.engine.io;

import ar.edu.itba.ss.g7.engine.simulation.State;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Queue;

/**
 * An extension of {@link FileDataSaver} that saves the simulation results in a raw file
 * (i.e without formatting anything, just serializing as Java does).
 */
public class RawFileSaver<S extends State> extends FileDataSaver<S> {

    /**
     * Constructor.
     *
     * @param filePath The path in which the file will be saved.
     */
    public RawFileSaver(String filePath) {
        super(filePath);
    }

    @Override
    void doSave(File file, Queue<S> simulationStates) throws IOException {
        final ArrayList<S> auxList = new ArrayList<>(simulationStates); // Copy into a Serializable List
        try (final FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(auxList);
        }
    }
}
