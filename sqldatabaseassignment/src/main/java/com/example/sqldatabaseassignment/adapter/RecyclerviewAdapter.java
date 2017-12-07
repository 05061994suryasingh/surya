package com.example.sqldatabaseassignment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sqldatabaseassignment.R;
import com.example.sqldatabaseassignment.activity.MainActivity;
import com.example.sqldatabaseassignment.model.Employee;

import java.util.ArrayList;

/**
 * Created by admin on 12/6/2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private ArrayList<Employee> employeeArrayList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtid,txtname ,txtcompanyname,txtbloodgroup, txtphone,txtaddress;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtid = (TextView) v.findViewById(R.id.txtid);
            txtname = (TextView) v.findViewById(R.id.txtname);
            txtcompanyname = (TextView) v.findViewById(R.id.txtcompanyname);
            txtbloodgroup = (TextView) v.findViewById(R.id.txtbloodgroup);
            txtphone = (TextView) v.findViewById(R.id.txtphone);
            txtaddress = (TextView) v.findViewById(R.id.txtaddress);
        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerviewAdapter(MainActivity mainActivity, ArrayList<Employee> myDataset) {
        employeeArrayList = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =  inflater.inflate(R.layout.listitem, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Employee employee = employeeArrayList.get(position);
        holder.txtid.setText(employee.getId());
        holder.txtname.setText(employee.getName());
        holder.txtcompanyname.setText(employee.getCompanyName());
        holder.txtbloodgroup.setText(employee.getBloodGroup());
        holder.txtphone.setText(employee.getPhone());
        holder.txtaddress.setText(employee.getAddress());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

}