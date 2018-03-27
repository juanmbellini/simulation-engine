package ar.edu.itba.ss.g7.engine.models;

import ar.edu.itba.ss.g7.engine.simulation.State;
import ar.edu.itba.ss.g7.engine.simulation.StateHolder;

/**
 * Defines behaviour for an object that represents a system to be simulated.
 *
 * @param <S> The concrete type of {@link State} that represents the implementation of this interface.
 */
public interface System<S extends State> extends StateHolder<S> {

    /**
     * Updates the system.
     */
    void update();

    /**
     * Restarts this system (i.e puts the system in its initial conditions).
     */
    void restart();
}
