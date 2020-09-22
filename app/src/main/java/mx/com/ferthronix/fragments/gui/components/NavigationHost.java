package mx.com.ferthronix.fragments.gui.components;

import androidx.fragment.app.Fragment;

public interface NavigationHost {
    void navigateTo(Fragment fragment, boolean addToBaskStack);
}
