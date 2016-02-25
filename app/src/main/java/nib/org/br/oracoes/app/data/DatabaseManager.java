package nib.org.br.oracoes.app.data;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import nib.org.br.oracoes.app.model.Prayer;

/**
 * Created by Niege Costa Fonseca on 12/02/2016.
 */
public class DatabaseManager {

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

    /**
     *
     * @return
     */
    public List<Prayer> findAllPrayers() {
        List<Prayer> list = null;
        try {
            list = getHelper().getPrayerDAO().queryBuilder().orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
