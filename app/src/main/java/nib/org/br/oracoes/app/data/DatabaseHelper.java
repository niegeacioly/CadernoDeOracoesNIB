package nib.org.br.oracoes.app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import nib.org.br.oracoes.app.model.Prayer;


/**
 * Created by Niege Costa Fonseca on 22/01/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cadernodeoracoesnib";

    private Dao<Prayer, Long> prayerDAO;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Create database tables
     */
    @Override
    public void onCreate(final SQLiteDatabase database, final ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Prayer.class);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Recreates the database when onUpgrade is called by the framework
     */
    @Override
    public void onUpgrade(final SQLiteDatabase database, final ConnectionSource connectionSource, final int oldVersion, final int newVersion) {
        onCreate(database, connectionSource);
    }

    /**
     * Returns the current prayer dao
     * @return prayer dao object
     * @throws SQLException
     */
    public Dao<Prayer, Long> getPrayerDAO() throws SQLException {
        if (prayerDAO == null) {
            prayerDAO = getDao(Prayer.class);
        }
        return prayerDAO;
    }
}
