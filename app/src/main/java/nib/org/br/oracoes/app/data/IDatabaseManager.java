package nib.org.br.oracoes.app.data;

import java.util.List;

import nib.org.br.oracoes.app.model.Prayer;

/**
 * Created by Niege Costa Fonseca on 25/02/2016.
 */
public interface IDatabaseManager {

    List<Prayer> findAllPrayers();

    Prayer getPrayerById(final Long id);

    void createOrUpdatePrayer(Prayer prayer);

    void deletePrayer(Prayer prayer);

}
