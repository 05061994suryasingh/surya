package com.example.sqldatabaseassignment.databbase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqldatabaseassignment.model.Employee;
import com.example.sqldatabaseassignment.utils.Utils;

import java.util.ArrayList;

/**
 * Created by admin on 12/6/2017.
 */

public class EmployeeDbOperation {

    Employee employee = new Employee() ;
    Context  context ;
    public static  final String TABLENAME = "employee";
    public static  final String TABLENAME1 = "department";
    private static final String KEY_ID = "id";
    private static final String KEY_ID1 = "deptid";
    private static final String KEY_DEPTName = "deptname";
    private static final String KEY_NAME = "name";
    private static final String KEY_COMPANY_NAME = "companyname";
    private static final String KEY_BLOOD_GROUP = "bloodgroup";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_ADDRESS = "address";
    private String id ;
    private  String name , companyName , bloodgroup , phone , address ;
    private String TAG = this.getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase = null ;

    public  static  String CREATE_TABLE1 = "CREATE TABLE " + TABLENAME1 + "("
            + KEY_DEPTName + " TEXT,"  + KEY_ID1 + " INT,"
            + "FOREIGN KEY(" + KEY_ID1 + ") REFERENCES "
            + TABLENAME + "(id)"+ ")";

    public  static  String CREATE_TABLE = "CREATE TABLE " + TABLENAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
            + KEY_COMPANY_NAME + " TEXT," + KEY_BLOOD_GROUP + " TEXT," + KEY_PHONE + " TEXT," + KEY_ADDRESS + " TEXT" + ")";

    public  EmployeeDbOperation(Context context){
        this.context  = context ;
    }

    public  void openConnection(){
        Utils.printLog(TAG ,"inside openConnection");
        sqLiteDatabase = new SqlHelper(context, DBConstant.DBNAME , null, DBConstant.VERSION).getReadableDatabase();
        //sqLiteDatabase.create(null);
        Utils.printLog(TAG ,"outside openConnection");
    }

    public void closeConeection(){
        if(sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }
    public void insertData(Employee employee) {

        if (sqLiteDatabase == null) {
            return;
        }
        this.employee = employee;
        id = employee.getId();
        name = employee.getName();
        companyName = employee.getCompanyName();
        bloodgroup = employee.getBloodGroup();
        phone = employee.getPhone();
        address = employee.getAddress();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE id='" + id + "'", null);
        if (cursor != null && cursor.getCount() != 0) {
            Utils.showToast(context, "duplicate value insert plz insert unique id value");
        } else {
            String QUERY = "insert into " + TABLENAME + "(id,name,companyname,bloodgroup,phone,address) values ('" + id + "','" + name + "','" + companyName + "' ,'" + bloodgroup + "','" + phone + "','" + address + "')";
            Utils.printLog("QUERY", " QUERY : " + QUERY);
            sqLiteDatabase.execSQL(QUERY);
        }
    }

    public Employee retriveData(String id) {
        Employee employee1= new Employee();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE id='" + id + "'", null);
        if (cursor.moveToFirst()) {
            // Displaying record if found
            employee1.setId(cursor.getString(0));
            employee1.setName(cursor.getString(1));
            employee1.setCompanyName(cursor.getString(2));
            employee1.setBloodGroup(cursor.getString(3));
            employee1.setPhone(cursor.getString(4));
            employee1.setAddress(cursor.getString(5));
        } else {
            Utils.showToast(context, "no data in table of following data present ");
        }
        return employee1;
    }

    public void updateData(Employee employee) {
        // Searching roll number
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE id='" + employee.getId() + "'", null);
        if (c.moveToFirst()) {
            // Modifying record if found
            sqLiteDatabase.execSQL("UPDATE employee SET name='" + employee.getName() + "',companyname='" + employee.getCompanyName()+  "',bloodgroup='" + employee.getBloodGroup()+ "',phone='" + employee.getPhone() +"',address='" + employee.getAddress() +
                    "' WHERE id='" + employee.getId() + "'");
            Utils.showToast(context, "Record Modified");
        } else {
            Utils.showToast(context, "id not match");
        }

    }

    public void deleteData(String id) {
        // Searching roll number
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE id='" + id + "'", null);
        if (c.moveToFirst()) {
            // Deleting record if found
            sqLiteDatabase.execSQL("DELETE FROM employee WHERE id='" + id + "'");
            Utils.showToast(context, "Record Deleted");
        } else {
            Utils.showToast(context, "data not found for that id");
        }
    }

    public ArrayList retriveAll(){
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee employee ;
        // Retrieving all records
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM employee", null);
        // Checking if no records found
        if(c.getCount()==0)
        {
            Utils.showToast(context, "No records found");
            return employeeList;
        }

        while(c.moveToNext())
        {
            employee = new Employee() ;
            employee.setId(c.getString(0));
            employee.setName(c.getString(1));
            employee.setCompanyName(c.getString(2));
            employee.setBloodGroup(c.getString(3));
            employee.setPhone(c.getString(4));
            employee.setAddress(c.getString(5));
            employeeList.add(employee);
        }
        return employeeList;
    }

    public void joinOperation(){
        String query = "SELECT " + KEY_ID + ","
                + KEY_NAME + "," + KEY_ADDRESS
                + "," + KEY_PHONE+","  + KEY_BLOOD_GROUP
                + "," + KEY_DEPTName + " FROM "
                + TABLENAME + ","
                +TABLENAME1 + " WHERE employee."
                + KEY_ID + " = department."
                + KEY_ID1;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            Utils.printLog("empid",""+cursor.getString(0));
            Utils.printLog("empname",""+cursor.getString(1));
            Utils.printLog("empaddress",""+cursor.getString(2));
            Utils.printLog("empphone",""+cursor.getString(3));
            Utils.printLog("bloodgroup",""+cursor.getString(4));
            Utils.printLog("deptname",""+cursor.getString(5));
        }
    }

    public void insertDepartmentData(String deptid, String deptname) {
        if (sqLiteDatabase == null) {
            return;
        }
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM department WHERE deptid='" + deptid + "'", null);
        if (cursor != null && cursor.getCount() != 0) {
            Utils.showToast(context, "duplicate value insert plz insert unique id value");
        } else {
            String QUERY = "insert into " + TABLENAME1 + "(deptid,deptname) values ('" + deptid +"','" + deptname + "')";
            Utils.printLog("QUERY", " QUERY : " + QUERY);
            sqLiteDatabase.execSQL(QUERY);
            Utils.showToast(context, "Record updated");
        }
    }
}
