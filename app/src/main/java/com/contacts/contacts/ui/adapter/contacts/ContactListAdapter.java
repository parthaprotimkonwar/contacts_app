package com.contacts.contacts.ui.adapter.contacts;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.contacts.contacts.R;
import com.contacts.contacts.ui.activity.contacts.ContactsActivity;
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
        final ContactsBean contact = contacts.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_contacts_lists, null);

        ImageView contactImageView = (ImageView) view.findViewById(R.id.contactImageImageView);
        TextView contactName = (TextView) view.findViewById(R.id.contactNameTextView);
        TextView price = (TextView) view.findViewById(R.id.contactPriceTextView);
        TextView yearsOfExp = (TextView) view.findViewById(R.id.contactYearsExpTextView);

        ImageView phoneIcon = (ImageView) view.findViewById(R.id.contactsPhoneIconImageView);


        contactImageView.setImageResource(contact.getContactImageId());
        contactName.setText(contact.getName());
        price.setText(" ₹ " + contact.getPrice() + " ");
        yearsOfExp.setText(contact.getYearsOfExperience() + "yrs Exp.");

        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactsBean contactBean = getContactBean(view);
                Long phoneNumber = contactBean.getContactNumber();

                String telephoneSyntax = "tel:09900059925";
                System.out.println("Partha : Calling number : " + phoneNumber);

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(telephoneSyntax));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(callIntent);
            }
        });

        return view;
    }

    private ContactsBean getContactBean(View view) {
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int position = listView.getPositionForView(parentRow);

        return contacts.get(position);
    }
}
