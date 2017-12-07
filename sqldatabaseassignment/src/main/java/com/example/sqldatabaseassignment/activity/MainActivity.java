package com.example.sqldatabaseassignment.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sqldatabaseassignment.R;
import com.example.sqldatabaseassignment.adapter.RecyclerviewAdapter;
import com.example.sqldatabaseassignment.databbase.EmployeeDbOperation;
import com.example.sqldatabaseassignment.model.Employee;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.btnDelete)
    Button btDelete;
    @BindView(R.id.btninsert)
    Button btInsert;
    @BindView(R.id.btnUpdate)
    Button btUpdate;
    @BindView(R.id.btnjoin)
    Button btnJoin;
    @BindView(R.id.btnRetrive)
    Button btnRetrive;
    @BindView(R.id.btnRetriveAll)
    Button btnRetriveAll;
    @BindView(R.id.edtId)
    EditText edtid;
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtcompanyname)
    EditText edtcompName;
    @BindView(R.id.edtBollodgroup)
    EditText edtBloodGroup;
    @BindView(R.id.edtPhone)
    EditText edtphone;
    @BindView(R.id.edtaddresss)
    EditText edtaddress;
    private EmployeeDbOperation employeeDbOperation ;
    private String empid  ,deptid,deptname ;
    private Boolean isDialogopen = false ;
    private Employee employee ;
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private RecyclerviewAdapter recyclerviewAdapter ;
    private  String name , companyName , bloodgroup , phone , address ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        employeeDbOperation  = new EmployeeDbOperation(this);
        employee  = new Employee() ;


    }
    @OnClick(R.id.btninsert)
    public void insert() {

        employeeDbOperation.openConnection();
        Log.e("l;uuuuuuu","fffffff"+checkvalidation());
        if(!checkvalidation()){
            getDetails();
            clearDetails();
            employeeDbOperation.insertData(employee);

        }else{
            Toast.makeText(this ,"please fill the all the field",Toast.LENGTH_LONG);
        }

        employeeDbOperation.closeConeection();
        Toast.makeText(this,"insert", Toast.LENGTH_SHORT).show();
    }

    private boolean checkvalidation() {
        boolean result =false;
        if(edtid.getText().toString().equals("")){
            result = true;
        }else if(edtName.getText().toString().equals("")){
            result = true;
        }else if(edtcompName.getText().toString().equals("")){
            result = true;
        }else if(edtBloodGroup.getText().toString().equals("")){
            result = true;
        }else if(edtphone.getText().toString().equals("")){
            result = true;
        }else if(edtaddress.getText().toString().equals("")){
            result = true;
        }
        else{
            result=false ;
        }
        return result;
    }

    private void clearDetails() {
        edtid.setText("");
        edtName.setText("");
        edtcompName.setText("");
        edtBloodGroup.setText("");
        edtphone.setText("");
        edtaddress.setText("");
    }

    private void getDetails() {
        employee.setId(edtid.getText().toString());
        employee.setName(edtName.getText().toString());
        employee.setCompanyName(edtcompName.getText().toString());
        employee.setBloodGroup(edtBloodGroup.getText().toString());
        employee.setPhone(edtphone.getText().toString() );
        employee.setAddress(edtaddress.getText().toString());
    }

    @OnClick(R.id.btnUpdate)
    public void update() {
        clearDetails();
        employeeDbOperation.openConnection();
        if(!isDialogopen){
            createDialog("update");
            isDialogopen = true;
        }else if(isDialogopen){
            getDetails();
            employeeDbOperation.updateData(employee);
            isDialogopen = false;
        }
        employeeDbOperation.closeConeection();
        Toast.makeText(this,"update", Toast.LENGTH_SHORT).show();
    }

    private void setDetails() {
        edtid.setText(""+employee.getId());
        edtName.setText(employee.getName());
        edtcompName.setText(employee.getCompanyName());
        edtBloodGroup.setText(employee.getBloodGroup());
        edtphone.setText(employee.getPhone());
        edtaddress.setText(employee.getAddress());
    }

    @OnClick(R.id.btnDelete)
    public void delete() {
        clearDetails();
        createDialog("delete");
        Toast.makeText(this,"delete", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnjoin)
    public void join() {
        employeeDbOperation.openConnection();

        createDialog1("join");
        employeeDbOperation.closeConeection();
        Toast.makeText(this,"join", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnRetriveAll)
    public void retriveAll() {

        clearDetails();
        employeeDbOperation.openConnection();
        employeeList = employeeDbOperation.retriveAll();
        if(employeeList.size()!=0)
            setAdapter();
        employeeDbOperation.closeConeection();
        Toast.makeText(this,"retrive", Toast.LENGTH_SHORT).show();
    }

    private void setAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewAdapter  = new RecyclerviewAdapter(this,employeeList);
        recyclerView.setAdapter(recyclerviewAdapter);
    }


    @OnClick(R.id.btnRetrive)
    public void retrive() {
        clearDetails();
        createDialog("Retrive");
        Toast.makeText(this,"retrive", Toast.LENGTH_SHORT).show();
    }

    private void createDialog(final String message) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton(message,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                empid  = String.valueOf(Integer.parseInt(String.valueOf(userInput.getText())));
                                if(message.equals("delete")){
                                    employeeDbOperation.openConnection();
                                    employeeDbOperation.deleteData(String.valueOf(empid));
                                    employeeDbOperation.closeConeection();
                                }else if(message.equals("Retrive")){
                                    employeeDbOperation.openConnection();
                                    employee = employeeDbOperation.retriveData(String.valueOf(empid));
                                    if(employee.getName()!=null)
                                        setDetails();
                                    employeeDbOperation.closeConeection();
                                }else if(message.equals("update")){
                                    employeeDbOperation.openConnection();
                                    employee = employeeDbOperation.retriveData(String.valueOf(empid));
                                    if(employee.getName()!=null)
                                        setDetails();
                                    employeeDbOperation.closeConeection();
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }
    private void createDialog1(final String message) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialog2, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);
        final EditText userInput1 = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput1);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton(message,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                deptid  = (userInput.getText().toString());
                                deptname  = userInput1.getText().toString() ;
                                employeeDbOperation.openConnection();
                                employeeDbOperation.joinOperation();
                                employeeDbOperation.closeConeection();
                            }
                        })
                .setNegativeButton("insert",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                deptid  = (userInput.getText().toString());
                                deptname  = userInput1.getText().toString() ;
                                employeeDbOperation.openConnection();
                                employeeDbOperation.insertDepartmentData(deptid,deptname);
                                employeeDbOperation.closeConeection();
//                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }

}
