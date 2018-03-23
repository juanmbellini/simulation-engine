package ar.edu.itba.ss.g7.engine.simulation;

/**
 * Defines behaviour for an object that holds simulation state.
 *
 * @param <S> The concrete type of {@link State} that represents the implementation of this interface.
 */
public interface StateHolder<S extends State> {

    /**
     * Returns the current state of the object implementing this interface.
     *
     * @return The actual state.
     */
    S outputState();
}
