package com.ardaayvatas.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    String str ="";
    String output="";
    String calculation="";
    int opt = 1;
    int mult = 0;
    int div = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
    }

    public void clickButton(View view)
    {
        if (str == "NaN")
        {
            str = "";
        }
        switch (view.getId())
        {
            case R.id.zero:
                opt=0;
                str = str +"0";
                textView.setText(str);
                break;
            case R.id.one:
                opt=0;
                str = str +"1";
                textView.setText(str);
                break;
            case R.id.two:
                opt=0;
                str = str +"2";
                textView.setText(str);
                break;
            case R.id.three:
                opt=0;
                str = str +"3";
                textView.setText(str);
                break;
            case R.id.four:
                opt=0;
                str = str +"4";
                textView.setText(str);
                break;
            case R.id.five:
                opt=0;
                str = str +"5";
                textView.setText(str);
                break;
            case R.id.six:
                opt=0;
                str = str +"6";
                textView.setText(str);
                break;
            case R.id.seven:
                opt=0;
                str = str +"7";
                textView.setText(str);
                break;
            case R.id.eight:
                opt=0;
                str = str +"8";
                textView.setText(str);
                break;
            case R.id.nine:
                opt=0;
                str = str +"9";
                textView.setText(str);
                break;
            case R.id.add:
                if (opt==1)
                {
                    break;
                }
                else
                {
                    calculate();
                    if (str=="NaN")
                    {
                        break;
                    }
                    opt=1;
                    str = str +"+";
                    textView.setText(str);
                    break;
                }
            case R.id.substract:
                if (str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    break;
                }
                else
                {
                    calculate();
                    if (str=="NaN")
                    {
                        break;
                    }
                    opt=1;
                    str = str +"-";
                    textView.setText(str);
                    break;
                }
            case R.id.multiply:
                if (opt==1)
                {
                    break;
                }
                else
                {
                    mult = 1;
                    calculate();
                    if (str=="NaN")
                    {
                        mult = 0;
                        break;
                    }
                    opt = 1;
                    str = str + "*";
                    textView.setText(str);
                    break;
                }
            case R.id.divide:
                if (opt==1)
                {
                    break;
                }
                else
                {
                    div = 1;
                    calculate();
                    if (str=="NaN")
                    {
                        div=0;
                        break;
                    }
                    opt=1;
                    str = str +"/";
                    textView.setText(str);
                    break;
                }
            case R.id.delete:
                opt = 1;
                str = "";
                textView.setText(str);
                break;
            case R.id.period:
                if (opt==1)
                {
                    break;
                }
                else
                {
                    opt=1;
                    str = str + ".";
                    textView.setText(str);
                    break;
                }
            case R.id.equal:
                calculate();
                break;
            default:
                break;
        }
    }

    public void calculate()
    {

        if (str.split("[+]").length == 2)
        {
            if(div==0 && mult==0)
            {
                String nums[] = str.split("[+]");
                double result = Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
                output = Double.toString(result);
                textView.setText(output);
                calculation = str;
                str = result + "";
            }

            //Multiply
            if (mult==1)
            {
                if (str.split("[*]").length == 2)
                {
                    String nums[] = str.split("[+]");
                    double result = Double.parseDouble(nums[0]);
                    String nums2[] = nums[1].split("[*]");
                    result = result + Double.parseDouble(nums2[0]) * Double.parseDouble(nums2[1]) ;
                    output = Double.toString(result);
                    textView.setText(output);
                    calculation = str;
                    str = result + "";
                    mult=0;
                }
            }

            //Divide
            if (div==1)
            {
                if (str.split("[/]").length == 2)
                {
                    String nums[] = str.split("[+]");
                    double result = Double.parseDouble(nums[0]);
                    String nums2[] = nums[1].split("[/]");
                    if (Double.parseDouble(nums2[1])==0)
                    {
                        str = "NaN";
                        calculation="";
                        opt=1;
                        div=0;
                    }
                    else
                    {
                        result = result + Double.parseDouble(nums2[0]) / Double.parseDouble(nums2[1]);
                        output = Double.toString(result);
                        textView.setText(output);
                        calculation = str;
                        str = result + "";
                        div = 0;
                    }
                }
            }
        }

        else if (str.split("[-]").length == 2 && str.charAt(0)!='-')
        {
            if(div==0 && mult==0)
            {
                String nums[] = str.split("[-]");
                double result = Double.parseDouble(nums[0]) - Double.parseDouble(nums[1]);
                output = Double.toString(result);
                textView.setText(output);
                calculation = str;
                str = result + "";
            }

            //Multiply
            if (mult==1)
            {
                if (str.split("[*]").length == 2)
                {
                    String nums[] = str.split("[-]");
                    double result = Double.parseDouble(nums[0]);
                    String nums2[] = nums[1].split("[*]");
                    result = result - Double.parseDouble(nums2[0]) * Double.parseDouble(nums2[1]) ;
                    output = Double.toString(result);
                    textView.setText(output);
                    calculation = str;
                    str = result + "";
                    mult=0;
                }
            }

            //Divide
            if (div==1)
            {
                if (str.split("[/]").length == 2)
                {
                    String nums[] = str.split("[-]");
                    double result = Double.parseDouble(nums[0]);
                    String nums2[] = nums[1].split("[/]");
                    if (Double.parseDouble(nums2[1])==0)
                    {
                        str = "NaN";
                        calculation="";
                        opt=1;
                        div=0;
                    }
                    else
                    {
                        result = result - Double.parseDouble(nums2[0]) / Double.parseDouble(nums2[1]) ;
                        output = Double.toString(result);
                        textView.setText(output);
                        calculation = str;
                        str = result + "";
                        div=0;
                    }
                }
            }
        }

        else if (str.split("[-]").length == 3 && str.charAt(0)=='-')
        {
            if(div==0 && mult==0)
            {
                String nums[] = str.split("[-]");
                double result = Double.parseDouble(nums[1]) + Double.parseDouble(nums[2]);
                result = -result;
                output = Double.toString(result);
                textView.setText(output);
                calculation = str;
                str = result + "";
            }

            //Multiply
            if (mult==1)
            {
                if (str.split("[*]").length == 2)
                {
                    String nums[] = str.split("[-]");
                    double result = Double.parseDouble(nums[1]);
                    result = -result;
                    String nums2[] = nums[2].split("[*]");
                    result = result - Double.parseDouble(nums2[0]) * Double.parseDouble(nums2[1]) ;
                    output = Double.toString(result);
                    textView.setText(output);
                    calculation = str;
                    str = result + "";
                    mult=0;
                }
            }

            //Divide
            if (div==1)
            {
                if (str.split("[/]").length == 2)
                {
                    String nums[] = str.split("[-]");
                    double result = Double.parseDouble(nums[1]);
                    result = -result;
                    String nums2[] = nums[2].split("[/]");
                    if (Double.parseDouble(nums2[1])==0)
                    {
                        str = "NaN";
                        calculation="";
                        opt=1;
                        div=0;
                    }
                    else
                    {
                        result = result - Double.parseDouble(nums2[0]) / Double.parseDouble(nums2[1]) ;
                        output = Double.toString(result);
                        textView.setText(output);
                        calculation = str;
                        str = result + "";
                        div=0;
                    }
                }
            }
        }

        else if (str.split("[*]").length == 2)
        {
            String nums[] = str.split("[*]");
            double result = Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]);
            output = Double.toString(result);
            textView.setText(output);
            calculation = str;
            str = result + "";
            mult=0;
        }

        else if (str.split("[/]").length == 2)
        {
            String nums[] = str.split("[/]");
            if (Double.parseDouble(nums[1])==0)
            {
                str = "NaN";
                calculation="";
                opt=1;
                div=0;
            }
            else
            {
                double result = Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
                output = Double.toString(result);
                textView.setText(output);
                calculation = str;
                str = result + "";
                div=0;
            }
        }

        if (str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
        {
            str=str.substring(0,str.length()-1);
            opt=0;
        }

        textView.setText(calculation+"\n\n"+str);
        calculation="";
    }
}