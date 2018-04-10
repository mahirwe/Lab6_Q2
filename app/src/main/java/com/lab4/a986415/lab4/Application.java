package com.lab4.a986415.lab4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

import java.util.ArrayList;

public class Application extends android.app.Application {
    static ArrayList<User> users=new ArrayList<>();
    static ArrayList<Product> products=new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        loadData();

    }

    protected void loadData(){
        User usr1=new User("user1@mail.com","123");
        User usr2=new User("user2@mail.com","123");
        User usr3=new User("user3@mail.com","123");
        User usr4=new User("user4@mail.com","123");
        User usr5=new User("user5@mail.com","123");
        Application.users.add(usr1);
        Application.users.add(usr2);
        Application.users.add(usr3);
        Application.users.add(usr4);
        Application.users.add(usr5);
        String dummydescrition="Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. " +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, " +
                "pellentesque eu, pretium quis, " +
                "sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. " ;
        Product  prod1=new Product("Samsung Tablet 12I ","yellow","prod1","1",dummydescrition,100.99);
        Product  prod2=new Product("Printer","blue","prod2","2",dummydescrition,100.99);
        Product  prod3=new Product("PS4","blue","prod3","3",dummydescrition,100.99);
        Product  prod4=new Product("Custom PC 16GB I5","blue","prod4","4",dummydescrition,100.99);
        Product  prod5=new Product("Iphone 923","blue","prod5","5",dummydescrition,100.99);
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);
        products.add(prod5);
    }

    public static Drawable getImageDrawable (String imgname, Context ctx){
        int resourceId = ctx.getResources().getIdentifier(imgname, "drawable",
                ctx.getPackageName());
        return ResourcesCompat.getDrawable(ctx.getResources(), resourceId, null);

    }
}
