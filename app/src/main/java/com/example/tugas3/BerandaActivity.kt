    package com.example.tugas3

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.tugas3.databinding.ActivityBerandaBinding
    import com.example.tugas3.databinding.ActivityItemMenuBinding


    class BerandaActivity : AppCompatActivity() {
        private lateinit var binding: ActivityBerandaBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityBerandaBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val menuList = listOf(
                MenuItem("Kopi SEO Regal", "Kopi dengan biskuit regal yang creamy", R.drawable.kopi_regal),
                MenuItem("Kopi Susu", "Kopi susu dengan rasa klasik", R.drawable.kopi_susu_gulaaren),
                MenuItem("Kopi Hitam", "Kopi hitam pekat tanpa tambahan", R.drawable.kopi_butterscotch_sea),
                MenuItem("Es Kopi Coklat", "Kombinasi kopi dan coklat yang nikmat", R.drawable.es_kopi_latte)
            )
            binding.recyclerViewMenu.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewMenu.adapter = object : RecyclerView.Adapter<MenuViewHolder>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
                    val binding = ActivityItemMenuBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                    return MenuViewHolder(binding)
                }

                override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
                    val item = menuList[position]
                    with(holder.binding) {
                        imageMenu.setImageResource(item.gambar)
                        NamaMenu.text = item.nama
                        Deskripsi.text = item.deskripsi }
                }

                        override fun getItemCount(): Int = menuList.size
                    }
                }

                class MenuViewHolder(val binding: ActivityItemMenuBinding) :
                    RecyclerView.ViewHolder(binding.root)
            }