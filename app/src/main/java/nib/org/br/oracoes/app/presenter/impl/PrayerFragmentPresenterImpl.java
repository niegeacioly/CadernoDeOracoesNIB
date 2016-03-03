/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package nib.org.br.oracoes.app.presenter.impl;

import nib.org.br.oracoes.app.presenter.PrayerFragmentPresenter;
import nib.org.br.oracoes.app.presenter.view.PrayerFragmentView;


public class PrayerFragmentPresenterImpl implements PrayerFragmentPresenter {

    private PrayerFragmentView view;


    public PrayerFragmentPresenterImpl(PrayerFragmentView view) {
        this.view = view;

    }

    @Override public void onResume() {
        view.initFragment();
        view.setItems(null);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onDestroy() {
        view = null;
    }

//    private List<Prayer> createListPrayer() {
//        List<Prayer> prayers = new ArrayList<>();
//        prayers.add(new Prayer("Topic 1", "Trabalho", "Novo emprego, salario legal, pessoas para evangelizar", null, "02-24-2016", false ));
//        prayers.add(new Prayer("Topic 1", "Ministério", "Liderança, crianças, evangelismo", null, "02-24-2016", false ));
//        prayers.add(new Prayer("Topic 1", "Casamento", "Marido e relacionamento", null, "02-24-2016", false ));
//        prayers.add(new Prayer("Topic 1", "Diego", "Liderança/pastor da casa, emprego, Nova Kids, Concursos, mais discipulos", null, "02-24-2016", false ));
//        return prayers;
//    }
}
