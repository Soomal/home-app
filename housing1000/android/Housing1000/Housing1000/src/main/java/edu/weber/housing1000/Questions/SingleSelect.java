package edu.weber.housing1000.Questions;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Blake on 1/21/14.
 */
public class SingleSelect extends Question {
    @Override
    public View createView(Context context) {
        //Add question with selections
        LinearLayout qLayout = new LinearLayout(context);
        qLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(context);
        textView.setText(getText());
        qLayout.addView(textView);

        //Add potential answers
        List<String> lstAnswers = new ArrayList<String>();
        lstAnswers.add("");
        String[] arrAnswers = getOptions().split("\\|");
        Collections.addAll(lstAnswers, arrAnswers);

        Spinner spinner = new Spinner(context);
        spinner.setAdapter(new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item,
                lstAnswers));

        qLayout.addView(spinner);

        setView(qLayout);
        return getView();
    }

    @Override
    public String getAnswer() {
        String answer = "";
        LinearLayout layout = (LinearLayout)myView;

        for (int i = 0; i < layout.getChildCount(); i++)
        {
            View childView = layout.getChildAt(i);
            if (childView instanceof Spinner)
            {
                Spinner spinner = (Spinner) childView;

                answer = spinner.getSelectedItem().toString();
            }
        }

        return answer;
    }

    @Override
    public void clearAnswer() {
        LinearLayout layout = (LinearLayout)myView;

        for (int i = 0; i < layout.getChildCount(); i++)
        {
            View childView = layout.getChildAt(i);
            if (childView instanceof Spinner)
            {
                Spinner spinner = (Spinner) childView;
                spinner.setSelection(0);
            }
        }
    }

}
