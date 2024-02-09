package com.example.part_additem_project;

public class product {
    private String name;
   private String price;
    private int imgid;



    public static final product[] p = {
            new product("chair","50.5", R.drawable.chair),
    };
    public product(String n, String v, int image) {
        this.name =n;
        this.price=v;
        this.imgid =image;
    }
    public String getName(){return name;}
   public  String getprice(){return price;}
    public int getImgid(){return imgid;}
}
 //   RecyclerView recycler= findViewById(R.id.item_recycler);
//        String[] name = new String[product.p.length];
//        String[] price = new String[product.p.length];
//        int[] ids = new int[product.p.length];
//
//        for (int i=0; i<name.length;i++){
//            name[i] =product.p[i].getName();
//            price[i] =product.p[i].getprice();
//            ids[i]=product.p[i].getImgid();
//        }
//
//        recycler.setLayoutManager(new LinearLayoutManager(this));
//        CaptionedItemAdapter adapter = new CaptionedItemAdapter(name,price,ids);
//        recycler.setAdapter(adapter);