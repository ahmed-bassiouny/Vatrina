package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.view.activities.MyProductActivity;
import ahmed.bassiouny.fares.view.activities.ShowProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class SectionOfShopAdapter extends RecyclerView.Adapter<SectionOfShopAdapter.MyViewHolder> {

    private List<Section> sections;
    private Context context;

    public SectionOfShopAdapter(Context context,List<Section> sections) {
        this.context=context;
        this.sections = sections;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivMore;
        private TextView tvSection;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tv_section);
            ivMore = itemView.findViewById(R.id.iv_more);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_section_of_shop_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Section section = sections.get(position);
        holder.tvSection.setText(section.getName());
        holder.tvSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MyProductActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
}