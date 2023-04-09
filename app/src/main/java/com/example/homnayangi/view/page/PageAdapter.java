package com.example.homnayangi.view.page;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homnayangi.R;
import com.example.homnayangi.model.Meal;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.PageViewHolder> {

    private List<Meal> meals;
    private IClickItem clickItem;

    public PageAdapter(List<Meal> meals, IClickItem clickItem) {
        this.meals = meals;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());        // anonymous class
        View view = inflater.inflate(R.layout.row_meal, parent, false);
        PageViewHolder viewHolder = new PageViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        holder.bind(meals.get(position));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class PageViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivThumbnail;
        private TextView tvTitle;
        private TextView tvDescription;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }

        public void bind(Meal meal) {
            ivThumbnail.setImageResource(meal.getThumbnail());
            tvTitle.setText(meal.getTitle());
            tvDescription.setText(Html.fromHtml(meal.getDescription()));
            itemView.setOnClickListener(v -> {
                clickItem.onClickItem(meal);
            });
        }
    }

}

interface IClickItem {
    void onClickItem(Meal meal);
}
