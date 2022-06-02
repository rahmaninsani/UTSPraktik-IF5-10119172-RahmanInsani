/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Kamis, 02 Juni 2022
*/

package com.rahmaninsani.utspraktik_if5_10119172_rahmaninsani;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckActivity extends AppCompatActivity {
    public static final String EXTRA_JENISTES = "Jenis Tes";
    public static final String EXTRA_TANGGALTERKONFIRMASI = "Tanggal Konfirmasi";
    public static final String EXTRA_NIK = "NIK";
    public static final String EXTRA_NAMA = "Nama";
    public static final String EXTRA_TANGGALLAHIR = "Tanggal Lahir";
    public static final String EXTRA_JENISKELAMIN = "Jenis Kelamin";
    public static final String EXTRA_HUBUNGAN = "Hubungan";
    public static final String EXTRA_STATE = "Check";

    private Dialog doneDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Intent confirmActivity = getIntent();
        Intent mainActivity = new Intent(this, MainActivity.class);


        String jenisTes = confirmActivity.getStringExtra(MainActivity.EXTRA_JENISTES);
        String tanggalTerkonfirmasi = confirmActivity.getStringExtra(MainActivity.EXTRA_TANGGALTERKONFIRMASI);
        String nik = confirmActivity.getStringExtra(MainActivity.EXTRA_NIK);
        String nama = confirmActivity.getStringExtra(MainActivity.EXTRA_NAMA);
        String tanggalLahir = confirmActivity.getStringExtra(MainActivity.EXTRA_TANGGALLAHIR);
        String jenisKelamin = confirmActivity.getStringExtra(MainActivity.EXTRA_JENISKELAMIN);
        String hubungan = confirmActivity.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

        TextView textViewJenisTes = findViewById(R.id.check_jenis_tes);
        TextView textViewTanggalTerkonfirmasi = findViewById(R.id.check_tanggal_terkonfirmasi);
        TextView textViewNik = findViewById(R.id.check_nik);
        TextView textViewNama = findViewById(R.id.check_nama);
        TextView textViewTanggalLahir = findViewById(R.id.check_tanggal_lahir);
        TextView textViewJenisKelamin = findViewById(R.id.check_jenis_kelamin);
        TextView textViewHubungan = findViewById(R.id.check_hubungan_dengan_anda);

        textViewJenisTes.setText(jenisTes);
        textViewTanggalTerkonfirmasi.setText(tanggalTerkonfirmasi);
        textViewNik.setText(nik);
        textViewNama.setText(nama);
        textViewTanggalLahir.setText(tanggalLahir);
        textViewJenisKelamin.setText(jenisKelamin);
        textViewHubungan.setText(hubungan);
        showDoneDialog();

        ImageView imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainActivity.putExtra(EXTRA_JENISTES,jenisTes);
                mainActivity.putExtra(EXTRA_TANGGALTERKONFIRMASI, tanggalTerkonfirmasi);
                mainActivity.putExtra(EXTRA_NIK, nik);
                mainActivity.putExtra(EXTRA_NAMA, nama);
                mainActivity.putExtra(EXTRA_TANGGALLAHIR, tanggalLahir);
                mainActivity.putExtra(EXTRA_JENISKELAMIN, jenisKelamin);
                mainActivity.putExtra(EXTRA_HUBUNGAN, hubungan);
                mainActivity.putExtra(EXTRA_STATE, "Back");

                startActivity(mainActivity);
            }
        });

        Button buttonCheck = findViewById(R.id.check);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doneDialog.show();
            }
        });

        Button buttonUbah = findViewById(R.id.ubah);
        buttonUbah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainActivity.putExtra(EXTRA_JENISTES,jenisTes);
                mainActivity.putExtra(EXTRA_TANGGALTERKONFIRMASI, tanggalTerkonfirmasi);
                mainActivity.putExtra(EXTRA_NIK, nik);
                mainActivity.putExtra(EXTRA_NAMA, nama);
                mainActivity.putExtra(EXTRA_TANGGALLAHIR, tanggalLahir);
                mainActivity.putExtra(EXTRA_JENISKELAMIN, jenisKelamin);
                mainActivity.putExtra(EXTRA_HUBUNGAN, hubungan);
                mainActivity.putExtra(EXTRA_STATE, "Ubah");

                startActivity(mainActivity);
            }
        });

    }

    private void showDoneDialog(){

        doneDialog = new Dialog(CheckActivity.this);

        doneDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        doneDialog.setContentView(R.layout.activity_done);
        doneDialog.setCancelable(true);

        Button okButton = doneDialog.findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneDialog.dismiss();
            }
        });
    }

}