package net.aapgsuez.aapgsuez.Blog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import net.aapgsuez.aapgsuez.R;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        switch (position) {
            case 0:
                viewHolder.imageViewBackground.setImageResource(R.drawable.introduction);
                break;
            case 1:
                viewHolder.imageViewBackground.setImageResource(R.drawable.marketing);
                break;
            case 2:
                viewHolder.imageViewBackground.setImageResource(R.drawable.skills);
                break;
            case 3:
                viewHolder.imageViewBackground.setImageResource(R.drawable.design);
                break;
            case 4:
                viewHolder.imageViewBackground.setImageResource(R.drawable.technology);
                break;
            default:
                viewHolder.imageViewBackground.setImageResource(R.drawable.business);
                break;

        }
    }

    @Override
    public int getCount() {
        return 6;
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
