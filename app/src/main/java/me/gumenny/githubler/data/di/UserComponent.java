package me.gumenny.githubler.data.di;

import dagger.Subcomponent;
import me.gumenny.githubler.data.di.scope.UserScope;
import me.gumenny.githubler.presentation.fragment.SearchFragment;


@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    void inject(SearchFragment searchFragment);
}
