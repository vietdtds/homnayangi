package com.example.homnayangi.view.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homnayangi.adapter.NoteAdapter;
import com.example.homnayangi.R;
import com.example.homnayangi.database.NoteDatabase;
import com.example.homnayangi.model.Note;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {
    NoteDatabase db;
    ListView lvNote;
    ArrayList<Note> arrNote;
    NoteAdapter adapter;
    Button btn_addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);
        lvNote = (ListView) findViewById(R.id.listghichu);
        arrNote = new ArrayList<>();
        btn_addNote = (Button) findViewById(R.id.btn_addNote);
        adapter = new NoteAdapter(this, R.layout.note_item, arrNote);
        lvNote.setAdapter(adapter);
        btn_addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNote();
            }
        });
        db = new NoteDatabase(this, "note.sqlite", null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS notes(Id INTEGER PRIMARY KEY AUTOINCREMENT,Content VARCHAR(255))");
        getData();
    }

    private void getData() {
        //Xóa mảng cập nhật dữ liệu mới
        Cursor cs = db.GetData("SELECT * FROM notes");
        //here
        arrNote.clear();
        while (cs.moveToNext()) {
            int id = cs.getInt(0);
            String content = cs.getString(1);
            arrNote.add(new Note(id,content));
        }
        adapter.notifyDataSetChanged();
    }

//ADD NOTE

    private void AddNote() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // bo tieu de hop thoai mac dinh
        dialog.setContentView(R.layout.dialog_note_add); // set noi dung hop thoai
        EditText editThem = dialog.findViewById(R.id.editText);

        Button btnThem = dialog.findViewById(R.id.btnThem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editThem.getText().toString();
                if (content.equals("")) {
                    Toast.makeText(NoteActivity.this, "Vui lòng nhập nội dung ghi chú!", Toast.LENGTH_SHORT).show();
                } else {
                    db.QueryData("INSERT INTO notes VALUES(null,'" + content + "')");
                    dialog.dismiss();
                    getData();
                }
            }
        });

        dialog.show();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

//EDIT NOTE

    public void EditNote(String content , int Id ) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_note_edit);
        EditText edt = (EditText) dialog.findViewById(R.id.edtEdit);
        edt.setText(content);

        Button btnluu = (Button) dialog.findViewById(R.id.btnSave);
        Button btnthoat = (Button) dialog.findViewById(R.id.btnCancel);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = edt.getText().toString();
                if (content.equals("")) {
                    Toast.makeText(NoteActivity.this, "Vui lòng nhập ghi chú cần lưu !", Toast.LENGTH_SHORT).show();
                } else {
                    db.QueryData("UPDATE notes SET Content = '" + content + "' WHERE Id = '" + Id + "' ");
                    Toast.makeText(NoteActivity.this, "Đã sửa ghi chú", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getData();
                }
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

//DELETE NOTE

    public void DeleteNote(String tengc, final int id) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AlertDialog.Builder delete = new AlertDialog.Builder(this);
        delete.setMessage("Bạn có muốn xóa ghi chú \" " + tengc + " \" thật sự?");
        delete.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.QueryData("DELETE FROM notes WHERE Id='" + id + "'");
                dialog.dismiss();
                getData();
            }
        });
        delete.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        delete.show();
    }

}
