package net.akhyar.indonesia;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author akhyar
 */
@Module(library = true, complete = false)
public class UtilityModule {

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
