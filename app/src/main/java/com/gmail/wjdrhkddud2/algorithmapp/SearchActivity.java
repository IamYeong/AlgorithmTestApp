package com.gmail.wjdrhkddud2.algorithmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.wjdrhkddud2.algorithmapp.search.BinarySearchTree;
import com.gmail.wjdrhkddud2.algorithmapp.search.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;
    private LinearLayout linearHorizontal;
    private Button sequentialButton, binaryButton, treeInsertButton, treeDeleteButton, treeSearchButton;
    private ImageButton shuffleButton;
    private int searchIndex = -1;
    private List<Integer> data;
    private BinarySearchTree tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        data = new ArrayList<>();
        horizontalScrollView = findViewById(R.id.horizontal_search);
        linearHorizontal = findViewById(R.id.linear_horizontal_search);
        shuffleButton = findViewById(R.id.btn_shuffle_search);

        treeInsertButton = findViewById(R.id.btn_tree_insertion_search);
        treeDeleteButton = findViewById(R.id.btn_tree_delete_search);
        treeSearchButton = findViewById(R.id.btn_tree_search);

        sequentialButton = findViewById(R.id.btn_sequential_search);
        binaryButton = findViewById(R.id.btn_binary_search);

        addData();
        updateUI();
        SearchManager manager = new SearchManager();
        tree = manager.convertListToBinarySearchTree(data);


        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffleArray(data);
            }
        });

        sequentialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SearchManager searchManager = new SearchManager();
                searchIndex = searchManager.sequentialSearch(data, 5);

                updateUI();

            }
        });

        binaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SortManager sortManager = new SortManager();
                SearchManager searchManager = new SearchManager();

                sortManager.bubbleSort(data);
                searchIndex = searchManager.binarySearch(data, 5);

                updateUI();

            }
        });

        treeSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BinaryTreeNode<Integer> node = tree.searchTree(5);
                System.out.println("Search node value : " + node.getValue());

            }
        });

        treeInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int k = (int)(Math.random() * 100);
                tree.insertNode(k);
                tree.selectTree(tree.getRoot());
            }
        });

        treeDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tree.deleteNode(8);
                tree.selectTree(tree.getRoot());

            }
        });


    }



    private void updateUI() {

        linearHorizontal.removeAllViews();

        for (int i = 0; i < data.size(); i++) {

            TextView textView = new TextView(SearchActivity.this);
            textView.setText((String.valueOf(data.get(i)) + ", "));
            textView.setId(i);

            if (i == searchIndex) {
                textView.setTextColor(getColor(R.color.design_default_color_error));
            } else {
                textView.setTextColor(getColor(R.color.black));
            }
            textView.setTextSize(15f);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            linearHorizontal.addView(textView);

        }


    }

    private void shuffleArray(List<Integer> array) {

        for (int i = array.size() - 1; i >= 0; i--) {

            int random = (int)(Math.random() * i);
            int j = array.get(random);
            int k = array.get(i);

            array.set(random, k);
            array.set(i, j);

            //System.out.println((array.get(i) + ", "));

        }

        searchIndex = -1;

        updateUI();

        //updateArrayText();

        //return array;
    }


    private void addData() {

        data.clear();

        for (int i = 0; i < 10; i++) {
            data.add(i);
        }

        updateUI();
    }

}