package mx.com.ferthronix.fragments.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import mx.com.ferthronix.fragments.R;
import mx.com.ferthronix.fragments.databinding.FragmentTopJuegosBinding;
import mx.com.ferthronix.fragments.gui.components.JuegosAdapter;
import mx.com.ferthronix.fragments.gui.components.NavigationIconClickListener;
import mx.com.ferthronix.fragments.model.Juego;

public class TopJuegos extends Fragment {

    private FragmentTopJuegosBinding binding;
    private View view;
    private Context context;
    private List<Juego> juegos = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater, container);
        configToolBar();
        configUI();
        configRecycler();

        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("topJuegosFragment",this);
    }

    private void configView(LayoutInflater inflater,ViewGroup container) {
        binding = FragmentTopJuegosBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolBar() {
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        if (activity!=null){
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(new NavigationIconClickListener(
                context, view.findViewById(R.id.gridTopJuegos),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu_open),
                context.getDrawable(R.drawable.menu)
        ));
    }

    private void configUI() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.gridTopJuegos).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        juegos.add(new Juego(1,"halo","Halo",5,"Master Chief es la onda"));
        juegos.add(new Juego(1,"call","Call of Duty",5,"Best"));
        juegos.add(new Juego(1,"mario","Mario Kart",5,"Un clasico"));
        juegos.add(new Juego(1,"maincra","Maincra",5,"Sin comentarios"));
        juegos.add(new Juego(1,"cayde","Destiny 2",5,"El legado de Halo"));
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegos));
    }
}