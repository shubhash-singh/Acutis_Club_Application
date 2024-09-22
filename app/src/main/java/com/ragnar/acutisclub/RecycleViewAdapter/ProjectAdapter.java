package com.ragnar.acutisclub.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ragnar.acutisclub.R;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
    List<ProjectRecycleViewPopulate> projectRecycleViewPopulates;

    public ProjectAdapter(List<ProjectRecycleViewPopulate> projectRecycleViewPopulates){
        this.projectRecycleViewPopulates = projectRecycleViewPopulates;

    }

    @NonNull
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    public int getItemCount() {
        return projectRecycleViewPopulates.size();
    }

    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position){

    }




    public static class ProjectViewHolder extends RecyclerView.ViewHolder{

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
