package com.heima.rxvolleydemogetandpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.toolbox.Loger;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    public static void RxVolleyDemo()
    {
//        get请求方式：打RxVolley这对象然后调用get方法，里面一上传数据的类型为string的xml地址，一new httpcallback方法，
//        之后直接自动补码生成onsuccess重写方法。再在里面修改方法内容。
//        调用loger的debug方法.
        RxVolley.get("http://XXXX.xml", new HttpCallback() {
            @Override
            public void onSuccess(String t)
            {
                Loger.debug("请求到的数据"+t);
            }
        });

//        post请求方式：先创建httpparams类的params对象，然后用这对象调用put方法，里面参数可以先写,来确定前后可以是什么类型
//            一般都是string类型，第三个put方法功能指定某文件上传，参数设置上格式是new File("")导入File包
//            下面一步跟get请求一样。不过post里面有3个参数，其中中间就是上面创建的params对象。
//        一般上传增删，大数据，要求安全性建议用post方法。而小数据的查询用get。
        HttpParams params = new HttpParams();
        params.put("name","kymjs");
        params.put("age",18);
        params.put("image",new File("path"));//文件上传

        RxVolley.post("http:/xxx/xx.xml", params, new HttpCallback() {
            @Override
            public void onSuccess(String t)
            {
                Loger.debug("请求到的数据"+t);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
