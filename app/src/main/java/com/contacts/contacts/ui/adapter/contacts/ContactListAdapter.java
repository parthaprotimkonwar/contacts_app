package com.contacts.contacts.ui.adapter.contacts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.contacts.contacts.R;
import com.contacts.db.beans.ContactsBean;

import java.util.List;

/**
 * Created by pkonwar on 6/29/2016.
 */
public class ContactListAdapter extends ArrayAdapter<ContactsBean> {

    Context context;
    List<ContactsBean> contacts;

    public ContactListAdapter(Context context, int resource, List<ContactsBean> contacts) {
        super(context, resource, contacts);
        this.context = context;
        this.contacts = contacts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactsBean contact = contacts.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_contacts_lists, null);

        ImageView contactImageView = (ImageView) view.findViewById(R.id.contactImageImageView);
        TextView contactName = (TextView) view.findViewById(R.id.contactNameTextView);
        TextView price = (TextView) view.findViewById(R.id.contactPriceTextView);
        TextView yearsOfExp = (TextView) view.findViewById(R.id.contactYearsExpTextView);


        contactImageView.setImageResource(contact.getContactImageId());
        contactName.setText(contact.getName());
        price.setText(" ₹ " + contact.getPrice() + " ");
        yearsOfExp.setText(contact.getYearsOfExperience() + "yrs Exp.");

        return view;
    }
}
