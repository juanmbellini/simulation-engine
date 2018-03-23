package ar.edu.itba.ss.g7.engine.simulation;

/**
 * Defines behaviour for an object that holds simulation state.
 */
public interface StateHolder<S extends State> {

    /**
     * Returns the current state of the object implementing this interface.
     *
     * @return The actual state.
     */
    S outputState();
}
