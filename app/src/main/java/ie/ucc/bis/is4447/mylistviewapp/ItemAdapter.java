package ie.ucc.bis.is4447.mylistviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    String[] items, prices, descriptions;
    LayoutInflater mInflater;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView tvName = (TextView) v.findViewById(R.id.tvName);
        TextView tvPrices = (TextView) v.findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) v.findViewById(R.id.tvDescritpiton);

        String itemName = items[i];
        String itemPrice = prices[i];
        String itemDescription = descriptions[i];

        tvName.setText(itemName);
        tvPrices.setText(itemPrice);
        tvDescription.setText(itemDescription);

        return v;
    }
}
