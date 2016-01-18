package com.example.elebese.onlinestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.elebese.onlinestore.services.Impl.AddCarService;
import com.example.elebese.onlinestore.services.Impl.AddCarServiceImpl;


/**
 * Created by elebese on 2016/01/18.
 */
public class Car extends AppCompatActivity {
    private EditText model;
    private EditText milage;
    private Button add;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        milage = (EditText)findViewById(R.id.txtMilage);
        model = (EditText)findViewById(R.id.txtModel);
        add = (Button)findViewById(R.id.btnAddCar);
        scrollView = (ScrollView)findViewById(R.id.scrollViewCustomer);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(model.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    model.requestFocus();
                    model.setError("Cannot be empty.");
                }else if(milage.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    milage.requestFocus();
                    milage.setError("Cannot be empty.");
                } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                AddCarService service = new AddCarServiceImpl();

                                Car car = new Car();
                                car.setM(firstName.getText().toString());
                                user.setLastName(LastName.getText().toString());
                                user.setPhoneNumber(PhoneNumber.getText().toString());
                                AddressEmbeddable addressStr = new AddressEmbeddable();
                                addressStr.setAddress(Address.getText().toString());
                                addressStr.setCity(City.getText().toString());
                                addressStr.setPostalCode(PostalCode.getText().toString());
                                user.setAddressEmbeddable(addressStr);
                                user.setRentals(null);

                                userExists = service.save(user);
                            }
                        });

                        thread.start();

                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (userExists==null) {
                            //Go to Login page, send username to txtLoginUsername

                            Intent openStep = new Intent(customer_details.this, motorcycle_rental.class);
                            //openStep.putExtra("FirstName", firstName.getText().toString());
                            startActivity(openStep);
                            finish();
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    }
                }
    }
}
