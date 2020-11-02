# demo04


一：Intent项目

（1）MainActivity.java

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button btn=findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                EditText url=findViewById(R.id.editText);
                String link=url.getText().toString();
                if (!link.startsWith("https://"))
                {
                    link = "https://" + link;
                }
                Uri uri= Uri.parse(link);
                intent.setData(uri);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
```

(2)Layout.xml布局文件

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/editText"
        android:layout_width="0dp"

        android:layout_height="wrap_content"
        android:layout_marginTop="124dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"></EditText>

    <Button
        android:id="@+id/button2"
        android:layout_width="179dp"
        android:layout_height="wrap_content"
        android:text="@string/button"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.314"></Button>


</androidx.constraintlayout.widget.ConstraintLayout>

```

(3)实验截图：

![image-20201102224917359](https://github.com/wangwang01-wzx/demo04/blob/master/image-20201102224917359.png)

（4）点击浏览该网页按钮：

![image-20201102224949046](https://github.com/wangwang01-wzx/demo04/blob/master/image-20201102224949046.png)



二：WebView项目

（1）MainActivity.java

```java
public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
       // webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        webView.loadUrl(Objects.requireNonNull(getIntent().getData()).toString());
    }
    }

```

(1)activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

(3)运行截图：

![image-20201102225017941](https://github.com/wangwang01-wzx/demo04/blob/master/image-20201102225017941.png)
