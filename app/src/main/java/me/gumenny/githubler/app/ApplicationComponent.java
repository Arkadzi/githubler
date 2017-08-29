package me.gumenny.githubler.app;

import javax.inject.Singleton;

import dagger.Component;
import me.gumenny.githubler.data.di.UserComponent;
import me.gumenny.githubler.data.di.UserModule;

/**
 * Created by arkadii on 3/5/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    UserComponent plus(UserModule userModule);

}
