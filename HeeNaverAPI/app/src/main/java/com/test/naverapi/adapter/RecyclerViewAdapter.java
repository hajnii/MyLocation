package com.test.naverapi.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.naverapi.R;
import com.test.naverapi.data.DatabaseHandler;
import com.test.naverapi.model.Translation;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Translation> translationArrayList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView beforeLanguageTxt;
        TextView afterLanguageTxt;
        TextView beforeTxt;
        TextView afterTxt;
        ImageView deleteImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            beforeLanguageTxt = itemView.findViewById(R.id.beforeLanguageTxt);
            afterLanguageTxt = itemView.findViewById(R.id.afterLanguageTxt);
            beforeTxt = itemView.findViewById(R.id.beforeTxt);
            afterTxt = itemView.findViewById(R.id.afterTxt);
            deleteImg = itemView.findViewById(R.id.deleteImg);

            deleteImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("삭제");
                    alert.setMessage("정말 삭제 하시겠습니까?");
                    alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (translationArrayList.size()>0){
                                Translation translation =translationArrayList.get(getAdapterPosition());
                                DatabaseHandler handler = new DatabaseHandler(context);
                                handler.deleteTranslation(translation);
                                translationArrayList = handler.getAllTranslation();
                                notifyDataSetChanged();
                            }else {
                                Toast.makeText(context, "삭제할 수 없습니다.", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    alert.setNegativeButton("NO",null);
                    alert.setCancelable(false);
                    alert.show();


                }
            });
        }
    }

    public RecyclerViewAdapter(Context context, ArrayList<Translation> translationArrayList) {
        this.context = context;
        this.translationArrayList = translationArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Translation translation = translationArrayList.get(position);
        String translationTxt = translation.getTranslatedText();
        String input = translation.getInputTxt();
        String srcType = translation.getSrcLangType();
        String tarType = translation.getTarLangType();
        if(srcType.equals("ko")){
            srcType = "한국어";
        }else if (srcType.equals("zh-CN")){
            srcType = "중국어 간체";
        }else if (srcType.equals("zh-TW")){
            srcType = "중국어 번체";
        }else if (srcType.equals("th")){
            srcType = "태국어";
        }else if (srcType.equals("en")){
            srcType = "영어";
        }else {
            srcType = "";
        }

        if (tarType.equals("ko")){
            tarType = "한국어";
        }else if (tarType.equals("zh-CN")){
            tarType = "중국어 간체";
        }else if (tarType.equals("zh-TW")){
            tarType = "중국어 번체";
        }else if (tarType.equals("th")){
            tarType = "태국어";
        }else if (tarType.equals("en")){
            tarType = "영어";
        }else {
            tarType = "";
        }

        holder.afterLanguageTxt.setText(tarType);
        holder.beforeLanguageTxt.setText(srcType);
        holder.beforeTxt.setText("번역전 : "+input);
        holder.afterTxt.setText("번역후 : "+translationTxt);


    }

    @Override
    public int getItemCount() {
        return translationArrayList.size();
    }
}
