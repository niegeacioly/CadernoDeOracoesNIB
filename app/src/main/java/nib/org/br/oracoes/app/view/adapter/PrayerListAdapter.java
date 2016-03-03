package nib.org.br.oracoes.app.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import nib.org.br.oracoes.R;
import nib.org.br.oracoes.app.model.Prayer;

/**
 * Created by Niege Costa Fonseca on 24/02/2016.
 */
public class PrayerListAdapter extends BaseAdapter {

    private List<Prayer> prayers;
    private Context context;
    private LayoutInflater layoutInflater;

    public  PrayerListAdapter(final Context context, final List<Prayer> data){
        this.prayers = data;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return prayers.size();
    }

    @Override
    public Object getItem(int position) {
        return prayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Prayer prayer = prayers.get(position);

        convertView = layoutInflater.inflate(R.layout.list_prayer_item, null);

        final TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_prayer_title);
        final TextView txtDescription = (TextView) convertView.findViewById(R.id.txt_prayer_description);
        final CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.cbox_read);

        txtTitle.setText(prayer.getTitle());
        txtDescription.setText(prayer.getDescription());
        checkbox.setChecked(prayer.getIsPrayed());

        return convertView;
    }
}
