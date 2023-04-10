package com.example.homnayangi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homnayangi.R;
import com.example.homnayangi.model.Note;
import com.example.homnayangi.view.main.NoteActivity;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private NoteActivity context;
    private  int layOut;
    private List<Note> notelist;

    public NoteAdapter(NoteActivity context, int layOut, List<Note> notelist) {
        this.context = context;
        this.layOut = layOut;
        this.notelist = notelist;
    }

    @Override
    public int getCount() {
        return notelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layOut , null);

        TextView txtTen = (TextView) view.findViewById(R.id.txtNoidung);
        ImageView imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
        ImageView imgEdit = (ImageView) view.findViewById(R.id.imgEdit);

        Note note = notelist.get(i);
        txtTen.setText(note.getContent());

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DeleteNote(note.getContent(), note.getId());
            }
        });

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.EditNote(note.getContent(), note.getId());
            }
        });

        return view;
    }
}
