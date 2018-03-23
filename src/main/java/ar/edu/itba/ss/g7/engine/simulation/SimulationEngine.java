package ar.edu.itba.ss.g7.engine.simulation;

import ar.edu.itba.ss.g7.engine.models.System;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The simulation engine.
 *
 * @param <S> The concrete type of {@link State} that represents the implementation of this interface.
 */
public class SimulationEngine<S extends State> {

    /**
     * The system to which the simulation will be performed.
     */
    private final System<S> system;
    /**
     * A {@link Queue} holding the {@link State}s generated in each simulation step.
     */
    private final Queue<S> states;
    /**
     * The initial state (i.e saved for engine reset).
     */
    private final S initialState;
    /**
     * A flag indicating whether the engine is initialized.
     */
    private boolean initialized;

    /**
     * Constructor.
     *
     * @param system The system to which the simulation will be performed.
     */
    public SimulationEngine(System<S> system) {
        this.system = system;
        this.states = new LinkedList<>();
        this.initialState = system.outputState();
        this.initialized = false;
    }

    /**
     * Initializes this engine.
     */
    public final void initialize() {
        saveActualState();
        this.initialized = true;
    }

    /**
     * Performs the simulation.
     *
     * @param iterations The amount of iterations to be performed.
     */
    public void simulate(final int iterations) {
        validateState();
        synchronized (states) {
            for (int iteration = 0; iteration < iterations; iteration++) {
                system.update();
                saveActualState();
            }
        }
    }

    /**
     * Outputs the simulation results.
     *
     * @return The simulation results.
     */
    public Queue<S> getResults() {
        synchronized (states) {
            return new LinkedList<>(states);
        }
    }

    /**
     * Clears this engine
     * (i.e removes all {@link State}s from the {@link Queue}).
     *
     * @throws IllegalStateException In case this engine is now simulating.
     */
    public void clearEngine() throws IllegalStateException {
        validateState();
        synchronized (states) {
            this.states.clear();
            saveActualState();
        }

    }

    /**
     * Saves the actual state in the {@code states} {@link Queue}.
     */
    private void saveActualState() {
        this.states.offer(this.initialState);
    }

    /**
     * Validates the state of this engine.
     *
     * @throws IllegalStateException If the state is not valid.
     */
    private void validateState() throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("Engine not initialized. Must call #initialize method first!");
        }
    }


}
