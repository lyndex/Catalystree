package com.example.catalystreeapp.Level1Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.catalystreeapp.R;
import com.example.catalystreeapp.Users.UserDbAdapter;
import com.example.catalystreeapp.Users.WelcomeActivity;


public class FProfile extends Fragment {

    public FProfile() {
    }
    UserDbAdapter userDbAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

//                TextView txtname = (TextView) getActivity().findViewById(R.id.txt_success_name);
//                TextView txtemail = (TextView) getActivity().findViewById(R.id.txt_success_email);
//                dpImage = (ImageView) getActivity().findViewById(R.id.imgclick);

                Intent intent = getActivity().getIntent();

//                String loginEmail = intent.getStringExtra("EMAIL");
////        todo null pointer exception for username
////                txtname.setText(username);
//                txtemail.setText(loginEmail);


//        String currentUsername = getActivity().getIntent().getStringExtra("USERNAME_KEY");

//        String currentUsername = "hi";
        //showing retrieved data from first activity on this activity using TextView
//
/*
        Button _btnlogout = (Button) getActivity().findViewById(R.id.btn_logout);
        _btnlogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("Info");
                        builder.setMessage("Do you want to logout?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(getActivity(), WelcomeActivity.class);
                                startActivity(intent);

                                getActivity().finish();

                            }
                        });

                        builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
*/

                //=========Section For Changing Display Image When Click=========

//                dpImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                        photoPickerIntent.setType("image/*");
//                        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
//                    }
//                });
            return rootView;
            }

    public void setText(String currentUsername) {
        currentUsername = getActivity().getIntent().getStringExtra("USERNAME_KEY");
        TextView t = (TextView) getView().findViewById(R.id.txt_success_name);  //UPDATE
        t.setText(currentUsername);
    }

//            //this Method call when user pick an image from ImagePicker. e.g gallery
//            @Override
//            protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
//                super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
//
//                switch(requestCode) {
//                    case SELECT_PHOTO:
//                        if(resultCode == RESULT_OK){
//                            Uri selectedImage = imageReturnedIntent.getData();
//
//                            Bitmap yourSelectedImage = null;
//                            try {
//                                //decodeUri() Method Defined Below
//                                yourSelectedImage = decodeUri(selectedImage);
//                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
//                            }
//                            dpImage.setImageBitmap(yourSelectedImage);
//                        }
//                }
//            }
//
//            //decodeUri() Method for decoding image for Out of Memory Exception
//            private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {
//
//                // Decode image size
//                BitmapFactory.Options o = new BitmapFactory.Options();
//                o.inJustDecodeBounds = true;
//                BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);
//
//                // The new size we want to scale to
//                final int REQUIRED_SIZE = 140;
//
//                // Find the correct scale value. It should be the power of 2.
//                int width_tmp = o.outWidth, height_tmp = o.outHeight;
//                int scale = 1;
//                while (true) {
//                    if (width_tmp / 2 < REQUIRED_SIZE
//                            || height_tmp / 2 < REQUIRED_SIZE) {
//                        break;
//                    }
//                    width_tmp /= 2;
//                    height_tmp /= 2;
//                    scale *= 2;
//                }
//
//                // Decode with inSampleSize
//                BitmapFactory.Options o2 = new BitmapFactory.Options();
//                o2.inSampleSize = scale;
//                return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
//
//            }
        }
