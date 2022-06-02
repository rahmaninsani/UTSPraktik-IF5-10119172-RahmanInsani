/*
    NIM     : 10119172
    Nama    : Rahman Insani
    Kelas   : IF-5

    Kamis, 02 Juni 2022
*/

package com.rahmaninsani.utspraktik_if5_10119172_rahmaninsani;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_JENISTES = "Jenis Tes";
    public static final String EXTRA_TANGGALTERKONFIRMASI = "Tanggal Konfirmasi";
    public static final String EXTRA_NIK = "NIK";
    public static final String EXTRA_NAMA = "Nama";
    public static final String EXTRA_TANGGALLAHIR = "Tanggal Lahir";
    public static final String EXTRA_JENISKELAMIN = "Jenis Kelamin";
    public static final String EXTRA_HUBUNGAN = "Hubungan";
    public static final String EXTRA_STATE = "Main";

    EditText dateTanggalTerkonfirmasi, dateTanggalLahir;
    DatePickerDialog datePickerDialog;
    String state = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent confirmActivity = new Intent(getApplicationContext(), CheckActivity.class);
        Intent mainActivity = getIntent();
        state = mainActivity.getStringExtra(EXTRA_STATE);

        RadioGroup radioGroupJenisTes = (RadioGroup) findViewById(R.id.jenis_tes);
        RadioGroup radioGroupJenisKelamin = (RadioGroup) findViewById(R.id.jenis_kelamin);
        RadioGroup radioGroupHubungan = (RadioGroup) findViewById(R.id.hubungan_dengan_anda);
        EditText editTextNik = findViewById(R.id.nik);
        EditText editTextNama = findViewById(R.id.nama);

        dateTanggalTerkonfirmasi = (EditText) findViewById(R.id.tanggal_terkonfirmasi);
        dateTanggalLahir = (EditText) findViewById(R.id.tanggal_lahir);

        if (state != "") {

            String jenisTes = mainActivity.getStringExtra(MainActivity.EXTRA_JENISTES);
            String tanggalTerkonfirmasi = mainActivity.getStringExtra(MainActivity.EXTRA_TANGGALTERKONFIRMASI);
            String nik = mainActivity.getStringExtra(MainActivity.EXTRA_NIK);
            String nama = mainActivity.getStringExtra(MainActivity.EXTRA_NAMA);
            String tanggalLahir = mainActivity.getStringExtra(MainActivity.EXTRA_TANGGALLAHIR);
            String jenisKelamin = mainActivity.getStringExtra(MainActivity.EXTRA_JENISKELAMIN);
            String hubungan = mainActivity.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

            dateTanggalTerkonfirmasi.setText(tanggalTerkonfirmasi);
            editTextNik.setText(nik);
            editTextNama.setText(nama);
            dateTanggalLahir.setText(tanggalLahir);

            if (jenisTes == "Rapid Antigen"){
                radioGroupJenisTes.check(R.id.jenis_tes_1);
            } else if (jenisTes == "PCR"){
                radioGroupJenisTes.check(R.id.jenis_tes_2);
            }

            if (jenisKelamin == "Perempuan"){
                radioGroupJenisKelamin.check(R.id.jenis_kelamin_2);
            }

            if (hubungan == "Suami/Istri"){
                radioGroupHubungan.check(R.id.hubungan_dengan_anda_2);
            } else if (hubungan == "Anak"){
                radioGroupHubungan.check(R.id.hubungan_dengan_anda_3);
            } else if(hubungan == "Kerabat Lainnya"){
                radioGroupHubungan.check(R.id.hubungan_dengan_anda_4);
            }
        }

        dateTanggalTerkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int currentYear = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentDay = c.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                String bulan = getBulan(month);
                                dateTanggalTerkonfirmasi.setText(day + "  " + bulan + "  " + year);
                            }
                        }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
            }
        });

        dateTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int currentYear = c.get(Calendar.YEAR);
                int currentMonth = c.get(Calendar.MONTH);
                int currentDay = c.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                String bulan = getBulan(month);
                                dateTanggalLahir.setText(day + "  " + bulan + "  " + year);
                            }
                        }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
            }
        });

        Button buttonSelanjutnya = findViewById(R.id.selanjutnya);
        buttonSelanjutnya.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedJenisTes = radioGroupJenisTes.getCheckedRadioButtonId();
                int selectedJenisKelamin = radioGroupJenisKelamin.getCheckedRadioButtonId();
                int selectedHubungan = radioGroupHubungan.getCheckedRadioButtonId();

                RadioButton jenisTes = (RadioButton) findViewById(selectedJenisTes);
                RadioButton jenisKelamin = (RadioButton) findViewById(selectedJenisKelamin);
                RadioButton hubungan = (RadioButton) findViewById(selectedHubungan);

                String nik = editTextNik.getText().toString();
                String nama = editTextNama.getText().toString();
                String tanggalTerkonfirmasi = dateTanggalLahir.getText().toString();
                String tanggalLahir = dateTanggalTerkonfirmasi.getText().toString();

                confirmActivity.putExtra(EXTRA_JENISTES,jenisTes.getText());
                confirmActivity.putExtra(EXTRA_TANGGALTERKONFIRMASI, tanggalTerkonfirmasi);
                confirmActivity.putExtra(EXTRA_NIK, nik);
                confirmActivity.putExtra(EXTRA_NAMA, nama);
                confirmActivity.putExtra(EXTRA_TANGGALLAHIR, tanggalLahir);
                confirmActivity.putExtra(EXTRA_JENISKELAMIN, jenisKelamin.getText());
                confirmActivity.putExtra(EXTRA_HUBUNGAN, hubungan.getText());

                startActivity(confirmActivity);
            }
        });

    }

    protected String getBulan(int month) {
        int selectedMonth = month + 1;
        String bulan;

        switch (selectedMonth) {
            case 2:
                bulan = "Februari";
                break;
            case 3:
                bulan = "Maret";
                break;
            case 4:
                bulan = "April";
                break;
            case 5:
                bulan = "Mei";
                break;
            case 6:
                bulan = "Juni";
                break;
            case 7:
                bulan = "Juli";
                break;
            case 8:
                bulan = "Agustus";
                break;
            case 9:
                bulan = "September";
                break;
            case 10:
                bulan = "Oktober";
                break;
            case 11:
                bulan = "November";
                break;
            case 12:
                bulan = "Desember";
                break;
            default:
                bulan = "Januari";
        }

        return bulan;

    }
}