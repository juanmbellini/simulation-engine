package ar.edu.itba.ss.g7.engine.models;

import ar.edu.itba.ss.g7.engine.simulation.State;
import ar.edu.itba.ss.g7.engine.simulation.StateHolder;

/**
 * Defines behaviour for an object that represents a system to be simulated.
 */
public interface System<S extends State> extends StateHolder<S> {

    /**
     * Updates the system.
     */
    void update();
}
