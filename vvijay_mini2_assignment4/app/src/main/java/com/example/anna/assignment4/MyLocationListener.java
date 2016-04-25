package com.example.anna.assignment4;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location loc) {
//        pb.setVisibility(View.INVISIBLE);
        String longitude = "Longitude: " + loc.getLongitude();
        Log.v("LONGITUDE", longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.v("LATITUDE", latitude);

        /*------- To get city name from coordinates -------- */
        String cityName = null;
//        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
//        List<Address> addresses;
//        try {
//            addresses = gcd.getFromLocation(loc.getLatitude(),
//                    loc.getLongitude(), 1);
//            if (addresses.size() > 0) {
//                System.out.println(addresses.get(0).getLocality());
//                cityName = addresses.get(0).getLocality();
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
                + cityName;
//        editLocation.setText(s);
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}
