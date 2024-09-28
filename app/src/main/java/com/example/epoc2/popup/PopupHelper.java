package com.example.epoc2.popup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.epoc2.R;

public class PopupHelper {
    private final Context context;

    public PopupHelper(Context context) {
        this.context = context;
    }

    // Método para mostrar la ventana emergente
    public void showPopupWindow(View view) {
        // Inflar el layout del popup
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.epocpopupwindow, null);

        // Crear el PopupWindow
        final PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        // Mostrar el PopupWindow
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // Botón de cerrar en el Popup
        Button closeButton = popupView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(v -> popupWindow.dismiss());

        // Botón de Más Información que abre el navegador
        Button moreInfoButton = popupView.findViewById(R.id.more_info_button);
        moreInfoButton.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://medlineplus.gov/spanish/ency/article/000091.htm"));
            context.startActivity(browserIntent);
        });
    }
}

