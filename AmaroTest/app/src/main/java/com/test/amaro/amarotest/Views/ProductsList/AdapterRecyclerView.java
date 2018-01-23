package com.test.amaro.amarotest.Views.ProductsList;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by jaiber on 07/09/2017.
 */
public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ItemViewHolder>{

    private List<Product> products;
    private Context ctx;
    private final String TAG = "AdapterRecyclerView";

    public interface OnItemClickListener {
        public void onItemClick(RecyclerView.ViewHolder viewHolder, int pos);
    }

    private OnItemClickListener onItemClickListener;


    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterRecyclerView(List<Product> products) {
        this.products = products;
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterRecyclerView() {
        this.products = new ArrayList<>();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterRecyclerView(Context ctx) {
        this.products = new ArrayList<>();
        this.ctx = ctx;

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterRecyclerView(Context ctx, OnItemClickListener listener) {
        this.products = new ArrayList<>();
        this.ctx = ctx;
        this.onItemClickListener = listener;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list_item, parent, false);
        ItemViewHolder pvh = new ItemViewHolder(view);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int pos) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.productName.setText(products.get(pos).getName());
        holder.productPrice.setText(products.get(pos).getActualPrice());

        Glide.with(ctx)
                .load(products.get(pos).getImage())
                .into(holder.imageMiniature);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //int size=0;
        if (products != null)
            return products.size();
        else
            return 0;
    }


    public void updateList (List<Product> items) {
        if (items != null && items.size() > 0) {
            if(products != null)
                products.clear();
            products.addAll(items);
            notifyDataSetChanged();
        }
    }

    // RecyclerView implementation
    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public TextView productPrice;
        public TextView productName;
        public TextView studentGender;
        public ImageView imageMiniature;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            productName = (TextView) itemView.findViewById(R.id.tvName);
            productPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            imageMiniature = (ImageView) itemView.findViewById(R.id.ivImage);
        }

        private void removeItem(int position) {
            products.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, products.size());
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            //removeItem(pos);
            //Log.d(TAG, "onItemClick: " + pos + "  Name: "+ productName.getText() );
            //Toast.makeText(itemView.getContext(), "Hello: "+ productName.getText(), Toast.LENGTH_SHORT).show();
            onItemClickListener.onItemClick(this, pos);

        }
    }

}
