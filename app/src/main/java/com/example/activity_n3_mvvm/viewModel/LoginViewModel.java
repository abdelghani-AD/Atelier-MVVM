package com.example.activity_n3_mvvm.viewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.activity_n3_mvvm.BR;
import com.example.activity_n3_mvvm.model.Module;

import java.util.regex.Pattern;

public class LoginViewModel extends BaseObservable {
    private Module module;
    private String successMsg = "Login successful";
    private String errorMsg = "Email Password is not valide";
    @Bindable
    private String toastMsg = null;
    public String getToastMsg(){
        return toastMsg;
    }
    public void setToastMsg(String msg){
        this.toastMsg=msg;
        notifyPropertyChanged(BR.toastMsg);
    }
    public String getUserEmail(){
        return module.getEmail();
    }
    @Bindable
    public void setUserEmail(String email){
        module.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }
    public String getUserPassword(){
        return module.getPassword();
    }
    @Bindable
    public void setUserPassword(String password){
        module.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    public LoginViewModel(){
        module = new Module("","");
    }
    public  void  onButtonClicked(){
        if (isValid()){
            setToastMsg(successMsg);
        }
        else {
            setToastMsg(errorMsg);
        }
    }
    public boolean isValid(){
        return !TextUtils.isEmpty(getUserEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}
