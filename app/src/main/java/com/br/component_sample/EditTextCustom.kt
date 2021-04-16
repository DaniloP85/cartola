package com.br.component_sample

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class EditTextCustom(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private var imgIcon: AppCompatImageView = AppCompatImageView(context)
    private var swtAvaible: SwitchCompat = SwitchCompat(context)
    private var edtField: AppCompatEditText = AppCompatEditText(context)

    init {
        inflate(context, R.layout.layout_edit_text, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextCustomized)
        imgIcon = findViewById(R.id.imv_icon)
        swtAvaible = findViewById(R.id.swt_available)
        edtField = findViewById(R.id.edt_field)

        fieldVisibility()
        localThemeSetup(attributes)

        attributes.recycle()
    }

    private fun localThemeSetup(attributes: TypedArray) {
        val localTheme = attributes.getInt(R.styleable.EditTextCustomized_localTheme, 0)
        setLocalTheme(localTheme)
    }

    private fun setLocalTheme(localTheme: Int) {
        when (localTheme) {
            1 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_secondary))
            }
            2 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_error))
            }
            else -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_surface))
            }
        }
    }

    private fun fieldVisibility() {
        swtAvaible.isChecked = true
        swtAvaible.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                edtField.visibility = VISIBLE
            } else {
                edtField.visibility = INVISIBLE
            }
        }
    }

}