package com.gulshan.healthbook;

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
    private String[][] doctor_detail1={
            {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No: 9129875678","600"},
            {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No: 7236475678","900"},
            {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No: 9129878798","500"},
            {"Doctor Name : Anil Shastri","Hospital Address : New Delhi","Exp : 10yrs","Mobile No: 9129812678","650"},
            {"Doctor Name : Sunil Pandey","Hospital Address : Katrai","Exp : 9yrs","Mobile No: 9129235678","450"}
    };
    private String[][] doctor_detail2={
            {"Doctor Name : Nancy","Hospital Address : Pimpri","Exp : 5yrs","Mobile No: 9129875678","600"},
            {"Doctor Name : Pravesh Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No: 7236475678","900"},
            {"Doctor Name : Qureshi Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No: 9129878798","500"},
            {"Doctor Name : Ravi Shastri","Hospital Address : New Delhi","Exp : 10yrs","Mobile No: 9129812678","650"},
            {"Doctor Name : Sunil Sharma","Hospital Address : Katrai","Exp : 9yrs","Mobile No: 9129235678","450"}
    };
    private String[][] doctor_detail3={
            {"Doctor Name : Gaurav Raitani","Hospital Address : Pimpri","Exp : 5yrs","Mobile No: 9129875678","600"},
            {"Doctor Name : Abhinav Sahai","Hospital Address : Nigdi","Exp : 15yrs","Mobile No: 7236475678","900"},
            {"Doctor Name : Sajal Khandelwal","Hospital Address : Pune","Exp : 8yrs","Mobile No: 9129878798","500"},
            {"Doctor Name : Shitiz Rajvanshi","Hospital Address : New Delhi","Exp : 10yrs","Mobile No: 9129812678","650"},
            {"Doctor Name : Chaya","Hospital Address : Katrai","Exp : 9yrs","Mobile No: 9129235678","450"}
    };
    private String[][] doctor_detail4={
            {"Doctor Name : Himanshu","Hospital Address : Pimpri","Exp : 5yrs","Mobile No: 9129875678","600"},
            {"Doctor Name : Saumya tiwari","Hospital Address : Nigdi","Exp : 15yrs","Mobile No: 7236475678","900"},
            {"Doctor Name : Swapnil yadav","Hospital Address : Pune","Exp : 8yrs","Mobile No: 9129878798","500"},
            {"Doctor Name : Narendra Modi","Hospital Address : New Delhi","Exp : 10yrs","Mobile No: 9129812678","650"},
            {"Doctor Name : Amit Shah","Hospital Address : Katrai","Exp : 9yrs","Mobile No: 9129235678","450"}
    };
    private String[][] doctor_detail5={
            {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No: 9129875678","600"},
            {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile No: 7236475678","900"},
            {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No: 9129878798","500"},
            {"Doctor Name : Anil Shastri","Hospital Address : New Delhi","Exp : 10yrs","Mobile No: 9129812678","650"},
            {"Doctor Name : Sunil Pandey","Hospital Address : Katrai","Exp : 9yrs","Mobile No: 9129235678","450"}
    };
    TextView tv;
    String[][] doctor_detail={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewODTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
        {
            doctor_detail=doctor_detail1;
        }
        else if(title.compareTo("Dietician")==0)
        {
            doctor_detail=doctor_detail2;
        }
        else if(title.compareTo("Surgeon")==0)
        {
            doctor_detail=doctor_detail3;
        }
        else if(title.compareTo("Dentist")==0)
        {
            doctor_detail=doctor_detail4;
        }
        else
        {
            doctor_detail=doctor_detail5;
        }
        bt=findViewById(R.id.buttonODBack);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list= new ArrayList();
        for(int i=0;i<doctor_detail.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","Cons Fees:"+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_line,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewOD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}