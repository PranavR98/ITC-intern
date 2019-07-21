package com.example.itcinfotech;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Data> list;
    public AdapterClass(ArrayList<Data> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(list.get(i).getName());
        myViewHolder.id.setText(list.get(i).getTempID());
        myViewHolder.dept.setText(list.get(i).getDepartment());
        myViewHolder.project.setText(list.get(i).getProject());
        myViewHolder.start.setText(list.get(i).getStartDate());
        myViewHolder.end.setText(list.get(i).getEndDate());
        myViewHolder.guide.setText(list.get(i).getGuide());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, id, dept, project, start, end, guide;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itc_name);
            id = itemView.findViewById(R.id.itc_ID);
            dept = itemView.findViewById(R.id.itc_dept);
            project = itemView.findViewById(R.id.itc_project);
            start = itemView.findViewById(R.id.itc_start);
            end = itemView.findViewById(R.id.itc_finish);
            guide = itemView.findViewById(R.id.itc_guide);
        }
    }
}
