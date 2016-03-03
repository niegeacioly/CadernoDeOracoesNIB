package nib.org.br.oracoes.app.data;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import nib.org.br.oracoes.app.model.Prayer;

/**
 * Created by Niege Costa Fonseca on 12/02/2016.
 */
public class DatabaseManager implements IDatabaseManager{

    private static DatabaseManager instance;

    private DatabaseHelper helper;

    public static void init(final Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(final Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    @Override
    public List<Prayer> findAllPrayers() {
        List<Prayer> list = null;
        try {
            list = getHelper().getPrayerDAO().queryBuilder().orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Prayer getPrayerById(final Long id){
        try {
            Prayer prayer = getHelper().getPrayerDAO().queryForId(id);
            return prayer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createOrUpdatePrayer(Prayer prayer){
        try {
            getHelper().getPrayerDAO().createOrUpdate(prayer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrayer(Prayer prayer){
        try {
            getHelper().getPrayerDAO().delete(prayer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
