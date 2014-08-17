package com.gdgwomen.sesion32;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button btn1 =(Button)findViewById(R.id.btnAlertDialog);
        Button btn2= (Button)findViewById(R.id.btnProgressDialog);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void showMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    };
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnAlertDialog:
                //showMessage("btn alert");
                /*AlertDialog: Un diálogo que puede mostrar un título, un máximo de tres botones,
                una lista de items o un layout personalizado.*/
              AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("titulo del alert dialogo");
                dialog.setIcon(R.drawable.ic_launcher);
                dialog.setMessage("Este es  un dialogo de prueba");
                dialog.setCancelable(false); // no permite cerrar el dialogo

                /* Inflar el archivo xml "dialog_layout" a un layout */
                LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogLayout= li.inflate(R.layout.dialog_layout,null,false);
                dialog.setView(dialogLayout);

                // boton negativo del dialogo
                dialog.setNegativeButton("cancelar",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showMessage("aqui no");
                    }
                });

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                          showMessage("positivo");
                          /* Extra
                           * Cuando completemos el editMensaje el texto se enviara
                           * al txtMensaje que se encuentra en nuestro layout activity_my*/
                          EditText edtMsg = (EditText)((AlertDialog)dialog).findViewById(R.id.edtMensaje);// El *edtMensaje* esta en layou personalizado *dialog_layout*
                          TextView txtHola =(TextView)findViewById(R.id.txtMensaje);// txtMensaje en Layou activity_my
                          txtHola.setText(edtMsg.getText().toString());
                            }
                        });
                dialog.setNeutralButton("ninguno", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            showMessage("Neutral");
                            }
                });
                dialog.show();
                break;

            case R.id.btnProgressDialog:
                showMessage("alert  progress");
            break;
        }

    }
}
