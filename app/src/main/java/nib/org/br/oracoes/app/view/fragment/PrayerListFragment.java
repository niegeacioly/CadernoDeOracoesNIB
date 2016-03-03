package nib.org.br.oracoes.app.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nib.org.br.oracoes.R;
import nib.org.br.oracoes.app.model.Prayer;
import nib.org.br.oracoes.app.presenter.PrayerFragmentPresenter;
import nib.org.br.oracoes.app.presenter.impl.PrayerFragmentPresenterImpl;
import nib.org.br.oracoes.app.presenter.view.PrayerFragmentView;
import nib.org.br.oracoes.app.view.adapter.PrayerListAdapter;

/**
 * Created by Niege Costa Fonseca on 25/02/2016.
 */
public class PrayerListFragment extends Fragment implements PrayerFragmentView, AdapterView.OnItemClickListener {

    private ListView listView;

    private PrayerFragmentPresenter presenter;

    public PrayerListFragment() {
        this.presenter = new PrayerFragmentPresenterImpl(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prayer_list, container, false);
    }

    @Override
    public void setItems(final List<Prayer> items) {
        PrayerListAdapter adapter = new PrayerListAdapter(this.getContext(), buildItems());
        listView.setAdapter(adapter);
    }

    @Override
    public void initFragment() {
        listView = (ListView) getView().findViewById(R.id.list_prayer);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public List<Prayer> buildItems(){
        List<Prayer> prayers = new ArrayList<>();
        prayers.add(new Prayer("Trabalho", "Emprego novo, evangelismo", null, "02/03/2016", false));
        prayers.add(new Prayer("Ministério", "Nova Kids, História Bíblica, Liderança", null, "02/03/2016", false));
        prayers.add(new Prayer("Diego", "Liderança, concursos, emprego, santidade", null, "02/03/2016", false));
        prayers.add(new Prayer("Casamento", "Relacionamento, finanças.", null, "02/03/2016", false));
        return prayers;
    }

}