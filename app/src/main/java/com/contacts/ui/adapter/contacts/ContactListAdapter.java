package com.contacts.ui.adapter.contacts;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.contacts.db.models.abergin.AUser;
import com.contacts.db.models.specialities.UserSubSpeciality;

import java.util.List;

/**
 * Created by pkonwar on 6/29/2016.
 */
public class ContactListAdapter extends ArrayAdapter<UserSubSpeciality> {

    Context context;
    List<UserSubSpeciality> userSubSpecialityList;

    public ContactListAdapter(Context context, int resource, List<UserSubSpeciality> userSubSpecialityList) {
        super(context, resource, userSubSpecialityList);
        this.context = context;
        this.userSubSpecialityList = userSubSpecialityList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final UserSubSpeciality userSubSpeciality = userSubSpecialityList.get(position);
        AUser user = userSubSpeciality.getUser();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_contacts_lists, null);

        ImageView contactImageView = (ImageView) view.findViewById(R.id.contactImageImageView);
        TextView contactName = (TextView) view.findViewById(R.id.contactNameTextView);
        TextView price = (TextView) view.findViewById(R.id.contactPriceTextView);
        TextView yearsOfExp = (TextView) view.findViewById(R.id.contactYearsExpTextView);
        ImageView phoneIcon = (ImageView) view.findViewById(R.id.contactsPhoneIconImageView);


        //Image is present for a User
        if(user.getImageBlob() != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(user.getImageBlob(), 0, user.getImageBlob().length);
            contactImageView.setImageBitmap(bitmap);
        } else {
            contactImageView.setImageResource(R.drawable.profile);
        }

        contactName.setText(userSubSpeciality.getUser().getName());
        price.setText(" ₹ " + userSubSpeciality.getPrice() + " ");
        yearsOfExp.setText("1 yrs Exp.");

        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSubSpeciality userSubSpeciality = getUserSubSpeciality(view);
                String phoneNumber = userSubSpeciality.getUser().getMobile();

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

    private UserSubSpeciality getUserSubSpeciality(View view) {
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int position = listView.getPositionForView(parentRow);

        return userSubSpecialityList.get(position);
    }
}
