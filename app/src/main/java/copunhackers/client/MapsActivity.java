package copunhackers.client;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import copunhackers.client.clientLogic.Message;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LayoutInflater inflater = this.getLayoutInflater();
        final View v = inflater.inflate(R.layout.messagedialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Enter your message")
                .setView(v)
                .setPositiveButton("send", null)
                .setNegativeButton("cancel", null)
                .create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface d) {

                Button b = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        EditText text = (EditText) v.findViewById(R.id.content);
                        String value = text.getText().toString();

                        Toast.makeText(getBaseContext(), value, Toast.LENGTH_SHORT ).show();
                        /*
                        String responds = functionCall(value);
                        if(responds.length==0){
                            //Dismiss once everything is OK.
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(getBaseContext(), responds, Toast.LENGTH_SHORT ).show();
                        }
                        */
                    }
                });
            }
        });
        /*
        Dialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setMessage("Enter your message")
                .setView(inflater.inflate(R.layout.messagedialog, null))
                .setPositiveButton("send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        EditText text = (EditText) findViewById(R.id.content);
                        String value = text.getText().toString();

                        //take the input values.
                        //call function to get location.
                        //Turn it all into a json object.
                        //


                        Toast.makeText(getBaseContext(), value, Toast.LENGTH_SHORT ).show();

                    }
                })
                .setNegativeButton("cancel", null);

        final AlertDialog dialog = builder.create();
         */



        Button button = (Button) findViewById(R.id.messageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    public void prepareMessage(String username, String content){
        //todo do something with the duration...
        System.out.println(content);
        Toast.makeText(getBaseContext(), content, Toast.LENGTH_SHORT ).show();
        //Message message = new Message();
        //message.setUsername(username);
        //message.setContent(content);
        //creationTime is set already
        //message.setDuration(duration);
        //message.setLocation();
        //System.out.println(message.toString());
    }
}
