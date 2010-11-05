package com.noodle.server;

import com.google.inject.Guice;
import com.noodle.core.NoodleCoreModule;

/**
 * Entry point for server initialization
 *
 * @author mdodsworth
 */
public final class NoodleInitializer {

    //======== main() method ========//

    /**
     * Initialize the noodle context and bootstrap the server
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // initialize guice
        Guice.createInjector(new NoodleCoreModule());
    }
}
