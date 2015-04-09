package com.example.fukuo.supportadapter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView)findViewById(R.id.listView);
        SupportAdapter adapter = new SupportAdapter(this, R.layout.list_item);
        adapter.setViewHolder(StringViewHolder.class);

        lv.setAdapter(adapter);
        adapter.add("a1");
    }

    class Item{
        String name;
        int id;
    }

    class StringViewHolder extends ViewHolder<Item>{

        TextView textView;

        private StringViewHolder(View v) {
            super(v);
        }

        @Override
        protected void findViews(View v) {
            textView = (TextView) v.findViewById(R.id.textView);
        }

        @Override
        public void bindItem(Item item) {
            textView.setText(item.name);
        }
    }
}
