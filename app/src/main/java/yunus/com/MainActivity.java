package yunus.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //layoutmanager untuk menampilkan adapternya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //membuat data  dataarray / data yang akan ditampilkan pada recyclerview
        String strNama [] = {"Captain Marvel", "Captain America: Civil War", "Thor: Ragnarok", "Black Panther", "Ant-Man and The Wasp", "Spider-Man: Far From Home"};
        String strKeys [] = {"mbyd2kvRPnw", "dKrVegVI0Us","ue80QwXMRHg", "xjDjIWPwcPU", "UUkn-enk2RU", "VUFmhKpZKlE"};

        List<MainModel> modelList = new ArrayList<>();

        for (int i = 0; i < strNama.length; i++){
            MainModel model = new MainModel();
            model.setNama(strNama[i]);
            model.setKey(strKeys[i]);
            modelList.add(model);  // semuanya disimpan dalam model list
        }


        //set Adapter|| ambil pada line 27 || mengikuti susunannya
        MainAdapter adapter = new MainAdapter(modelList, this);
        recyclerView.setAdapter(adapter);
    }
}
