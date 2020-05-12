package yunus.com;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//class ini berfungsi untuk penghubung
//holder buat sendiri yang beerfungsi untuk membaca adapter pada layout
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    //data yang dikelompokan dalam main adapter
    private List<MainModel> models;

    //context == activity yang digunakan ||activity mana yang menggunakan adapter ini
    private Context context;


    //untuk menjalankan list dan context || constructor
    public MainAdapter(List<MainModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override  //ViewHolder berfungsi untuk memanggil layout
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);
        return new ViewHolder(view);
    }

    @Override //digunakan untuk model berdasarkan komponen view adapter_main
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MainModel model = models.get(position);

        //menaruh judul pada text view
        holder.textView.setText(model.getNama());

        //intent get data
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, YouTubeActivity.class);
                //membawa data action
                intent.putExtra("KEY", model.getKey());
                intent.putExtra("NAMA", model.getNama());
                context.startActivity(intent);
            }
        });
    }

    @Override //menghitung berapa banyak data pada models
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;  // ambil dari adapter_main.xml


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView); //casting adapter_main.xml
        }
    }
}
