package nib.org.br.oracoes.app.presenter.view;

import java.util.List;

import nib.org.br.oracoes.app.model.Prayer;

/**
 * Created by Niege Costa Fonseca on 02/03/2016.
 */
public interface PrayerFragmentView {

    void setItems(List<Prayer> items);

    void initFragment();
}
