package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Sarah Wijayanti", "Hospital Address : Cikarang Pilar", "Exp : 5years", "Mobile No:081281040653", "300000"},
                    {"Doctor Name : Chandra Mustika", "Hospital Address : Jababeka", "Exp : 10years", "Mobile No:081281040652", "900000"},
                    {"Doctor Name : Andriawan Widian", "Hospital Address : Pasir Gombong", "Exp : 8years", "Mobile No:08218989898", "800000"},
                    {"Doctor Name : Ekka Juliyanto", "Hospital Address : Lippo Cikarang", "Exp : 6years", "Mobile No:0813456789", "700000"},
                    {"Doctor Name : Imam Indriani", "Hospital Address : Tambun", "Exp : 7years", "Mobile No:0813667788", "800000"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Andrilla Oktavia", "Hospital Address : Grama Puri Persada", "Exp : 5years", "Mobile No:08213456789", "600000"},
                    {"Doctor Name : Yuda Mustikawati", "Hospital Address : Jati Asih", "Exp : 15years", "Mobile No:0831456789", "900000"},
                    {"Doctor Name : Tubagus Ridwan", "Hospital Address : Jati Sampurna", "Exp : 8years", "Mobile No:0821989898", "300000"},
                    {"Doctor Name : Anindya Damayanti", "Hospital Address : Mustika Jaya", "Exp : 6years", "Mobile No:08131524600", "500000"},
                    {"Doctor Name : Ferhat Suryo", "Hospital Address : Rawalumbu", "Exp : 7years", "Mobile No:0898456728", "800000"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Reza Usmani", "Hospital Address : Pondok Melati", "Exp : 4years", "Mobile No:08984359898", "200000"},
                    {"Doctor Name : Fiki Hendi", "Hospital Address : Kranji", "Exp : 5years", "Mobile No:0821345678", "300000"},
                    {"Doctor Name : Yutima Zahra", "Hospital Address : Jakasetia", "Exp : 7years", "Mobile No:08387659898", "300000"},
                    {"Doctor Name : Hizkia Persadani", "Hospital Address : Pekayon Jaya", "Exp : 6years", "Mobile No:085870000", "500000"},
                    {"Doctor Name : Andika Syahidah", "Hospital Address : Margahayu", "Exp : 7years", "Mobile No:0898765398", "600000"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Pradiftia Afini", "Hospital Address : Cikarang Barat", "Exp : 5years", "Mobile No:0838979865", "600000"},
                    {"Doctor Name : Amita Hartanti", "Hospital Address : Pondok Gede", "Exp : 15years", "Mobile No:081234989898", "900000"},
                    {"Doctor Name : Singgih Rizky", "Hospital Address : Bekasi Timur", "Exp : 8years", "Mobile No:08123459898", "300000"},
                    {"Doctor Name : Ressy Claudia", "Hospital Address : Bekasi Utara", "Exp : 6years", "Mobile No:0812800000", "500000"},
                    {"Doctor Name : Leni Mulyanti", "Hospital Address : Bekasi Barat", "Exp : 7years", "Mobile No:0813569898", "800000"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Putri Sarifah", "Hospital Address : Cibarusah", "Exp : 5years", "Mobile No:0838579898", "1600000"},
                    {"Doctor Name : Mawar Pujilestari", "Hospital Address : Cibitung", "Exp : 15years", "Mobile No:0813689898", "900000"},
                    {"Doctor Name : Fuji Ameilia", "Hospital Address : Cikarang Timur", "Exp : 8years", "Mobile No:08987689898", "800000"},
                    {"Doctor Name : Aufa Rahmawati", "Hospital Address : Karangbahagia", "Exp : 6years", "Mobile No:0813570000", "500000"},
                    {"Doctor Name : Diah Larasati", "Hospital Address : Muara Gombong", "Exp : 7years", "Mobile No:08134989898", "800000"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}