package net.akhyar.indonesia;

import android.content.Context;

import net.akhyar.indonesia.model.PointAdapter;
import net.akhyar.indonesia.model.Sila;
import net.akhyar.indonesia.model.SilaAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * @author akhyar
 */
@Module(library = true, complete = false, injects = {
        Application.class,
        MainActivity.class,
        DetailActivity.class,
        SilaAdapter.class,
        PointAdapter.class,
        Sila.class
})
public class ApplicationModule {

    public ApplicationModule(Context context) {
        this.context = context;
    }

    private Context context;

    @Provides
    Context provideContext() {
        return context;
    }
}
