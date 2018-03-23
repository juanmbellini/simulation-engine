package ar.edu.itba.ss.g7.engine.io;


import ar.edu.itba.ss.g7.engine.simulation.State;

import java.util.Queue;

/**
 * Defines behaviour for an object that can save a simulation output in a file.
 *
 * @param <S> A concrete subtype of {@link State}.
 */
public interface DataSaver<S extends State> {

    /**
     * Saves the given {@code simulationStates} {@link Queue}.
     *
     * @param simulationStates The {@link Queue} with the simulation results.
     */
    void save(Queue<S> simulationStates);
}
