package com.example.gridview1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Context context;
    RelativeLayout gridviewdata;
    ArrayList<ProductModel> productData;
    ProductAdapter productAdapter;
    ProductModel productModel;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        gridView = findViewById(R.id.gridview);
        gridviewdata = (RelativeLayout) findViewById(R.id.gridviewdata);
        productData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        gridView.setOnItemLongClickListener(new ItemLongClickRemove());
        productAdapter = new ProductAdapter(context,productData);
        gridView.setAdapter(productAdapter);
        registerForContextMenu(gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,productData.get(position).getNamedh(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void populateProductData() {
        productModel = new ProductModel();
        productModel.setNamedh("Trà Sữa Cherry");
        productModel.setImages(R.drawable.ts1);
        productModel.setGiadh("23.000 ₫");
        productData.add(productModel);

        //product2
        productModel = new ProductModel();
        productModel.setNamedh("Trà sữa Hẻm");
        productModel.setImages(R.drawable.ts2);
        productModel.setGiadh("55.000₫");
        productData.add(productModel);

        //product3
        productModel = new ProductModel();
        productModel.setNamedh("Milo Dầm BonBon");
        productModel.setImages(R.drawable.ts3);
        productModel.setGiadh("45.000 ₫");
        productData.add(productModel);

        //product4
        productModel = new ProductModel();
        productModel.setNamedh("Trà sữa 100%");
        productModel.setImages(R.drawable.ts4);
        productModel.setGiadh("40.000 ₫");
        productData.add(productModel);

        //product5
        productModel = new ProductModel();
        productModel.setNamedh("Trà sữa Truyền Thống BonBon");
        productModel.setImages(R.drawable.ts5);
        productModel.setGiadh("30.000 ₫");
        productData.add(productModel);

        //product6
        productModel = new ProductModel();
        productModel.setNamedh("Trà sữa Thái Xanh BonBon");
        productModel.setImages(R.drawable.ts6);
        productModel.setGiadh("35.000 ₫");
        productData.add(productModel);
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("Xác Nhận");
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productData.remove(position);
                    //cập nhật lại listview
                    productAdapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}