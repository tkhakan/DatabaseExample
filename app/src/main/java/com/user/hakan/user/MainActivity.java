package com.user.hakan.user;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText ad,soyad,kullanıcıadi,sifre,sifretekrar;
    Button kaydet;




   private Database nesne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nesne=new Database(this);


        ad= (EditText) findViewById(R.id.edittext1);
        soyad= (EditText) findViewById(R.id.edittext2);
        kullanıcıadi= (EditText) findViewById(R.id.edittext3);
        sifre= (EditText) findViewById(R.id.edittext4);
        sifretekrar= (EditText) findViewById(R.id.edittext5);
        kaydet= (Button) findViewById(R.id.button);






    /*    kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sifre.getText().toString().equals(sifretekrar.getText().toString()))
                {
                    nesne.KullaniciEkle(ad.getText().toString(),soyad.getText().toString(),
                            kullanıcıadi.getText().toString(),sifre.getText().toString(),
                            sifretekrar.getText().toString());
                    Toast.makeText(getBaseContext(),"KULLANICI BASARI İLE EKLENDi",Toast.LENGTH_LONG).show();

                }

                else
                {
                   Toast.makeText(getBaseContext(),"GİRDİĞİNİZ SİFRELERİ KONTROL EDINIZ",Toast.LENGTH_LONG).show();
                }
nesne.close();
            }


        });

*/

kaydet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        nesne.KullaniciEkle(ad.getText().toString(),soyad.getText().toString(),
                kullanıcıadi.getText().toString(),sifre.getText().toString(),
                sifretekrar.getText().toString());


    }
});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
