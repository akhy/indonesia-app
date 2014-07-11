package net.akhyar.indonesia;

import dagger.ObjectGraph;

/**
 * @author akhyar
 */
public class Application extends android.app.Application {

    private static ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(
                new ApplicationModule(this),
                new UtilityModule()
        );
        graph.inject(this);
    }

    public static void inject(Object object) {
        graph.inject(object);
    }

}
